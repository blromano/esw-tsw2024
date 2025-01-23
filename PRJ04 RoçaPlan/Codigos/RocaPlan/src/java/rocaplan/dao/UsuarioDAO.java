package rocaplan.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.entidades.Usuario;

public class UsuarioDAO extends DAO<Usuario> {
    public UsuarioDAO() throws SQLException {
    }

    @Override
    public void salvar(Usuario obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                INSERT INTO
                usuarios(usu_nome, usu_email, usu_senha)
                VALUES (?, ?, ?);
            """
        );

        stmt.setString(1, obj.getUsuNome());
        stmt.setString(2, obj.getUsuEmail());
        stmt.setString(3, obj.getUsuSenha());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Usuario obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                UPDATE usuarios SET
                    usu_nome = ?,
                    usu_email = ?,
                    usu_senha = ?
                WHERE
                    usu_id = ?;
            """
        );

        stmt.setString(1, obj.getUsuNome());
        stmt.setString(2, obj.getUsuEmail());
        stmt.setString(3, obj.getUsuSenha());
        stmt.setInt(4, obj.getUsuId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Usuario obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                DELETE FROM usuarios
                WHERE usu_id = ?;
            """
        );

        stmt.setInt(1, obj.getUsuId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT * FROM usuarios
                ORDER BY usu_nome;
            """
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();

            u.setUsuId(rs.getInt("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));
            u.setUsuEmail(rs.getString("usu_email"));
            u.setUsuSenha(rs.getString("usu_senha"));

            lista.add(u);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Usuario obterPorId(int id) throws SQLException {
        Usuario usuario = null;

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT * FROM usuarios
                WHERE usu_id = ?;
            """
        );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            usuario = new Usuario();

            usuario.setUsuId(rs.getInt("usu_id"));
            usuario.setUsuNome(rs.getString("usu_nome"));
            usuario.setUsuEmail(rs.getString("usu_email"));
            usuario.setUsuSenha(rs.getString("usu_senha"));

        }

        rs.close();
        stmt.close();

        return usuario;
    }
    
    public Usuario obterPorEmail(String email) throws SQLException{
        Usuario usuario = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
        """
            SELECT * FROM usuarios
            WHERE usu_email = ?;
        """
        );
        stmt.setString(1, email);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()){
            usuario = new Usuario();
            
            usuario.setUsuId(rs.getInt("usu_id"));
            usuario.setUsuNome(rs.getString("usu_nome"));
            usuario.setUsuEmail(rs.getString("usu_email"));
            usuario.setUsuSenha(rs.getString("usu_senha"));
        }
        rs.close();
        stmt.close();
        
        return usuario;
    }
    
}
