package br.senac.tads.pi3.maiscupons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bianca
 */
public class EmpresaDao {
    
    
    public int cadastrarEmpresa(Empresa empresa) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO cadastro_empresa" +
            "  (id,nome, cnpj, telefone, email, senha) VALUES " +
            " (?,?, ?, ?, ?, ?);";

        int resultado = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/?user=root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, empresa.getNome());
            preparedStatement.setString(3, empresa.getCnpj());
            preparedStatement.setString(4, empresa.getTelefone());
            preparedStatement.setString(5, empresa.getEmail());
            preparedStatement.setString(6, empresa.getSenha());
            
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
        for (Throwable e: ex) {
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
