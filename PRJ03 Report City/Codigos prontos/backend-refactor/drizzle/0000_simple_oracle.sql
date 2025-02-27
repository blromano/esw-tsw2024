-- Current sql file was generated after introspecting the database
-- If you want to run this migration please uncomment this code before executing migrations
/*
CREATE TABLE `ADMINISTRADORES` (
	`ADM_ID_PRIVADO` int NOT NULL,
	`ADM_ID_PUBLICO` char(24) NOT NULL,
	`ADM_NOME` varchar(128) NOT NULL,
	`ADM_EMAIL` varchar(255) NOT NULL,
	`ADM_SENHA` char(60) NOT NULL,
	CONSTRAINT `ADMINISTRADORES_ADM_ID_PRIVADO` PRIMARY KEY(`ADM_ID_PRIVADO`),
	CONSTRAINT `ADM_EMAIL` UNIQUE(`ADM_EMAIL`,`ADM_ID_PUBLICO`)
);
--> statement-breakpoint
CREATE TABLE `AREAS` (
	`ARE_ID` int NOT NULL,
	`ARE_NOME` varchar(64) NOT NULL,
	`ARE_DESCRICAO` varchar(255) NOT NULL,
	CONSTRAINT `AREAS_ARE_ID` PRIMARY KEY(`ARE_ID`)
);
--> statement-breakpoint
CREATE TABLE `CIDADOES` (
	`CID_ID_PUBLICO` char(24),
	`CID_ID_PRIVADO` int NOT NULL,
	`CID_NOME` varchar(128) NOT NULL,
	`CID_CPF` char(11) NOT NULL,
	`CID_CELULAR` char(11) NOT NULL,
	`CID_EMAIL` varchar(255) NOT NULL,
	`CID_CEP` char(8) NOT NULL,
	`CID_RUA` varchar(255) NOT NULL,
	`CID_NUMERO` varchar(6) NOT NULL,
	`CID_COMPLEMENTO` varchar(16),
	`CID_BAIRRO` varchar(64) NOT NULL,
	`CID_CIDADE` varchar(32) NOT NULL,
	`CID_ESTADO` varchar(64) NOT NULL,
	`CID_SENHA` char(60) NOT NULL,
	`CID_COD_RECUPERACAO` char(8),
	`CID_ATIVADO` tinyint(1) NOT NULL DEFAULT 1,
	`CID_MOTIVO` varchar(255),
	CONSTRAINT `CIDADOES_CID_ID_PRIVADO` PRIMARY KEY(`CID_ID_PRIVADO`),
	CONSTRAINT `CID_ID_PUBLICO` UNIQUE(`CID_ID_PUBLICO`,`CID_EMAIL`,`CID_CPF`,`CID_COD_RECUPERACAO`,`CID_CELULAR`)
);
--> statement-breakpoint
CREATE TABLE `DENUNCIAS` (
	`DEN_ID_PRIVADO` int NOT NULL,
	`DEN_ID_PUBLICO` char(24) NOT NULL,
	`DEN_TITULO` varchar(64) NOT NULL,
	`DEN_DESCRICAO` varchar(255) NOT NULL,
	`DEN_COORDENADA` point NOT NULL,
	`DEN_CREATED_AT` timestamp NOT NULL DEFAULT (CURRENT_TIMESTAMP),
	`DEN_UPDATED_AT` timestamp NOT NULL DEFAULT (CURRENT_TIMESTAMP) ON UPDATE CURRENT_TIMESTAMP,
	`DEN_FEEDBACK` varchar(1024),
	`DEN_IMAGEM` varchar(1024) NOT NULL,
	`DEN_TIPO` enum('BURACO NA VIA','BURACO NA CALÇADA','POSTE DANIFICADO','ÁRVORE CAÍDA','REDE ELÉTRICA DANIFICADA') NOT NULL,
	`FK_CIDADOES_CID_ID_PRIVADO` int,
	`FK_STATUS_STA_ID` int,
	CONSTRAINT `DENUNCIAS_DEN_ID_PRIVADO` PRIMARY KEY(`DEN_ID_PRIVADO`),
	CONSTRAINT `DEN_ID_PUBLICO` UNIQUE(`DEN_ID_PUBLICO`)
);
--> statement-breakpoint
CREATE TABLE `DEPARTAMENTOS` (
	`DEP_ID` int NOT NULL,
	`DEP_NOME` varchar(64) NOT NULL,
	`DEP_DESCRICAO` varchar(255) NOT NULL,
	CONSTRAINT `DEPARTAMENTOS_DEP_ID` PRIMARY KEY(`DEP_ID`)
);
--> statement-breakpoint
CREATE TABLE `GERENTES` (
	`GER_ID_PUBLICO` char(24) NOT NULL,
	`GER_ID_PRIVADO` int NOT NULL,
	`GER_FOTO` varchar(1024),
	`GER_NOME` varchar(255) NOT NULL,
	`GER_CPF` char(11) NOT NULL,
	`GER_EMAIL` varchar(255) NOT NULL,
	`GER_SENHA` char(60) NOT NULL,
	`FK_DEPARTAMENTOS_DEP_ID` int NOT NULL,
	`FK_ADMINISTRADORES_ADM_ID_PRIVADO` int NOT NULL,
	CONSTRAINT `GERENTES_GER_ID_PRIVADO` PRIMARY KEY(`GER_ID_PRIVADO`),
	CONSTRAINT `GER_ID_PUBLICO` UNIQUE(`GER_ID_PUBLICO`,`GER_CPF`,`GER_EMAIL`)
);
--> statement-breakpoint
CREATE TABLE `SERVICOS_TERCEIRIZADOS` (
	`SER_ID_PRIVADO` int NOT NULL,
	`SER_ID_PUBLICO` char(24) NOT NULL,
	`SER_NOME` varchar(255) NOT NULL,
	`SER_CPF` char(11) NOT NULL,
	`SER_CELULAR` char(11) NOT NULL,
	`SER_EMAIL` varchar(255) NOT NULL,
	`SER_SENHA` char(60) NOT NULL,
	`SER_COD_RECUPERACAO` char(8),
	`FK_AREAS_ARE_ID` int NOT NULL,
	`SER_ATIVADO` tinyint(1) NOT NULL DEFAULT 1,
	`SER_MOTIVO` varchar(255),
	CONSTRAINT `SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO` PRIMARY KEY(`SER_ID_PRIVADO`),
	CONSTRAINT `SER_ID_PUBLICO` UNIQUE(`SER_ID_PUBLICO`,`SER_EMAIL`,`SER_COD_RECUPERACAO`,`SER_CPF`,`SER_CELULAR`)
);
--> statement-breakpoint
CREATE TABLE `STATUS` (
	`STA_NOME` varchar(64) NOT NULL,
	`STA_ID` int NOT NULL,
	CONSTRAINT `STATUS_STA_ID` PRIMARY KEY(`STA_ID`)
);
--> statement-breakpoint
CREATE TABLE `TAREFAS` (
	`TAR_ID_PUBLICO` char(24) NOT NULL,
	`TAR_ID_PRIVADO` int unsigned NOT NULL,
	`TAR_NOME` varchar(255) NOT NULL,
	`TAR_DESCRICAO` varchar(255) NOT NULL,
	`TAR_CREATED_AT` timestamp NOT NULL DEFAULT (CURRENT_TIMESTAMP),
	`TAR_CHAMADOS` int,
	`FK_DENUNCIAS_DEN_ID_PRIVADO` int,
	`FK_STATUS_STA_ID` int,
	`FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO` int,
	`FK_GERENTES_GER_ID_PRIVADO` int,
	CONSTRAINT `TAREFAS_TAR_ID_PRIVADO` PRIMARY KEY(`TAR_ID_PRIVADO`),
	CONSTRAINT `TAR_ID_PUBLICO` UNIQUE(`TAR_ID_PUBLICO`)
);
--> statement-breakpoint
ALTER TABLE `DENUNCIAS` ADD CONSTRAINT `FK_DENUNCIAS_2` FOREIGN KEY (`FK_CIDADOES_CID_ID_PRIVADO`) REFERENCES `CIDADOES`(`CID_ID_PRIVADO`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `DENUNCIAS` ADD CONSTRAINT `FK_DENUNCIAS_3` FOREIGN KEY (`FK_STATUS_STA_ID`) REFERENCES `STATUS`(`STA_ID`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `GERENTES` ADD CONSTRAINT `FK_GERENTES_2` FOREIGN KEY (`FK_DEPARTAMENTOS_DEP_ID`) REFERENCES `DEPARTAMENTOS`(`DEP_ID`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `GERENTES` ADD CONSTRAINT `FK_GERENTES_3` FOREIGN KEY (`FK_ADMINISTRADORES_ADM_ID_PRIVADO`) REFERENCES `ADMINISTRADORES`(`ADM_ID_PRIVADO`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `SERVICOS_TERCEIRIZADOS` ADD CONSTRAINT `FK_SERVICOS_TERCEIRIZADOS_2` FOREIGN KEY (`FK_AREAS_ARE_ID`) REFERENCES `AREAS`(`ARE_ID`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `TAREFAS` ADD CONSTRAINT `FK_TAREFAS_2` FOREIGN KEY (`FK_DENUNCIAS_DEN_ID_PRIVADO`) REFERENCES `DENUNCIAS`(`DEN_ID_PRIVADO`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `TAREFAS` ADD CONSTRAINT `FK_TAREFAS_3` FOREIGN KEY (`FK_STATUS_STA_ID`) REFERENCES `STATUS`(`STA_ID`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `TAREFAS` ADD CONSTRAINT `FK_TAREFAS_4` FOREIGN KEY (`FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO`) REFERENCES `SERVICOS_TERCEIRIZADOS`(`SER_ID_PRIVADO`) ON DELETE cascade ON UPDATE no action;--> statement-breakpoint
ALTER TABLE `TAREFAS` ADD CONSTRAINT `FK_TAREFAS_5` FOREIGN KEY (`FK_GERENTES_GER_ID_PRIVADO`) REFERENCES `GERENTES`(`GER_ID_PRIVADO`) ON DELETE cascade ON UPDATE no action;
*/