import z from "zod";
import { FastifyTypedInstance } from "./types";
import { randomUUID } from "node:crypto";
import path, { extname, resolve } from "node:path";
import { createWriteStream, writeFile, writeFileSync } from "node:fs";
import { mkdir } from "node:fs/promises";
import { db } from "./db";
import { administradores, cidadoes, denuncias, servicosTerceirizados, tarefas } from "../drizzle/schema";
import { and, eq, ne, sql } from "drizzle-orm";
import { validateCpf } from "./utils/validateCPF";
import { compare, compareSync, hash } from "bcrypt";
import { createId } from "@paralleldrive/cuid2";
import { validateCPFMiddleware } from "./middlewares/validateCPFMiddleware";
import { pipeline } from "node:stream/promises";
import { FastifyMultipartOptions } from "@fastify/multipart";
import { FastifyRequest } from "fastify";
import { authMiddleware } from "./middlewares/authMiddleware";
const fs = require("fs");

export async function routes(app: FastifyTypedInstance) {
  // Cidadão
  app.get(
    "/cidadao",
    {
      preHandler: [authMiddleware(app)],
      schema: {
        tags: ["Cidadão"],
        description: "Lista detalhadamente todos os cidadões",
        response: {
          200: z.array(
            z.object({
              publicId: z.string(),
              fullname: z.string(),
              photo: z.any().optional(),
              cellphone: z.string(),
              email: z.string().email(),
              cep: z.string(),
              street: z.string(),
              houseNumber: z.string(),
              houseComplement: z.string().optional(),
              district: z.string(),
              city: z.string(),
              state: z.string(),
            })
          ),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      try {
        const citizens: any = await db
          .select({
            publicId: cidadoes.cidIdPublico,
            fullname: cidadoes.cidNome,
            cellphone: cidadoes.cidCelular,
            email: cidadoes.cidEmail,
            cep: cidadoes.cidCep,
            street: cidadoes.cidRua,
            houseNumber: cidadoes.cidNumero,
            houseComplement: cidadoes.cidComplemento,
            district: cidadoes.cidBairro,
            city: cidadoes.cidCidade,
            state: cidadoes.cidEstado,
            photo: cidadoes.cidFoto,
            status: cidadoes.cidAtivado,
            reason: cidadoes.cidMotivo,
          })
          .from(cidadoes);

        return reply.status(200).send(citizens);
      } catch (err) {
        return reply.status(500).send({ error: "Erro ao buscar cidadãos" });
      }
    }
  );

  app.get(
    "/cidadao/:public_id",
    {
      preHandler: [authMiddleware(app)],
      schema: {
        tags: ["Cidadão"],
        description: "Lista detalhadamente os dados de um cidadão",
        params: z.object({
          public_id: z.string().cuid2().length(24),
        }),
        response: {
          200: z.array(
            z.object({
              publicId: z.string(),
              fullname: z.string(),
              photo: z.any().optional(),
              cellphone: z.string(),
              email: z.string().email(),
              cep: z.string(),
              street: z.string(),
              houseNumber: z.string(),
              houseComplement: z.string().optional(),
              district: z.string(),
              city: z.string(),
              state: z.string(),
            })
          ),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      try {
        const { public_id } = await request.params;

        const citizens: any = await db
          .select({
            publicId: cidadoes.cidIdPublico,
            fullname: cidadoes.cidNome,
            cellphone: cidadoes.cidCelular,
            email: cidadoes.cidEmail,
            cep: cidadoes.cidCep,
            street: cidadoes.cidRua,
            houseNumber: cidadoes.cidNumero,
            houseComplement: cidadoes.cidComplemento,
            district: cidadoes.cidBairro,
            city: cidadoes.cidCidade,
            state: cidadoes.cidEstado,
            photo: cidadoes.cidFoto,
            status: cidadoes.cidAtivado,
            reason: cidadoes.cidMotivo,
          })
          .from(cidadoes)
          .where(eq(cidadoes.cidIdPublico, public_id));

        return reply.status(200).send(citizens);
      } catch (err) {
        return reply.status(500).send({ error: "Erro ao buscar cidadão" });
      }
    }
  );

  app.post(
    "/cidadao",
    {
      preHandler: [validateCPFMiddleware(app)],
      schema: {
        tags: ["Cidadão"],
        description: "Cadastra um novo cidadão",
        body: z
          .object({
            fullname: z.string().nonempty("Nome completo é obrigatório!").max(128),
            imageBase64: z.string().optional(),
            cpf: z.string().length(11).refine(validateCpf, { message: "CPF inválido" }),
            cellphone: z.string().nonempty("Número de celular é obrigatório!").length(11),
            email: z.string().email().nonempty("E-mail obrigatório").max(255),
            cep: z.string().length(8),
            street: z.string().max(255),
            houseNumber: z.string().max(6),
            houseComplement: z.string().max(16).optional(),
            district: z.string().max(64),
            city: z.string().max(32),
            state: z.string().max(64),
            password: z.string().min(8).max(60),
            confirmPassword: z.string().min(8).max(60),
          })
          .refine((data) => data.password === data.confirmPassword, {
            message: "As senhas não coincidem",
            path: ["confirmPassword"],
          }),
        response: {
          201: z.null().describe("Cidadão criado com sucesso"),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      try {
        const bodySchema = z.object({
          fullname: z.string().nonempty("Nome completo é obrigatório!").max(128),
          imageBase64: z.string().optional(),
          cpf: z.string().length(11).refine(validateCpf, { message: "CPF inválido" }),
          cellphone: z.string().nonempty("Número de celular é obrigatório!").length(11),
          email: z.string().email().nonempty("E-mail obrigatório").max(255),
          cep: z.string().length(8),
          street: z.string().max(255),
          houseNumber: z.string().max(6),
          houseComplement: z.string().max(16).optional(),
          district: z.string().max(64),
          city: z.string().max(32),
          state: z.string().max(64),
          password: z.string().max(60),
        });

        const { fullname, imageBase64, cpf, cellphone, email, cep, street, houseNumber, houseComplement, district, city, state, password } = bodySchema.parse(await request.body);

        // Verificar se CPF já existe
        const existingCpf = await db.select().from(cidadoes).where(eq(cidadoes.cidCpf, cpf));
        if (existingCpf.length > 0) {
          return reply.status(400).send({ error: "CPF já cadastrado" });
        }

        // Verificar se email já existe
        const existingEmail = await db.select().from(cidadoes).where(eq(cidadoes.cidEmail, email));
        if (existingEmail.length > 0) {
          return reply.status(400).send({ error: "Email já cadastrado" });
        }

        // Hash da senha
        const hashedPassword = await hash(password, 12);

        // Configurações do diretório
        const uploadDir = path.resolve(__dirname, "../../uploads");
        await mkdir(uploadDir, { recursive: true });

        let imagePath: string | null = null;

        if (imageBase64) {
          const filename = `${createId()}.png`; // Ou .jpg, dependendo do formato da imagem
          imagePath = path.join(uploadDir, filename);

          const base64Image: any = imageBase64.split(";base64,").pop();
          const buffer = Buffer.from(base64Image, "base64");
          await fs.writeFileSync(imagePath, buffer, (err: any) => {
            if (err) {
              console.error(err);
            }
          });
        }

        // Inserir no banco de dados
        await db.insert(cidadoes).values({
          cidIdPrivado: sql`DEFAULT`,
          cidIdPublico: createId(),
          cidNome: fullname,
          cidFoto: imagePath,
          cidCpf: cpf,
          cidCelular: cellphone,
          cidEmail: email,
          cidCep: cep,
          cidRua: street,
          cidNumero: houseNumber,
          cidComplemento: houseComplement,
          cidBairro: district,
          cidCidade: city,
          cidEstado: state,
          cidSenha: hashedPassword,
        });

        return reply.status(201).send();
      } catch (error) {
        console.error("Erro no cadastro:", error);
        return reply.status(500).send({ error: "Erro interno no servidor" });
      }
    }
  );

  app.patch(
    "/cidadao/photo/:public_id",
    {
      preHandler: [authMiddleware(app)],
      schema: {
        tags: ["Cidadão"],
        description: "Atualiza a foto de perfil do cidadão",
        body: z.object({
          imageBase64: z.string(),
        }),
        params: z.object({
          public_id: z.string().cuid2().length(24),
        }),
      },
    },
    async (request, reply) => {
      const { imageBase64 } = await request.body;
      const { public_id } = await request.params;

      // Configurações do diretório
      const uploadDir = path.resolve(__dirname, "../../uploads");
      await mkdir(uploadDir, { recursive: true });

      let imagePath: string | null = null;

      if (imageBase64) {
        const filename = `${createId()}.png`; // Ou .jpg, dependendo do formato da imagem
        imagePath = path.join(uploadDir, filename);

        const base64Image: any = imageBase64.split(";base64,").pop();
        const buffer = Buffer.from(base64Image, "base64");
        await fs.writeFileSync(imagePath, buffer, (err: any) => {
          if (err) {
            console.error(err);
          }
        });
      }

      await db.update(cidadoes).set({ cidFoto: imagePath }).where(eq(cidadoes.cidIdPublico, public_id));
    }
  );

  app.put(
    "/cidadao/:public_id",
    {
      preHandler: [authMiddleware(app)],
      schema: {
        tags: ["Cidadão"],
        description: "Atualiza os dados de cadastro do cidadão",
        body: z.object({
          fullname: z.string().nonempty("Nome completo é obrigatório!").max(128),
          cellphone: z.string().nonempty("Número de celular é obrigatório!").length(11),
          email: z.string().email().nonempty("E-mail obrigatório").max(255),
          cep: z.string().length(8),
          street: z.string().max(255),
          houseNumber: z.string().max(6),
          houseComplement: z.string().max(16).optional(),
          district: z.string().max(64),
          city: z.string().max(32),
          state: z.string().max(64),
        }),
        params: z.object({
          public_id: z.string().cuid2().length(24),
        }),
        response: {
          201: z.null().describe("Cidadão criado com sucesso"),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      try {
        const bodySchema = z.object({
          fullname: z.string().nonempty("Nome completo é obrigatório!").max(128),
          cellphone: z.string().nonempty("Número de celular é obrigatório!").length(11),
          email: z.string().email().nonempty("E-mail obrigatório").max(255),
          cep: z.string().length(8),
          street: z.string().max(255),
          houseNumber: z.string().max(6),
          houseComplement: z.string().max(16).optional(),
          district: z.string().max(64),
          city: z.string().max(32),
          state: z.string().max(64),
        });
        const paramSchema = z.object({
          public_id: z.string().cuid2().length(24),
        });

        const { fullname, cellphone, email, cep, street, houseNumber, houseComplement, district, city, state } = bodySchema.parse(await request.body);

        const { public_id } = paramSchema.parse(await request.params);

        // Verificar se email já existe
        const existingEmail = await db
          .select()
          .from(cidadoes)
          .where(and(eq(cidadoes.cidEmail, email), ne(cidadoes.cidIdPublico, public_id)));
        if (existingEmail.length > 0) {
          return reply.status(400).send({ error: "Email já cadastrado por outro usuário" });
        }

        // Verificar se o celular já existe
        const existingCellphone = await db
          .select()
          .from(cidadoes)
          .where(and(eq(cidadoes.cidCelular, cellphone), ne(cidadoes.cidIdPublico, public_id)));
        if (existingCellphone.length > 0) {
          return reply.status(400).send({ error: "Celular já cadastrado por outro usuário" });
        }

        // Inserir no banco de dados
        await db
          .update(cidadoes)
          .set({
            cidNome: fullname,
            cidCelular: cellphone,
            cidEmail: email,
            cidCep: cep,
            cidRua: street,
            cidNumero: houseNumber,
            cidComplemento: houseComplement,
            cidBairro: district,
            cidCidade: city,
            cidEstado: state,
          })
          .where(eq(cidadoes.cidIdPublico, public_id));

        return reply.status(201).send();
      } catch (err: any) {
        console.error("Erro no cadastro:", err);
        return reply.status(500).send({ error: "Erro interno no servidor" });
      }
    }
  );

  app.post(
    "/cidadao/login",
    {
      schema: {
        tags: ["Cidadão"],
        description: "Autentica um cidadão",
        body: z.object({
          email: z.string().email(),
          password: z.string(),
        }),
        response: {
          200: z.object({
            public_id: z.string().cuid2().length(24),
            token: z.string(),
          }),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      const { email, password } = await request.body;

      if (!password) {
        return reply.status(400).send({ error: "A senha é obrigatória" });
      }

      // Buscar o cidadão pelo email
      const cidadao = await db.select().from(cidadoes).where(eq(cidadoes.cidEmail, email));

      if (!cidadao[0]) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      if (!cidadao[0].cidSenha) {
        console.error("Erro: Senha do usuário não definida no banco de dados.");
        return reply.status(500).send({ error: "Erro interno do servidor" });
      }

      //Verificar a senha
      const isPasswordValid = await compare(password, cidadao[0].cidSenha);

      if (!isPasswordValid) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      try {
        // Gerar o token JWT
        const token = app.jwt.sign({ id: cidadao[0].cidIdPrivado });
        const public_id = cidadao[0].cidIdPublico;

        // Atualizar o token do usuário no banco de dados
        await db.update(cidadoes).set({ cidToken: token }).where(eq(cidadoes.cidIdPrivado, cidadao[0].cidIdPrivado));

        return { public_id, token };
      } catch (err) {
        request.log.error("Erro ao gerar o token JWT:", err);
        return reply.status(500).send({ error: "Erro ao gerar o token" });
      }
    }
  );

  app.post(
    "/cliente/denuncia/:public_id",
    {
      preHandler: [authMiddleware(app)],
      schema: {
        tags: ["Cidadão", "Denuncia"],
        description: "Cadastra a denúncia de um cidadão no sistema",
        body: z.object({
          latitude: z.string(),
          longitude: z.string(),
          imageBase64: z.string(),
          titulo: z.string(),
          descricao: z.string(),
          tipo: z.enum(["BURACO NA VIA", "BURACO NA CALÇADA", "POSTE DANIFICADO", "ÁRVORE CAÍDA", "REDE ELÉTRICA DANIFICADA"]),
        }),
        params: z.object({
          public_id: z.string().cuid2().length(24),
        }),
        response: {
          201: z.null().describe("Cidadão criado com sucesso"),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      const { latitude, longitude, imageBase64, titulo, descricao, tipo } = request.body;
      const { public_id } = request.params;

      // Verificar se o cidadão já existe
      const existingCitizen = await db.select().from(cidadoes).where(eq(cidadoes.cidIdPublico, public_id));
      if (existingCitizen.length > 0) {
        return reply.status(400).send({ error: "Cidadão não existe" });
      }

      // Configurações do diretório
      const uploadDir = path.resolve(__dirname, "../../uploads");
      await mkdir(uploadDir, { recursive: true });

      let imagePath: string | null = null;

      if (imageBase64) {
        const filename = `${createId()}.png`; // Ou .jpg, dependendo do formato da imagem
        imagePath = path.join(uploadDir, filename);

        const base64Image: any = imageBase64.split(";base64,").pop();
        const buffer = Buffer.from(base64Image, "base64");
        await fs.writeFileSync(imagePath, buffer, (err: any) => {
          if (err) {
            console.error(err);
          }
        });
      }

      try {
        await db.insert(denuncias).values({
          denIdPublico: createId(),
          denTipo: tipo,
          denTitulo: titulo,
          denDescricao: descricao,
          denImagem: imagePath!,
          denLatitude: latitude,
          denLongitude: longitude,
          fkCidIdPrivado: Number(public_id),
        });

        return reply.status(201).send();
      } catch (err: any) {
        return reply.status(500).send({ error: "Erro interno no servidor" });
      }
    }
  );

  // Serviço Terceirizado
  app.post(
    "/terceirizado",
    {
      preHandler: [validateCPFMiddleware(app), authMiddleware(app)],
      schema: {
        tags: ["Serviço Terceirizado"],
        description: "Cadastra um novo Serviço Terceirizado",
        body: z
          .object({
            fullname: z.string().nonempty("Nome completo é obrigatório!").max(128),
            imageBase64: z.string(),
            cpf: z.string().length(11).refine(validateCpf, { message: "CPF inválido" }),
            cellphone: z.string().nonempty("Número de celular é obrigatório!").length(11),
            email: z.string().email().nonempty("E-mail obrigatório").max(255),
            areaId: z.bigint(),
            password: z.string().min(8).max(60),
            confirmPassword: z.string().min(8).max(60),
          })
          .refine((data) => data.password === data.confirmPassword, {
            message: "As senhas não coincidem",
            path: ["confirmPassword"],
          }),
        response: {
          201: z.null().describe("Cidadão criado com sucesso"),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      try {
        const bodySchema = z.object({
          fullname: z.string().nonempty("Nome completo é obrigatório!").max(128),
          imageBase64: z.string(),
          cpf: z.string().length(11).refine(validateCpf, { message: "CPF inválido" }),
          cellphone: z.string().nonempty("Número de celular é obrigatório!").length(11),
          email: z.string().email().nonempty("E-mail obrigatório").max(255),
          areaId: z.bigint(),
          password: z.string().min(8).max(60),
        });

        const { fullname, imageBase64, cpf, cellphone, email, areaId, password } = bodySchema.parse(await request.body);

        // Verificar se CPF já existe
        const existingCpf = await db.select().from(servicosTerceirizados).where(eq(servicosTerceirizados.serCpf, cpf));
        if (existingCpf.length > 0) {
          return reply.status(400).send({ error: "CPF já cadastrado" });
        }

        // Verificar se email já existe
        const existingEmail = await db.select().from(servicosTerceirizados).where(eq(servicosTerceirizados.serEmail, email));
        if (existingEmail.length > 0) {
          return reply.status(400).send({ error: "Email já cadastrado" });
        }

        // Hash da senha
        const hashedPassword = await hash(password, 12);

        // Configurações do diretório
        const uploadDir = path.resolve(__dirname, "../../uploads");
        await mkdir(uploadDir, { recursive: true });

        let imagePath: string | null = null;

        if (imageBase64) {
          const filename = `${createId()}.png`; // Ou .jpg, dependendo do formato da imagem
          imagePath = path.join(uploadDir, filename);

          const base64Image: any = imageBase64.split(";base64,").pop();
          const buffer = Buffer.from(base64Image, "base64");
          await fs.writeFileSync(imagePath, buffer, (err: any) => {
            if (err) {
              console.error(err);
            }
          });
        }

        // Inserir no banco de dados
        await db.insert(servicosTerceirizados).values({
          serIdPublico: createId(),
          serNome: fullname,
          serFoto: imagePath,
          serCelular: cellphone,
          serCpf: cpf,
          serEmail: email,
          serSenha: hashedPassword,
          fkAreId: Number(areaId),
        });

        return reply.status(201).send();
      } catch (error) {
        console.error("Erro no cadastro:", error);
        return reply.status(500).send({ error: "Erro interno no servidor" });
      }
    }
  );

  app.post(
    "/terceirizado/login",
    {
      schema: {
        tags: ["Serviço Terceirizado"],
        description: "Autentica um Serviço Terceirizado",
        body: z.object({
          email: z.string().email(),
          password: z.string(),
        }),
        response: {
          200: z.object({
            public_id: z.string().cuid2().length(24),
            token: z.string(),
          }),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      const { email, password } = await request.body;

      if (!password) {
        return reply.status(400).send({ error: "A senha é obrigatória" });
      }

      // Buscar o cidadão pelo email
      const servicoTerceirizado = await db.select().from(servicosTerceirizados).where(eq(servicosTerceirizados.serEmail, email));

      if (!servicoTerceirizado[0]) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      if (!servicoTerceirizado[0].serSenha) {
        console.error("Erro: Senha do usuário não definida no banco de dados.");
        return reply.status(500).send({ error: "Erro interno do servidor" });
      }

      //Verificar a senha
      const isPasswordValid = await compare(password, servicoTerceirizado[0].serSenha);

      if (!isPasswordValid) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      try {
        // Gerar o token JWT
        const token = app.jwt.sign({ id: servicoTerceirizado[0].serIdPrivado });
        const public_id = servicoTerceirizado[0].serIdPublico;

        // Atualizar o token do usuário no banco de dados
        await db.update(servicosTerceirizados).set({ serToken: token }).where(eq(servicosTerceirizados.serIdPrivado, servicoTerceirizado[0].serIdPrivado));

        return { public_id, token };
      } catch (err) {
        request.log.error("Erro ao gerar o token JWT:", err);
        return reply.status(500).send({ error: "Erro ao gerar o token" });
      }
    }
  );

  app.get(
    "/terceirizado/tarefa/:public_id",
    {
      preHandler: [authMiddleware(app)],
      schema: {
        tags: ["Serviço Terceirizado"],
        description: "Lista todas as tarefas cadastradas para um Serviço Terceirizado",
        params: z.object({
          public_id: z.string().cuid2().length(24),
        }),
        response: {
          201: z.array(
            z.object({
              public_id: z.string().cuid2().length(24),
              name: z.string(),
              description: z.string(),
              created_at: z.any(),
              chamados: z.any(),
              report_private_id: z.any(),
            })
          ),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      const { public_id } = request.params;

      const private_id = await db.select().from(servicosTerceirizados).where(eq(servicosTerceirizados.serIdPublico, public_id));

      console.log(private_id);

      const tarefa = await db
        .select({
          public_id: tarefas.tarIdPublico,
          name: tarefas.tarNome,
          description: tarefas.tarDescricao,
          created_at: tarefas.tarCreatedAt,
          chamados: tarefas.tarChamados!,
          report_private_id: tarefas.fkDenIdPrivado!,
        })
        .from(tarefas)
        .where(eq(tarefas.fkSerIdPrivado, private_id[0].serIdPrivado));

      reply.status(200).send(tarefa);
    }
  );

  // Administrador
  app.post(
    "/administrador/login",
    {
      schema: {
        tags: ["Administrador"],
        description: "Autentica um Administrador",
        body: z.object({
          email: z.string().email(),
          password: z.string(),
        }),
        response: {
          200: z.object({
            public_id: z.string().cuid2().length(24),
            token: z.string(),
          }),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      const { email, password } = await request.body;

      if (!password) {
        return reply.status(400).send({ error: "A senha é obrigatória" });
      }

      // Buscar o cidadão pelo email
      const administrador = await db.select().from(administradores).where(eq(administradores.admEmail, email));

      if (!administrador[0]) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      if (!administrador[0].admSenha) {
        console.error("Erro: Senha do usuário não definida no banco de dados.");
        return reply.status(500).send({ error: "Erro interno do servidor" });
      }

      //Verificar a senha
      const isPasswordValid = await compare(password, administrador[0].admSenha);

      if (!isPasswordValid) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      try {
        // Gerar o token JWT
        const token = app.jwt.sign({ id: administrador[0].admIdPrivado });
        const public_id = administrador[0].admIdPublico;

        // Atualizar o token do usuário no banco de dados
        await db.update(administradores).set({ admToken: token }).where(eq(administradores.admIdPrivado, administrador[0].admIdPrivado));

        return { public_id, token };
      } catch (err) {
        request.log.error("Erro ao gerar o token JWT:", err);
        return reply.status(500).send({ error: "Erro ao gerar o token" });
      }
    }
  );

  // Gerente

  app.post(
    "/gerente/login",
    {
      schema: {
        tags: ["Gerente"],
        description: "Autentica um Gerente",
        body: z.object({
          email: z.string().email(),
          password: z.string(),
        }),
        response: {
          200: z.object({
            public_id: z.string().cuid2().length(24),
            token: z.string(),
          }),
          400: z.object({
            error: z.string(),
          }),
          500: z.object({
            error: z.string(),
          }),
        },
      },
    },
    async (request, reply) => {
      const { email, password } = await request.body;

      if (!password) {
        return reply.status(400).send({ error: "A senha é obrigatória" });
      }

      // Buscar o cidadão pelo email
      const administrador = await db.select().from(administradores).where(eq(administradores.admEmail, email));

      if (!administrador[0]) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      if (!administrador[0].admSenha) {
        console.error("Erro: Senha do usuário não definida no banco de dados.");
        return reply.status(500).send({ error: "Erro interno do servidor" });
      }

      //Verificar a senha
      const isPasswordValid = await compare(password, administrador[0].admSenha);

      if (!isPasswordValid) {
        return reply.status(401).send({ error: "Credenciais inválidas" });
      }

      try {
        // Gerar o token JWT
        const token = app.jwt.sign({ id: administrador[0].admIdPrivado });
        const public_id = administrador[0].admIdPublico;

        // Atualizar o token do usuário no banco de dados
        await db.update(administradores).set({ admToken: token }).where(eq(administradores.admIdPrivado, administrador[0].admIdPrivado));

        return { public_id, token };
      } catch (err) {
        request.log.error("Erro ao gerar o token JWT:", err);
        return reply.status(500).send({ error: "Erro ao gerar o token" });
      }
    }
  );
}
