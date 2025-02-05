import { FastifyReply, FastifyRequest } from "fastify";
import { validateCpf } from "../utils/validateCPF";
import { FastifyTypedInstance } from "../types";

export function validateCPFMiddleware(app: FastifyTypedInstance) {
  return async (request: FastifyRequest, reply: FastifyReply) => {
    const { cpf } = request.body as { cpf: string }; // Ajuste conforme a estrutura do seu body

    if (!validateCpf(cpf)) {
      return reply.status(400).send({ error: "CPF inválido" });
    }
  };
}
