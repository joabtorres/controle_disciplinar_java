//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: JOAB TORRES ALENCAR
//******************************************************
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoModel {
    
    //OBJETIVO: Váriaveis staticas para interação da conexão;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_disciplinar";
    private static final String USER = "root";
    private static final String PASS = "";

    //OBJETIVO: Este método é responsável para iniciar a conexão com o banco de dados;
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: " + ex);
        }
    }

    //OBJETIVO: Este método é responsável para finaliza a execução da classe Connection;
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    //OBJETIVO: Este método é responsável para finaliza a execução da classe PreparedStatement e Connection;
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {
        closeConnection(connection);
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    //OBJETIVO: Este método é responsável para finaliza a execução da classe PreparedStatement , ResultSet e Connection;
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet reulSet) {
        closeConnection(connection, preparedStatement);
        try {
            if (reulSet != null) {
                reulSet.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
