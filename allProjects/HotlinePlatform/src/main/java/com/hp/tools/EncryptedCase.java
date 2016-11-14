package com.hp.tools;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class EncryptedCase {
    private final String id;
    private final long timestamp;

    public EncryptedCase(String id, long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return id;
    }
}
