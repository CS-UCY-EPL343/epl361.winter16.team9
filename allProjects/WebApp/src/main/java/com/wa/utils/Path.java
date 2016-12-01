package com.wa.utils;

/**
 * Created by zgeorg03 on 11/5/16.
 */
public class Path {
    private  final Web WebInstance = new Web();
    private  final Template TemplateInstance = new Template();

    public Template getTemplateInstance() {
        return TemplateInstance;
    }


    /**
     * Routes
     */
    public  class Web{

        private  final String INDEX = "/";
        private  final String REPORTS = "/reports";
        private  final String FAQ = "/faq";
        private  final String HOTLINE = "/reports/hotline";
       private  final String HOTLINESUBMIT = "/reports/hotline/submit";

        private  final String CHAT = "/chat";
        private  final String HOTLINECHAT = "/chat/hotline";
        private  final String HELPLINECHAT = "/chat/helpline";

        public String getINDEX() {
            return INDEX;
        }

        public String getHOTLINE() {
            return HOTLINE;
        }

        public String getCHAT() {
            return CHAT;
        }


        public String getREPORTS() {
            return REPORTS;
        }

        public String getFAQ() {
            return FAQ;
        }

        public String getHOTLINESUBMIT() {
            return HOTLINESUBMIT;
        }

        public String getHELPLINECHAT() {
            return HELPLINECHAT;
        }

        public String getHOTLINECHAT() {
            return HOTLINECHAT;
        }
    }

    public  class Template{
        private  final String INDEX = "index/index.ftl";
        private  final String REPORTS = "reports/report.ftl";
        private  final String FAQ = "/faq/faq.ftl";
        private  final String CHAT = "/chat/chat.ftl";
        private  final String HOTLINECHAT = "/chat/hotlineChat.ftl";
        private  final String HELPLINECHAT = "/chat/helplineChat.ftl";

        private  final String HOTLINE = "reports/hotlineForm.ftl";



        private  final String SUCCESSFULSUBMIT = "/reports/successfulSubmission.ftl";

        private  final String HELPLINE = "helpline/helpline.ftl";



        public  String getINDEX() {
            return INDEX;
        }

        public String getHOTLINE() {
            return HOTLINE;
        }

        public String getHELPLINE() {
            return HELPLINE;
        }

        public String getCHAT() {
            return CHAT;
        }


        public String getSUCCESSFULSUBMIT() {
            return SUCCESSFULSUBMIT;
        }

        public String getREPORTS() {
            return REPORTS;
        }


        public String getFAQ() {
            return FAQ;
        }

        public String getHELPLINECHAT() {
            return HELPLINECHAT;
        }

        public String getHOTLINECHAT() {
            return HOTLINECHAT;
        }
    }

    public  Web getWebInstance() {
        return WebInstance;
    }
}
