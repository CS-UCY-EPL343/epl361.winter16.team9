package com.cmsl.db.entities;

import com.cmsl.db.DBConnection;
import com.cmsl.db.services.OperatorService;
import org.junit.Test;

/**
 * Created by zgeorg03 on 11/8/16.
 */

public class OperatorTest {


    @Test
    public void NewOperatorTest() throws Exception {
        DBConnection connection = new DBConnection("localhost","hotline","team9","Epl361project!");
        OperatorService operatorService = new OperatorService(connection);
        boolean ans =   operatorService.createOperator("1","Zacharias","Georgiou","12345678","zacharias33@mail.com","test","test");
        boolean ans1 =   operatorService.createOperator("2","Test2","Test2Surname","123456","test2@mail.com","test2","test");
        connection.close();
        assert ans && ans1;
    }

    @Test
    public void deleteOperatorTest() throws Exception {
        DBConnection connection = new DBConnection("localhost", "hotline", "team9", "Epl361project!");
        OperatorService operatorService = new OperatorService(connection);
        boolean ans = operatorService.deleteOperator("test1");
        boolean ans1 = operatorService.deleteOperator("test1");
        connection.close();
        assert ans && ans1;
    }
    @Test
    public void authenticateTest() throws Exception {
        DBConnection connection = new DBConnection("localhost","hotline","team9","Epl361project!");
        OperatorService operatorService = new OperatorService(connection);
        //Correct password
        int code  =   operatorService.authenticate("test1","test");
        assert code == 0;

        //Wrong password
        code  =   operatorService.authenticate("test1","testtest");
        assert code == 2;

        //User Not Found
        code  =   operatorService.authenticate("xafsdijasdfiajsdio","saf");
        assert code == 1;
        connection.close();

    }
}
