package com.cmsl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zgeorg03 on 11/7/16.
 */
public class DBConnection {

    private final Connection connection;

    /**
     * Construct a new Database connection
     * @param host localhost
     * @param database reports or helpline
     * @param user team9
     * @param password Epl361project!
     * @throws Exception
     */
    public DBConnection(String host,String database,String user,String password) throws Exception  {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database+"?" +
                    "user="+user+"&password="+password+"&useUnicode=yes&characterEncoding=UTF-8");
        } catch (InstantiationException e) {
            throw new Exception("Cannot Instantiate");
        } catch (IllegalAccessException e) {
            throw new Exception("Illegal Access" );
        } catch (ClassNotFoundException e) {
            throw new Exception("Class Not Found" );
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to close connection");
        }
    }
}
