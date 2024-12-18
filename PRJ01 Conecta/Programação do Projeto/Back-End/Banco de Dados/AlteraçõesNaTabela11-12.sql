ALTER TABLE profissionais
ADD COLUMN cpf_cnpj VARCHAR(14);

ALTER TABLE profissionais
CHANGE COLUMN cpf_cnpj pro_cpf_cnpj VARCHAR(14);