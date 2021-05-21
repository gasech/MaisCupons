package br.senac.tads.pi3.maiscupons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bianca
 */

public class UsuarioDao {
    
    private final ConnectionUtils connectionUtils = new ConnectionUtils();
    
    /*public boolean validarCadastroUsuario (Usuario usuario) throws ClassNotFoundException{
        
        boolean resultado = false;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = connectionUtils.obterConexaoBD();  PreparedStatement preparedStatement = connection.prepareStatement("select * from cadastro_usuario where email = ? or cpf = ? ")) {
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getCpf());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            resultado = rs.next();

        } catch (SQLException e) {            
            printSQLException(e);
        }
        
        return false;
    }*/

    public int cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO cadastro_usuario"
                + "  (nome, cpf, telefone, email, senha) VALUES "
                + " (?, ?, ?, ?, ?);";

        int resultado = 0;

        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection = connectionUtils.obterConexaoBD();           
                
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getTelefone());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getSenha());

           // System.out.println(preparedStatement);
            
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
