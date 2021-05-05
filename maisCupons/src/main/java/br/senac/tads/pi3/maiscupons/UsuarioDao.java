package br.senac.tads.pi3.maiscupons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bianca
 */
public class UsuarioDao {

    public int cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO cadastro_usuario"
                + "  (id,nome, cpf, telefone, email, senha) VALUES "
                + " (?,?, ?, ?, ?, ?);";

        int resultado = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/?user=root"); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, usuario.getNome());
            preparedStatement.setString(3, usuario.getCpf());
            preparedStatement.setString(4, usuario.getTelefone());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setString(6, usuario.getSenha());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            resultado = preparedStatement.executeUpdate();

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
