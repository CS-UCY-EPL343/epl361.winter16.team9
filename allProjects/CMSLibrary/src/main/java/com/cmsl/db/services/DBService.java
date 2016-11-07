package com.cmsl.db.services;

import com.cmsl.db.DBConnection;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public abstract class DBService {

    public DBConnection getConnection() {
        return connection;
    }

    protected final DBConnection connection;

    public DBService(DBConnection connection) {
        this.connection = connection;
    }
}
