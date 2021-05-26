package br.senac.tads.pi3.maiscupons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogUsuarioDao {

    private final ConnectionUtils connectionUtils = new ConnectionUtils();

    public boolean validarUsuario(LogUsuarioBean logUsuarioBean) throws ClassNotFoundException, SQLException {

        boolean resultado = false;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = connectionUtils.obterConexaoBD();  PreparedStatement preparedStatement = connection.prepareStatement("select * from cadastro_usuario where email = ? and senha = ? ")) {
            preparedStatement.setString(1, logUsuarioBean.getEmail());
            preparedStatement.setString(2, logUsuarioBean.getSenha());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            resultado = rs.next();

        } catch (SQLException e) {
            // process sql exception
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