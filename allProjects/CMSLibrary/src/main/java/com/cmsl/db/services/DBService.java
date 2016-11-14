package com.cmsl.db.services;

import com.cmsl.db.DBConnection;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public abstract class DBService {

    protected final DBConnection connection;

    public DBConnection getConnection() {
        return connection;
    }


    public DBService(DBConnection connection) {
        this.connection = connection;
    }
}
