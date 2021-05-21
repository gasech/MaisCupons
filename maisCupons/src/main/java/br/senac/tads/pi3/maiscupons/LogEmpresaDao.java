package br.senac.tads.pi3.maiscupons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bianca
 */
public class LogEmpresaDao {

    private final ConnectionUtils connectionUtils = new ConnectionUtils();

    public boolean validarEmpresa(LogEmpresaBean logEmpresaBean) throws ClassNotFoundException, SQLException {

        boolean resultado = false;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = connectionUtils.obterConexaoBD();  
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cadastro_empresa where email = ? and senha = ? ")) {
            preparedStatement.setString(1, logEmpresaBean.getEmail());
            preparedStatement.setString(2, logEmpresaBean.getSenha());

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
