import { FastifyReply, FastifyRequest } from "fastify";
import { FastifyTypedInstance } from "../types";

export function handleJWTError(app: FastifyTypedInstance) {
  return async (request: FastifyRequest, reply: FastifyReply) => {
    try {
      await request.jwtVerify();
    } catch (err: any) {
      if (err.code === "FST_JWT_EXPIRED") {
        reply.status(401).send({ error: "Token expirado", code: "TOKEN_EXPIRED" });
      } else {
        reply.status(401).send({ error: "Não autorizado" });
      }
    }
  };
}
