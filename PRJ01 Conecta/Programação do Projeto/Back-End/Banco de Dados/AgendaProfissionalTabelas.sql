use conecta_plus;

select * from usuarios;

SELECT 
    a.id_agendamentos,
    u.usu_nome AS agendado_por,
    s.ser_nome AS titulo_servico,
    a.age_data,
    a.age_horario
FROM agendamentos a
JOIN clientes c ON a.age_id_clientes = c.id_clientes
JOIN usuarios u ON c.cli_id_usuarios = u.id_usuarios
JOIN servicos s ON s.ser_id_profissionais = (SELECT id_profissionais FROM profissionais WHERE pro_id_usuarios = 1) 
WHERE a.age_status = 'Agendado';
