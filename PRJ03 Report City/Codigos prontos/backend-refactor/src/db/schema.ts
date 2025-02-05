import {
  mysqlTable,
  mysqlSchema,
  AnyMySqlColumn,
  primaryKey,
  unique,
  int,
  char,
  varchar,
  foreignKey,
  decimal,
  timestamp,
  mysqlEnum,
  tinyint,
  bigint,
} from "drizzle-orm/mysql-core";
import { sql } from "drizzle-orm";

export const administradores = mysqlTable(
  "ADMINISTRADORES",
  {
    admIdPrivado: bigint("ADM_ID_PRIVADO", { mode: "number", unsigned: true }).notNull().autoincrement(),
    admIdPublico: char("ADM_ID_PUBLICO", { length: 24 }).notNull(),
    admNome: varchar("ADM_NOME", { length: 128 }).notNull(),
    admEmail: varchar("ADM_EMAIL", { length: 255 }).notNull(),
    admSenha: char("ADM_SENHA", { length: 60 }).notNull(),
  },
  (table) => [primaryKey({ columns: [table.admIdPrivado], name: "ADM_ID_PRIVADO" }), unique("ADM_EMAIL").on(table.admEmail, table.admIdPublico)]
);

export const areas = mysqlTable(
  "AREAS",
  {
    areId: bigint("ARE_ID", { mode: "number", unsigned: true }).notNull().autoincrement(),
    areNome: varchar("ARE_NOME", { length: 64 }).notNull(),
    areDescricao: varchar("ARE_DESCRICAO", { length: 255 }).notNull(),
  },
  (table) => [primaryKey({ columns: [table.areId], name: "ARE_ID" })]
);

export const cidadoes = mysqlTable(
  "CIDADOES",
  {
    cidIdPublico: char("CID_ID_PUBLICO", { length: 24 }),
    cidIdPrivado: bigint("CID_ID_PRIVADO", { mode: "number", unsigned: true }).notNull().autoincrement(),
    cidNome: varchar("CID_NOME", { length: 128 }).notNull(),
    cidFoto: varchar("CID_FOTO", { length: 1024 }),
    cidCpf: char("CID_CPF", { length: 11 }).notNull(),
    cidCelular: char("CID_CELULAR", { length: 11 }).notNull(),
    cidEmail: varchar("CID_EMAIL", { length: 255 }).notNull(),
    cidCep: char("CID_CEP", { length: 8 }).notNull(),
    cidRua: varchar("CID_RUA", { length: 255 }).notNull(),
    cidNumero: varchar("CID_NUMERO", { length: 6 }).notNull(),
    cidComplemento: varchar("CID_COMPLEMENTO", { length: 16 }),
    cidBairro: varchar("CID_BAIRRO", { length: 64 }).notNull(),
    cidCidade: varchar("CID_CIDADE", { length: 32 }).notNull(),
    cidEstado: varchar("CID_ESTADO", { length: 64 }).notNull(),
    cidSenha: char("CID_SENHA", { length: 60 }).notNull(),
    cidCodRecuperacao: char("CID_COD_RECUPERACAO", { length: 8 }),
    cidAtivado: tinyint("CID_ATIVADO").default(1).notNull(),
    cidMotivo: varchar("CID_MOTIVO", { length: 255 }),
    cidToken: varchar("CID_TOKEN", { length: 1024 }),
  },
  (table) => [
    primaryKey({ columns: [table.cidIdPrivado], name: "CID_ID_PRIVADO" }),
    unique("CID_ID_PUBLICO").on(table.cidIdPublico, table.cidEmail, table.cidCpf, table.cidCodRecuperacao, table.cidCelular),
  ]
);

export const denuncias = mysqlTable(
  "DENUNCIAS",
  {
    denIdPrivado: bigint("DEN_ID_PRIVADO", { mode: "number", unsigned: true }).notNull().autoincrement(),
    denIdPublico: char("DEN_ID_PUBLICO", { length: 24 }).notNull(),
    denTitulo: varchar("DEN_TITULO", { length: 64 }).notNull(),
    denDescricao: varchar("DEN_DESCRICAO", { length: 255 }).notNull(),
    denLatitude: decimal("DEN_LATITUDE", { precision: 13, scale: 10 }).notNull(),
    denLongitude: decimal("DEN_LONGITUDE", { precision: 13, scale: 10 }).notNull(),
    denCreatedAt: timestamp("DEN_CREATED_AT", { mode: "string" }).defaultNow().notNull(),
    denUpdatedAt: timestamp("DEN_UPDATED_AT", { mode: "string" }).defaultNow().onUpdateNow().notNull(),
    denFeedback: varchar("DEN_FEEDBACK", { length: 1024 }),
    denImagem: varchar("DEN_IMAGEM", { length: 1024 }).notNull(),
    denTipo: mysqlEnum("DEN_TIPO", ["BURACO NA VIA", "BURACO NA CALÇADA", "POSTE DANIFICADO", "ÁRVORE CAÍDA", "REDE ELÉTRICA DANIFICADA"]).notNull(),
    fkCidadoesCidIdPrivado: bigint("FK_CID_ID_PRIVADO", { mode: "number", unsigned: true }).references(() => cidadoes.cidIdPrivado, { onDelete: "cascade" }),
    fkStatusStaId: tinyint("FK_STA_ID", { unsigned: true }).references(() => status.staId, { onDelete: "cascade" }),
  },
  (table) => [primaryKey({ columns: [table.denIdPrivado], name: "DEN_ID_PRIVADO" }), unique("DEN_ID_PUBLICO").on(table.denIdPublico)]
);

