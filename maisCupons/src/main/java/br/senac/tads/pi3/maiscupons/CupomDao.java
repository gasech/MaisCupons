/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.maiscupons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bianca
 */
public class CupomDao {
    
    public int cadastrarCupom(Cupom cupom) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO cadastro_cupom" +
            "  (id,nome, departamento, desconto) VALUES " +
            " (?,?,?,?);";

        int resultado = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/?user=root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, cupom.getNome());
            preparedStatement.setString(3, cupom.getDepartamento());
            preparedStatement.setString(4, cupom.getDesconto());
            
            
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
