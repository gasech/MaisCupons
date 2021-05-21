package br.senac.tads.pi3.maiscupons;


import br.senac.tads.pi3.maiscupons.ConnectionUtils;
import br.senac.tads.pi3.maiscupons.Cupom;
import br.senac.tads.pi3.maiscupons.SolicitacaoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bianca
 */
public class SolicitacaoUsuarioDao {

    private final ConnectionUtils connectionUtils = new ConnectionUtils();

    public int registrarMensagemUsuario(SolicitacaoUsuario solicitacaoUsuario) throws ClassNotFoundException, SQLException {

        String INSERT_USERS_SQL = "INSERT INTO solicitacao_usuario"
                + "  (nome, cpf, mensagem) VALUES "
                + " (?,?,?);";

        int resultado = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = connectionUtils.obterConexaoBD();  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, solicitacaoUsuario.getNome());
            preparedStatement.setString(2, solicitacaoUsuario.getCpf());
            preparedStatement.setString(3, solicitacaoUsuario.getMensagem());

            System.out.println(preparedStatement);

            resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
        return resultado;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}