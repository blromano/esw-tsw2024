import { fastify } from "fastify";
import { fastifyCors } from "@fastify/cors";
import { validatorCompiler, serializerCompiler, ZodTypeProvider, jsonSchemaTransform } from "fastify-type-provider-zod";
import { fastifySwagger } from "@fastify/swagger";
import { fastifySwaggerUi } from "@fastify/swagger-ui";
import { routes } from "./routes";
import { fastifyHelmet } from "@fastify/helmet";
import { fastifyJwt } from "@fastify/jwt";
import z from "zod";

const app = fastify({
  // logger: {
  //   level: "info", // Nível de log (opcional)
  //   transport: {
  //     target: "pino-pretty",
  //     options: {
  //       translateTime: "HH:MM:ss Z",
  //       ignore: "pid,hostname",
  //       destination: "./logs/app.log", // Caminho para o arquivo de log
  //     },
  //   },
  // },
  logger: true,
  ajv: {
    plugins: [require("@fastify/multipart").ajvFilePlugin],
  },
  bodyLimit: 31457280,
}).withTypeProvider<ZodTypeProvider>();

app.setValidatorCompiler(validatorCompiler);
app.setSerializerCompiler(serializerCompiler);

app.register(fastifyHelmet, { global: false });

app.register(require("@fastify/multipart"), {
  limits: {
    fileSize: 5 * 1024 * 1024,
    files: 1,
  },
  attachFieldsToBody: true,
  async onFile(part: any) {
    const buffer = await part.toBuffer();
    part.value = {
      filename: part.filename,
      mimetype: part.mimetype,
      data: buffer,
    };
  },
});

app.register(fastifyJwt, {
  secret: process.env.JWT_SECRET!,
  sign: {
    expiresIn: "1h", // Defina o tempo de expiração do token
  },
});

// app.register(authRoutes);
// app.register(async (authenticatedApp) => {}, { prefix: "/api" });

app.register(fastifyCors, { origin: "*" });

app.register(fastifySwagger, {
  openapi: {
    info: {
      title: "ReportCity API",
      version: "2.0.0",
    },
  },

  transform: jsonSchemaTransform,
});

app.register(fastifySwaggerUi, {
  routePrefix: "/docs",
});

app.register(routes);

app.listen({ port: 3333, host: "0.0.0.0" }, function (err, address) {
  if (err) {
    app.log.error(err);
    process.exit(1);
  }
  app.log.info(`server listening on ${address}`);
});
