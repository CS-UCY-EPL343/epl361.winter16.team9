package com.wa.main;


import com.cmsl.security.Keys;
import com.wa.controllers.*;
import com.wa.reports.HotlineCaseHandler;
import com.wa.controllers.HotlineController;
import com.wa.utils.Handlers;
import com.wa.utils.ViewUtil;

import java.io.File;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import static spark.Spark.*;

/**
 * Created by zgeorg03 on 10/18/16.
 */
public class Main {


    public static void main(String args[]) throws Exception {
        secure("./keys/keystore.jks","Epl361team9",null,null);
        int port = 8000;
        String location ="./data/";
        if(args.length==2){
            port = Integer.parseInt(args[0]);
            location = args[1];
        }

        port(port);

        String toks[]= ClassLoader.getSystemResource("com/wa/main/Main.class").toString().split(":");
        if(toks[0].equalsIgnoreCase("file")){
            System.out.println("Running from file");
            staticFileLocation("/public/");
        }else{
            System.out.println("Running from jar");
            //Zacharias PC
            //externalStaticFileLocation("/home/zgeorg03/Copy/ComputerScience/7th-Semester/cs361/epl361.winter16.team9/allProjects/WebApp/src/main/resources/public");
            //Raspberry
            externalStaticFileLocation("/home/spenseve/cs361/public");
        }
        staticFiles.expireTime(500);



        File file = new File(System.getProperty("user.dir"));
        String name =file.getAbsolutePath()+ "/keys/test";
        KeyPair keyPair = Keys.loadKeyPair(name);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();


        Handlers handlers = new Handlers(location);

        //Index
        String indexPath = ViewUtil.PATH.getWebInstance().getINDEX();
        String indexTemplatePath = ViewUtil.PATH.getTemplateInstance().getINDEX();
        IndexController indexController = new IndexController(indexPath,indexTemplatePath,handlers.getLoggersHandler().getRootLogger());
        get(indexPath, indexController.getMainRoute());


        //Reports
        String reportsPath = ViewUtil.PATH.getWebInstance().getREPORTS();
        String reportsTemplatePath = ViewUtil.PATH.getTemplateInstance().getREPORTS();
        ReportsController reportsController = new ReportsController(reportsPath,reportsTemplatePath,handlers.getLoggersHandler().getRootLogger());
        get(reportsPath, reportsController.getMainRoute());

        //HotlineForm
        HotlineCaseHandler hotlineCaseHandler = new HotlineCaseHandler(handlers.getDirectoriesHandler().getHotlineCasesDirectory());
        String hotlineFormPath = ViewUtil.PATH.getWebInstance().getHOTLINE();
        String hotlineFormTemplatePath = ViewUtil.PATH.getTemplateInstance().getHOTLINE();

        HotlineController hotlineController = new HotlineController(hotlineFormPath,hotlineFormTemplatePath,
                privateKey, hotlineCaseHandler, handlers.getLoggersHandler().getHotlineLogger());
        get(hotlineFormPath, hotlineController.getMainRoute());
        post(ViewUtil.PATH.getWebInstance().getHOTLINESUBMIT(), hotlineController.serveHotlineFormSubmission);


        //CHAT
        String chatPath = ViewUtil.PATH.getWebInstance().getCHAT();
        String chatTemplatePath = ViewUtil.PATH.getTemplateInstance().getCHAT();
        ChatController chatController = new ChatController(chatPath,chatTemplatePath,handlers.getLoggersHandler().getRootLogger());
        get(chatPath, chatController.getMainRoute());

        //HotlineChat
        String hotlineChatPath = ViewUtil.PATH.getWebInstance().getHOTLINECHAT();
        String hotlineChatTemplatePath = ViewUtil.PATH.getTemplateInstance().getHOTLINECHAT();
        HotlineChatController hotlineChatController = new HotlineChatController(hotlineChatPath,hotlineChatTemplatePath,handlers.getLoggersHandler().getRootLogger());
        get(hotlineChatPath, hotlineChatController.getMainRoute());

        //HelplineChat
        String helplineChatPath = ViewUtil.PATH.getWebInstance().getHELPLINECHAT();
        String helplineChatTemplatePath = ViewUtil.PATH.getTemplateInstance().getHELPLINECHAT();
        HelplineChatController  helplineChatController = new HelplineChatController(helplineChatPath,helplineChatTemplatePath,handlers.getLoggersHandler().getRootLogger());
        get(helplineChatPath, helplineChatController.getMainRoute());

        //FAQ
        String faqPath = ViewUtil.PATH.getWebInstance().getFAQ();
        String faqTemplatePath = ViewUtil.PATH.getTemplateInstance().getFAQ();
        FAQController faqController = new FAQController(faqPath,faqTemplatePath,handlers.getLoggersHandler().getRootLogger());
        get(faqPath, faqController.getMainRoute());

        after((request, response) -> {
            response.header("Content-Encoding", "gzip");
        });

        //Initialize

        //Keys.decrypt(privateKey,Keys.encrypt(publicKey,"test"));

    }

}
