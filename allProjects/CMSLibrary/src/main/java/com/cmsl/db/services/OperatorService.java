package com.cmsl.db.services;

import com.cmsl.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class OperatorService extends DBService  {


    public OperatorService(DBConnection connection) {
        super(connection);
    }

    public boolean createOperator(String operator_id, String name, String surname, String telephone, String email, String username, String password, String salt) {
        int count = 0;
        try(PreparedStatement stmt = connection.getConnection().prepareStatement(
                "INSERT INTO Operator(operator_id,name,surname,telephone,email"+
                        ",username,password,salt) VALUES (?,?,?,?,?,?,?,?)")){

            stmt.setString(1,operator_id);
            stmt.setString(2,name);
            stmt.setString(3,surname);
            stmt.setString(4,telephone);
            stmt.setString(5,email);
            stmt.setString(6,username);
            stmt.setString(7,password);
            stmt.setString(8,salt);

            count = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return count==1;
    }


}
