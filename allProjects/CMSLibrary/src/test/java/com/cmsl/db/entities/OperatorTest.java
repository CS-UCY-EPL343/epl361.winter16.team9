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
        boolean ans =   operatorService.createOperator("1","Test1","Test1Surname","123456","test@mail.com","test1","test1","test1");
        assert ans;
    }
}
