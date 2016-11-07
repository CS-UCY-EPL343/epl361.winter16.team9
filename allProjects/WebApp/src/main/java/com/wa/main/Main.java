package com.wa.main;

import com.wa.Utils.ViewUtil;
import com.wa.chat.ChatController;
import com.wa.helpline.HelplineController;
import com.wa.hotline.HotlineController;
import com.wa.hotline.HotlineFormController;
import com.wa.index.IndexController;

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
