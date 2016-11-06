package com.team9.main;

import com.team9.Utils.ViewUtil;
import com.team9.chat.ChatController;
import com.team9.helpline.HelplineController;
import com.team9.hotline.HotlineController;
import com.team9.hotline.HotlineFormController;
import com.team9.index.IndexController;

import static spark.Spark.*;

/**
 * Created by zgeorg03 on 10/18/16.
 */
public class Main {


    public static void main(String args[]){
        port(8000);
        staticFileLocation("/public");

        get(ViewUtil.PATH.getWebInstance().getINDEX(), IndexController.serveIndexPage);
        get(ViewUtil.PATH.getWebInstance().getHOTLINE(), HotlineController.serveIndexPage);
        get(ViewUtil.PATH.getWebInstance().getHOTLINEFORM(), HotlineFormController.servePage);
        get(ViewUtil.PATH.getWebInstance().getHELPLINE(), HelplineController.serveIndexPage);
        get(ViewUtil.PATH.getWebInstance().getCHAT(), ChatController.serveIndexPage);

    }

}
