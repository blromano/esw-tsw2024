package rocaplan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Uma fábrica de conexões.
 *
 * @author Prof. Dr. David Buzatto
 */
public class ConnectionFactory {

    /**
     * O método getConnection retorna uma conexão com a base de dados
     * locacao_midias.
     *
     * @return Uma conexão com o banco de dados venda_produtos.
     * @throws SQLException Caso ocorra algum problema durante a conexão.
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mariadb://localhost/rocaplan",
                "root",
                "" );

    }

}
