package com.hp.main;

import com.cmsl.entities.PersonalDetails;
import com.hp.tools.EncryptedFile;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class HotlineCase {

    private final String id;
    private final PersonalDetails personalDetails;
    private final String comments;
    private final List<EncryptedFile> files;

    public HotlineCase(String id, PersonalDetails personalDetails, String comments) {
        this.id = id;
        this.personalDetails = personalDetails;
        this.comments = comments;
        files = new LinkedList<>();
    }
}
