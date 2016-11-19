package com.cmsl.db.services;

import com.cmsl.db.DBConnection;
import com.cmsl.db.entities.Operator;
import com.cmsl.security.Security;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class OperatorService extends DBService {


    public OperatorService(DBConnection connection) {
        super(connection);
    }

    /**
     * Crate a new Operator with the specified fields
     *
     * @param operator_id
     * @param name
     * @param surname
     * @param telephone
     * @param email
     * @param username
     * @param password
     * @return False if some error occured
     */
    public boolean createOperator(String operator_id, String name, String surname, String telephone, String email, String username, String password) {
        int count = 0;
        try (PreparedStatement stmt = connection.getConnection().prepareStatement(
                "INSERT INTO Operator(operator_id,name,surname,telephone,email" +
                        ",username,password,salt) VALUES (?,?,?,?,?,?,?,?)")) {

            String salt = Security.generateSalt();
            stmt.setString(1, operator_id);
            stmt.setString(2, name);
            stmt.setString(3, surname);
            stmt.setString(4, telephone);
            stmt.setString(5, email);
            stmt.setString(6, username);
            stmt.setString(7, Security.createHash256(password + salt));
            stmt.setString(8, salt);

            count = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return count == 1;
    }

    /**
     * Returns an operator salt. In case more than one users have the same username it returns error.
     * But this case won't happen as long username column is unique
     *
     * @param username
     * @return
     */
    private String getOperatorSalt(String username) {
        String res = "NOUSER";
        try (PreparedStatement stmt = connection.getConnection().prepareStatement(
                "SELECT salt FROM Operator WHERE username = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
                if (count > 1)
                    return "ERROR";
                res = rs.getString(1);
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return "ERROR";
        }
        return res;
    }

    /**
     * Return codes:
     * 0 -> Successful authentication
     * 1 -> No user found
     * 2 -> Password doesn't match
     * 3 -> Database error
     *
     * @param username
     * @param password
     * @return
     */
    public int authenticate(String username, String password) {

        //Get the Operator hash
        String salt = getOperatorSalt(username);
        if (salt.equalsIgnoreCase("NOUSER"))
            return 1;
        if (salt.equalsIgnoreCase("ERROR"))
            return 3;
        String saltedPassword = Security.createHash256(password + salt);
        try (PreparedStatement stmt = connection.getConnection().prepareStatement(
                "SELECT COUNT(*) FROM Operator WHERE username = ? AND password =? ")) {

            stmt.setString(1, username);
            stmt.setString(2, saltedPassword);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0)
                return 2;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 3;
        }
        return 0;
    }

    public boolean deleteOperator(String username) {

        int count = 0;
        try (PreparedStatement stmt = connection.getConnection().prepareStatement(
                "DELETE FROM Operator WHERE username = ?")) {
            stmt.setString(1, username);

            count = stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return count == 1;
    }

    public Operator getOperator(String username){
        Operator operator = null;
        try (Statement stmt = connection.getConnection().createStatement()){

            ResultSet rs = stmt.executeQuery("SELECT operator_id,name,surname,telephone,email" +
                    ",password,salt FROM Operator WHERE username='"+username +"'" );

            if(rs.next()) {
                String operator_id = rs.getString(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String telephone = rs.getString(4);
                String email = rs.getString(5);
                String password = rs.getString(6);
                String salt = rs.getString(7);
                operator = new Operator(operator_id,name,surname,telephone,email,username,password,salt);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return operator;
   }
}
