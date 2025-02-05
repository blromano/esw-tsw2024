// src/middlewares/auth.ts
import { FastifyRequest, FastifyReply } from "fastify";

import { FastifyTypedInstance } from "../types";

export function authMiddleware(app: FastifyTypedInstance) {
  return async (request: FastifyRequest, reply: FastifyReply) => {
    try {
      await request.jwtVerify(); // Verifica o token JWT
    } catch (err) {
      reply.status(401).send({ error: "Não autorizado" });
    }
  };
}
