package conecta.dao;

import conecta.entidades.Agendamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO extends DAO<Agendamento> {

    public AgendamentoDAO() throws SQLException {
    }

    @Override
    public void salvar(Agendamento obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO agendamentos (age_data, age_horario, age_status) VALUES (?, ?, ?);"
        );
        stmt.setDate(1, new Date(obj.getAge_data().getTime()));
        stmt.setTime(2, obj.getAge_horario());
        stmt.setString(3, obj.getAge_status());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Agendamento obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE agendamentos SET age_data = ?, age_horario = ?, age_status = ? WHERE id_agendamentos = ?;"
        );
        stmt.setDate(1, new Date(obj.getAge_data().getTime()));
        stmt.setTime(2, obj.getAge_horario());
        stmt.setString(3, obj.getAge_status());
        stmt.setInt(4, obj.getId_agendamentos());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Agendamento obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM agendamentos WHERE id_agendamentos = ?;"
        );
        stmt.setInt(1, obj.getId_agendamentos());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Agendamento> listarTodos() throws SQLException {
        List<Agendamento> lista = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM agendamentos ORDER BY age_data, age_horario;"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId_agendamentos(rs.getInt("id_agendamentos"));
            agendamento.setAge_data(rs.getDate("age_data"));
            agendamento.setAge_horario(rs.getTime("age_horario"));
            agendamento.setAge_status(rs.getString("age_status"));
            lista.add(agendamento);
        }
        rs.close();
        stmt.close();
        return lista;
    }

    @Override
    public Agendamento obterPorId(Long id) throws SQLException {
        Agendamento agendamento = null;
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM agendamentos WHERE id_agendamentos = ?;"
        );
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            agendamento = new Agendamento();
            agendamento.setId_agendamentos(rs.getInt("id_agendamentos"));
            agendamento.setAge_data(rs.getDate("age_data"));
            agendamento.setAge_horario(rs.getTime("age_horario"));
            agendamento.setAge_status(rs.getString("age_status"));
        }
        rs.close();
        stmt.close();
        return agendamento;
    }
}
