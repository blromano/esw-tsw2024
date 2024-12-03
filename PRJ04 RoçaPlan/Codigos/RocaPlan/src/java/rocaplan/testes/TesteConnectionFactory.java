package rocaplan.testes;

import java.sql.Connection;
import java.sql.SQLException;
import rocaplan.jdbc.ConnectionFactory;

public class TesteConnectionFactory {
    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println( "Conexão criada com sucesso!" );
        } catch ( SQLException exc ) {
            System.err.println( "Erro ao tentar criar a conexão!" );
            exc.printStackTrace();
        }
    }
}
