create database if not exists conectaplus;
	use  conectaplus;
CREATE TABLE IF NOT EXISTS `conecta_plus` . `usuarios`(
	
    `id_usuarios` INT NOT NULL AUTO_INCREMENT,
    `usu_nome` VARCHAR(100) NOT NULL,
    `usu_email` VARCHAR(255) NOT NULL,
    `usu_senha` VARCHAR(30) NOT NULL,
    `usu_contato` VARCHAR(15) NOT NULL,
    `usu_endereco` VARCHAR(100) NOT NULL,
    `usu_data_nasc` DATE NOT NULL,
    `usu_estado` VARCHAR(100) NOT NULL,
    `usu_cidade` VARCHAR(100) NOT NULL,
    `usu_sexo` ENUM('Masculino', 'Feminino', 'Prefiro não responder') NOT NULL,
	PRIMARY KEY (`id_usuarios`)

)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `conecta_plus` . `profissionais`(

	`id_profissionais` INT NOT NULL AUTO_INCREMENT,
    `pro_status` ENUM('Banido', 'Suspenso', 'Ativo') NOT NULL,
    `pro_tel_com` VARCHAR(15) NOT NULL,
    `pro_end_com` VARCHAR(100) NOT NULL,
    `pro_foto` LONGBLOB NOT NULL,
    `pro_id_usuarios` INT,
    PRIMARY KEY (`id_profissionais`),
    FOREIGN KEY (`pro_id_usuarios`) REFERENCES usuarios(`id_usuarios`)

)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `conecta_plus` . `servicos`(

	`id_servicos` INT NOT NULL AUTO_INCREMENT,
    `ser_nome` VARCHAR(50) NOT NULL,
    `ser_descricao` VARCHAR(500) NOT NULL,
    `ser_area` VARCHAR(200),
    `ser_id_profissionais` INT,
    PRIMARY KEY (`id_servicos`),
    FOREIGN KEY (`ser_id_profissionais`) REFERENCES profissionais (`id_profissionais`)

)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `conecta_plus` . `clientes`(

	`id_clientes` INT NOT NULL AUTO_INCREMENT,
    `cli_cpf` VARCHAR(11) NOT NULL,
    `cli_id_usuarios` INT,
    PRIMARY KEY (`id_clientes`),
    FOREIGN KEY (`cli_id_usuarios`) REFERENCES usuarios(`id_usuarios`)

)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `conecta_plus` . `profissionais_favoritos`(

	`id_favorito` INT NOT NULL AUTO_INCREMENT,
    `pro_fav_id_clientes` INT,
    `pro_fav_id_profissionais` INT,
    PRIMARY KEY (`id_favorito`),
    FOREIGN KEY (`pro_fav_id_clientes`) REFERENCES clientes(`id_clientes`),
    FOREIGN KEY (`pro_fav_id_profissionais`) REFERENCES profissionais(`id_profissionais`)
    
)ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `conecta_plus` . `agendamentos`(
	
    `id_agendamentos` INT NOT NULL AUTO_INCREMENT,
    `age_data` DATE NOT NULL,
    `age_horario` TIME NOT NULL,
    `age_status` ENUM('Agendado', 'Concluido', 'Cancelado') NOT NULL,
    `age_id_clientes` INT,
    PRIMARY KEY (`id_agendamentos`),
    FOREIGN KEY (`age_id_clientes`) REFERENCES clientes(`id_clientes`)    
    
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `conecta_plus` . `denuncias`(

	`id_denuncias` INT NOT NULL AUTO_INCREMENT,
    `den_status` ENUM('Suspensão', 'Banimento') NOT NULL,
    `den_motivo` ENUM('Abuso/Assédio', 'Furto/Roubo',
					  'Agressão Física ou Verbal',
                      'Nao Comparecimento do profissional') NOT NULL,
	`den_descricao` VARCHAR(500) NOT NULL,
    `den_id_agendamentos` INT,
    PRIMARY KEY (`id_denuncias`),
    FOREIGN KEY (`den_id_agendamentos`) REFERENCES agendamentos(`id_agendamentos`)

)ENGINE=InnoDb;