export const departamentos = mysqlTable(
  "DEPARTAMENTOS",
  {
    depId: tinyint("DEP_ID", { unsigned: true }).notNull().autoincrement(),
    depNome: varchar("DEP_NOME", { length: 64 }).notNull(),
    depDescricao: varchar("DEP_DESCRICAO", { length: 255 }).notNull(),
  },
  (table) => [primaryKey({ columns: [table.depId], name: "DEP_ID" })]
);

export const gerentes = mysqlTable(
  "GERENTES",
  {
    gerIdPublico: char("GER_ID_PUBLICO", { length: 24 }).notNull(),
    gerIdPrivado: bigint("GER_ID_PRIVADO", { mode: "number", unsigned: true }).notNull().autoincrement(),
    gerFoto: varchar("GER_FOTO", { length: 1024 }),
    gerNome: varchar("GER_NOME", { length: 255 }).notNull(),
    gerCpf: char("GER_CPF", { length: 11 }).notNull(),
    gerEmail: varchar("GER_EMAIL", { length: 255 }).notNull(),
    gerSenha: char("GER_SENHA", { length: 60 }).notNull(),
    fkDepartamentosDepId: tinyint("FK_DEP_ID", { unsigned: true })
      .notNull()
      .references(() => departamentos.depId, { onDelete: "cascade" }),
    fkAdministradoresAdmIdPrivado: bigint("FK_ADM_ID_PRIVADO", { mode: "number", unsigned: true })
      .notNull()
      .references(() => administradores.admIdPrivado, { onDelete: "cascade" }),
  },
  (table) => [primaryKey({ columns: [table.gerIdPrivado], name: "GER_ID_PRIVADO" }), unique("GER_ID_PUBLICO").on(table.gerIdPublico, table.gerCpf, table.gerEmail)]
);

export const servicosTerceirizados = mysqlTable(
  "SERVICOS_TERCEIRIZADOS",
  {
    serIdPrivado: bigint("SER_ID_PRIVADO", { mode: "number", unsigned: true }).notNull().autoincrement(),
    serIdPublico: char("SER_ID_PUBLICO", { length: 24 }).notNull(),
    serNome: varchar("SER_NOME", { length: 255 }).notNull(),
    serFoto: varchar("SER_FOTO", { length: 1024 }),
    serCpf: char("SER_CPF", { length: 11 }).notNull(),
    serCelular: char("SER_CELULAR", { length: 11 }).notNull(),
    serEmail: varchar("SER_EMAIL", { length: 255 }).notNull(),
    serSenha: char("SER_SENHA", { length: 60 }).notNull(),
    serCodRecuperacao: char("SER_COD_RECUPERACAO", { length: 8 }),
    fkAreasAreId: bigint("FK_ARE_ID", { mode: "number", unsigned: true })
      .notNull()
      .references(() => areas.areId, { onDelete: "cascade" }),
    serAtivado: tinyint("SER_ATIVADO").default(1).notNull(),
    serMotivo: varchar("SER_MOTIVO", { length: 255 }),
  },
  (table) => [
    primaryKey({ columns: [table.serIdPrivado], name: "SER_ID_PRIVADO" }),
    unique("SER_ID_PUBLICO").on(table.serIdPublico, table.serEmail, table.serCodRecuperacao, table.serCpf, table.serCelular),
  ]
);

export const status = mysqlTable(
  "STATUS",
  {
    staNome: varchar("STA_NOME", { length: 64 }).notNull(),
    staId: tinyint("STA_ID", { unsigned: true }).notNull().autoincrement(),
  },
  (table) => [primaryKey({ columns: [table.staId], name: "STA_ID" })]
);

export const tarefas = mysqlTable(
  "TAREFAS",
  {
    tarIdPublico: char("TAR_ID_PUBLICO", { length: 24 }).notNull(),
    tarIdPrivado: bigint("TAR_ID_PRIVADO", { mode: "number", unsigned: true }).notNull().autoincrement(),
    tarNome: varchar("TAR_NOME", { length: 255 }).notNull(),
    tarDescricao: varchar("TAR_DESCRICAO", { length: 255 }).notNull(),
    tarCreatedAt: timestamp("TAR_CREATED_AT", { mode: "string" }).defaultNow().notNull(),
    tarChamados: tinyint("TAR_CHAMADOS", { unsigned: true }),
    fkDenunciasDenIdPrivado: bigint("FK_DEN_ID_PRIVADO", { mode: "number", unsigned: true }).references(() => denuncias.denIdPrivado, { onDelete: "cascade" }),
    fkStatusStaId: tinyint("FK_STA_ID", { unsigned: true }).references(() => status.staId, { onDelete: "cascade" }),
    fkServicosTerceirizadosSerIdPrivado: bigint("FK_SER_ID_PRIVADO", { mode: "number", unsigned: true }).references(() => servicosTerceirizados.serIdPrivado, {
      onDelete: "no action",
      onUpdate: "cascade",
    }),
    fkGerentesGerIdPrivado: bigint("FK_GER_ID_PRIVADO", { mode: "number", unsigned: true }).references(() => gerentes.gerIdPrivado, { onDelete: "cascade" }),
  },
  (table) => [primaryKey({ columns: [table.tarIdPrivado], name: "TAR_ID_PRIVADO" }), unique("TAR_ID_PUBLICO").on(table.tarIdPublico)]
);
