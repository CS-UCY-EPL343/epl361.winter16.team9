package com.wa.main;



import com.cmsl.security.Keys;
import com.wa.hotline.HotlineCaseHandler;
import com.wa.hotline.HotlineController;
import com.wa.hotline.HotlineFormController;
import com.wa.index.IndexController;
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
            staticFiles.location("/public");
        }else{
            System.out.println("Running from jar");
            //Zacharias PC
            //externalStaticFileLocation("/home/zgeorg03/Copy/ComputerScience/7th-Semester/cs361/epl361.winter16.team9/allProjects/WebApp/src/main/resources/public");
            //Raspberry
            externalStaticFileLocation("/home/zgeorg03/public");

        }
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


        //Hotline
        String hotlinePath = ViewUtil.PATH.getWebInstance().getHOTLINE();
        String hotlineTemplatePath = ViewUtil.PATH.getTemplateInstance().getHOTLINE();
        HotlineController hotlineController = new HotlineController(hotlinePath,hotlineTemplatePath,handlers.getLoggersHandler().getHotlineLogger());
        get(hotlinePath, hotlineController.getMainRoute());

        //HotlineForm
        HotlineCaseHandler hotlineCaseHandler = new HotlineCaseHandler(handlers.getDirectoriesHandler().getHotlineCasesDirectory());
        String hotlineFormPath = ViewUtil.PATH.getWebInstance().getHOTLINEFORM();
        String hotlineFormTemplatePath = ViewUtil.PATH.getTemplateInstance().getHOTLINEREPORT();
        HotlineFormController hotlineFormController = new HotlineFormController(hotlineFormPath,hotlineFormTemplatePath,
                privateKey, hotlineCaseHandler, handlers.getLoggersHandler().getHotlineLogger());
        get(hotlineFormPath, hotlineFormController.getMainRoute());
        post(ViewUtil.PATH.getWebInstance().getHOTLINEFORMSUBMIT(), hotlineFormController.serveHotlineFormSubmission);



        after((request, response) -> {
            response.header("Content-Encoding", "gzip");
        });

        //Initialize

        Keys.decrypt(privateKey,Keys.encrypt(publicKey,"test"));

    }

}
