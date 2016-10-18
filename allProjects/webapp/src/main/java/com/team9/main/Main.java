package com.team9.main;

import static spark.Spark.*;

/**
 * Created by zgeorg03 on 10/18/16.
 */
public class Main {


    public static void main(String args[]){
        port(80);

        get("/",(req,res)->{

            return "Welcome";
        });

    }
}
