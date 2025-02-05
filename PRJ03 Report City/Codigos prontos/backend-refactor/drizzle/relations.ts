import { relations } from "drizzle-orm/relations";
import { cidadoes, denuncias, status, administradores, gerentes, departamentos, areas, servicosTerceirizados, tarefas } from "./schema";

export const denunciasRelations = relations(denuncias, ({one, many}) => ({
	cidadoe: one(cidadoes, {
		fields: [denuncias.fkCidIdPrivado],
		references: [cidadoes.cidIdPrivado]
	}),
	status: one(status, {
		fields: [denuncias.fkStaId],
		references: [status.staId]
	}),
	tarefas: many(tarefas),
}));

export const cidadoesRelations = relations(cidadoes, ({many}) => ({
	denuncias: many(denuncias),
}));

export const statusRelations = relations(status, ({many}) => ({
	denuncias: many(denuncias),
	tarefas: many(tarefas),
}));

export const gerentesRelations = relations(gerentes, ({one}) => ({
	administradore: one(administradores, {
		fields: [gerentes.fkAdmIdPrivado],
		references: [administradores.admIdPrivado]
	}),
	departamento: one(departamentos, {
		fields: [gerentes.fkDepId],
		references: [departamentos.depId]
	}),
}));

export const administradoresRelations = relations(administradores, ({many}) => ({
	gerentes: many(gerentes),
}));

export const departamentosRelations = relations(departamentos, ({many}) => ({
	gerentes: many(gerentes),
}));

export const servicosTerceirizadosRelations = relations(servicosTerceirizados, ({one}) => ({
	area: one(areas, {
		fields: [servicosTerceirizados.fkAreId],
		references: [areas.areId]
	}),
}));

export const areasRelations = relations(areas, ({many}) => ({
	servicosTerceirizados: many(servicosTerceirizados),
}));

export const tarefasRelations = relations(tarefas, ({one}) => ({
	denuncia: one(denuncias, {
		fields: [tarefas.fkDenIdPrivado],
		references: [denuncias.denIdPrivado]
	}),
	status: one(status, {
		fields: [tarefas.fkStaId],
		references: [status.staId]
	}),
}));