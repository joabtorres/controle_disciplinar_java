//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: JOAB TORRES ALENCAR
//******************************************************
package model.dao;

import model.bean.Disciplina;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.ConexaoModel;
//OBJETIVO: Está classe é responsável para fazer a interação da interface com o banco de dados, com ela será feito cadastro (create), alteração(update), exclusão (delete) e consultas (read)

public class DisciplinaModel {

    //OBJETIVO: irá armazena a instância da classe;
    private static DisciplinaModel disciplinaModel;

    //Objetivo: 
    private DisciplinaModel() {
    }

    //OBEJTIVO: definindo somente uma instância da classe, caso não tenha sido instanciada é criada uma instância, este padrão eu costumo utilizar na programação web quando utilizo classes model, conhecido com Padrão Singleton
    public static DisciplinaModel getInstance() {
        if (disciplinaModel == null) {
            disciplinaModel = new DisciplinaModel();
        }
        return disciplinaModel;
    }

    //OBJETIVO: Este método é responsável para efetivar a inserção de registro na tabela tb_disciplina, passando como parammetro a instância da classe Disciplina, além disso o método informa o retorno de true caso obtenha sucesso na inserção e caso contrário false;
    public static boolean create(Disciplina disciplina) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO tb_disciplina (nome, carga_horaria, curso, vagas, periodo) VALUE (?, ?, ?, ?, ?) ;");
            preparedStatement.setString(1, disciplina.getNome());
            preparedStatement.setString(2, disciplina.getCarga_horaria());
            preparedStatement.setString(3, disciplina.getCurso());
            preparedStatement.setInt(4, disciplina.getVagas());
            preparedStatement.setString(5, disciplina.getPeriodo());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement);
        }
        return result;
    }
    //OBJETIVO: Este método é responsável para efetivar consultas na tabela tb_disciplina, ela retorna um arrayList de todos os registros obtidos na consulta
    public static List<Disciplina> read() {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM tb_disciplina");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCod(resultSet.getInt("cod"));
                disciplina.setNome(resultSet.getString("nome"));
                disciplina.setCarga_horaria(resultSet.getString("carga_horaria"));
                disciplina.setCurso(resultSet.getString("curso"));
                disciplina.setVagas(resultSet.getInt("vagas"));
                disciplina.setPeriodo(resultSet.getString("periodo"));
                disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na Consulta: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }
        return disciplinas;
    }
    //OBJETIVO: Este método é responsável para efetivar consultas na tabela tb_disciplina, é passado como parametro String coluna (a coluna da tabela) e String campo (partes do registro), além disso ela retorna um arrayList de todos os registros obtidos na consulta
    public static List<Disciplina> read(String coluna, String campo) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            
            String sql;
            switch (coluna) {
                case "Curso":
                    sql = "SELECT * FROM tb_disciplina WHERE curso LIKE ? ";
                    break;
                case "Disciplina":
                    sql = "SELECT * FROM tb_disciplina WHERE disciplina LIKE ? ";
                    break;
                default:
                    sql = "SELECT * FROM tb_disciplina WHERE cod LIKE ?";
                    break;
            }
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + campo + "%");
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCod(resultSet.getInt("cod"));
                disciplina.setNome(resultSet.getString("nome"));
                disciplina.setCarga_horaria(resultSet.getString("carga_horaria"));
                disciplina.setCurso(resultSet.getString("curso"));
                disciplina.setVagas(resultSet.getInt("vagas"));
                disciplina.setPeriodo(resultSet.getString("periodo"));
                disciplinas.add(disciplina);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro na Consulta: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }
        return disciplinas;
    }
    //OBJETIVO: Este método é responsável para efetivar a alteração de registro na tabela tb_disciplina, passando como parammetro a instância da classe Disciplina, além disso o método informa o retorno de true caso obtenha sucesso na inserção e caso contrário false;
    public static boolean update(Disciplina disciplina) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            preparedStatement = connection.prepareStatement("UPDATE tb_disciplina SET nome = ?, carga_horaria = ?, curso =? , vagas = ?, periodo = ? WHERE cod = ?");
            preparedStatement.setString(1, disciplina.getNome());
            preparedStatement.setString(2, disciplina.getCarga_horaria());
            preparedStatement.setString(3, disciplina.getCurso());
            preparedStatement.setInt(4, disciplina.getVagas());
            preparedStatement.setString(5, disciplina.getPeriodo());
            preparedStatement.setInt(6, disciplina.getCod());
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            System.out.println("Erro no UPDATE: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement);
        }
        return result;
    }
    //OBJETIVO: Este método é responsável para efetivar a exclusão de registro na tabela tb_disciplina, passando como parammetro a instância da classe Disciplina, além disso o método informa o retorno de true caso obtenha sucesso na inserção e caso contrário false;
    public static boolean delete(int cod) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM tb_disciplina WHERE cod = ?");
            preparedStatement.setInt(1, cod);
            preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            System.out.println("Erro no DELETE: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement);
        }

        return result;
    }
}
