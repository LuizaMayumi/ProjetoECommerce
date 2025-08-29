-- DML
INSERT INTO clinica.medico(nome, crm, especialidade) VALUES 
	('Medico 3', '9011','Oftalmologista'),
	('Medico 4', '1213','Ortopedista');
						
INSERT INTO clinica.paciente(nome, idade, data_nascimento) VALUES 
	('Paciente 1', '30', '1995-08-30'), 
	('Paciente 2', '40', '1985-08-24'), 
	('Paciente 3', '37', '1988-04-15'),
	('Paciente 4', '20', '2005-12-09');
							
INSERT INTO clinica.clinica(endereco, nome, descricao) VALUES 
	('Alameda Síria', 'Clínica Essência Saúde', 'Atendimento médico de qualidade para toda a família.'),
	('Rua Ingazeira', 'Centro de Saúde PrimeCare', 'Serviços de saúde integrados com foco no bem-estar.'),
	('Rua Órion', 'Clínica Médica InnovateHealth', 'Tecnologia e cuidado humano para sua saúde.'),
	('Rua Vicente Alves de Araújo', 'Consultório Médico Total Bem', 'Cuidado completo com foco na sua saúde e qualidade de vida.');

							
INSERT INTO clinica.consulta(data_consulta, valor, id_medico, id_clinica, id_paciente) VALUES 
	('2025-09-04 09:30:00-03', 50, 3, 2, 3), 
	('2025-09-14 10:20:00-03', 35.55, 1, 4, 2),
	('2025-10-14 13:00:00-03', 141.30, 1, 1, 4),
	('2025-11-14 16:45:00-03', 60.61, 2, 3, 2);


-- UPDATE clinica.consulta SET valor = 200.5 where id_consulta = 1;
-- UPDATE clinica.consulta SET valor = 200.5 where valor >= 200;


-- DELETE FROM clinica.paciente where id_paciente = 1;

-- Opcional 
-- SET search_path TO clinica;


-- DQL
SELECT * FROM clinica.medico WHERE especialidade = 'Ortopedista' ORDER BY id_medico DESC;
SELECT nome, especialidade FROM clinica.medico WHERE especialidade LIKE 'Oftal%';
SELECT * FROM clinica.medico WHERE especialidade = 'Ortopedista' AND crm = '5678';

SELECT * FROM clinica.medico;
SELECT * FROM clinica.paciente;
SELECT * FROM clinica.clinica;
SELECT * FROM clinica.consulta;