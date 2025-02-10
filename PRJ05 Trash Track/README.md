# TrashTrack

## 💻 Pré-requisitos

- `<Java Development Kit>` - Para suporte a linguagem Java utilizado
- `<GlassFish Server>` - Servidor Utilizado
- `<MariaDB>` - Sistema Gerenciador de Banco de Dados do Projeto

## 🚀 Instalando Banco de Dados

- Entre no diretório `\Banco de Dados`
- Acesse o arquivo `Código SQL.sql`
- Insira na sua linha de comando do Banco de Dados

Banco de Dados a ser Gerado:
<img src="Banco de Dados/imagemBancoLogico.png" alt="Visualização Lógica do Banco de Dados">

- Usuário utilizado no Projeto: `root`
- Senha utilizada no Projeto: `* Sem Senha *`

Caso seu usuário do Banco de Dados utilize senha ou outro nome, acesse: `\TrashTrack\src\java\trashtrack\jdbc\ConnectionFactory.java` e altere:

```
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        
        return DriverManager.getConnection( 
                "jdbc:mariadb://localhost/trashtrack",
                "Seu Usuário",
                "Sua Senha" );
        
    }
    
}
```

## 🤝 Instalando o Conector JDBC no Servidor

- Acesse `\TrashTrack\lib\mariadb_connector` 
- Copie o arquivo `mariadb-java-client-3.5.1.jar` para a pasta de bibliotecas do seu servidor

## ☕ Usando TrashTrack

Após isso, basta executar o projeto em sua Máquina!

## 🎥 Link da apresentação do projeto

https://www.youtube.com/watch?v=t3MrM54t1vY

