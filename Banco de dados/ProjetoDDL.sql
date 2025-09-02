
CREATE SCHEMA clinica IF NOT EXISTS;
SET search_path TO clinica;

CREATE TABLE clinica.medico (id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
								nome TEXT NOT NULL,
								especialidade TEXT NOT NULL,
								crm TEXT NOT NULL);

CREATE TABLE clinica.paciente (id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
								nome TEXT NOT NULL,
								idade INT NOT NULL,
								data_nascimento DATE NOT NULL);

CREATE TABLE clinica.clinica (id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
								endereco TEXT,
								nome TEXT NOT NULL,
								descricao TEXT NOT NULL);

CREATE TABLE clinica.consulta (id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
								data_consulta TIMESTAMPTZ,
								valor NUMERIC(10,4), -- 10 digitos totais, considerando as 4 apos a virgula
								-- metodo extenso
								id_clinica INT NOT NULL,
								FOREIGN KEY (id_clinica) REFERENCES clinica.clinica(id_clinica),
								id_paciente INT NOT NULL,
								FOREIGN KEY (id_paciente) REFERENCES clinica.paciente(id_paciente),
								-- metodo abreviado
								id_medico INT NOT NULL REFERENCES clinica.medico(id_medico));


-- Apagar tabela ou schema
-- DROP TABLE IF EXISTS clinica.clinica
-- DROP SCHEMA clinica


ALTER TABLE clinica.consulta RENAME valor TO valor_consulta; -- alterando nome da coluna
ALTER TABLE clinica.consulta RENAME TO clinica.consulta_medica; -- alterando nome da tabela


-- Apaga todas as linhas da tabela
-- TRUNCATE TABLE clinica.consulta;
-- Reinicia a sequencia das PKs
-- RESTART IDENTITY;