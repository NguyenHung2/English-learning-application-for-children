/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class DatabaseConnection {

    private String db_username = "sa";
    private String db_password = "sa2008";
    private String db_name = "duan1";
    private String host = "localhost";
    private int port = 1433;
    private Connection connection = null;
    private Statement statement = null;

    public DatabaseConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=duan1";
        try {
            connection = DriverManager.getConnection(url, db_username, db_password);
//            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connection lost.");
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
