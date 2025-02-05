import { pino, multistream } from "pino";
import { createWriteStream, mkdir, mkdirSync } from "node:fs";
import { resolve } from "node:path";
import { ZodTypeProvider } from "fastify-type-provider-zod";
import { fastify } from "fastify";

const logDir = resolve(process.cwd(), "logs");
const logFile = resolve(logDir, "arquivo.log");

// Cria o diretório se não existir
try {
  mkdirSync(logDir, { recursive: true });
} catch (error) {
  console.error("Erro ao criar diretório de logs:", error);
}

const streams = [{ stream: process.stdout }, { stream: createWriteStream(logFile, { flags: "a" }) }];

export const logger = pino(
  {
    level: process.env.NODE_ENV === "production" ? "info" : "debug",
    timestamp: () => `,"time":"${new Date().toISOString()}"`,
  },
  multistream(streams)
);

// Adicione no server.ts
const app = fastify({
  logger: logger,
}).withTypeProvider<ZodTypeProvider>();
