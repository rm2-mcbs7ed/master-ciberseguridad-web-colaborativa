package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        if (!isPasswordValid(password)){
            flash.put("error", "La contraseña es demasiado corta");
            register();
        }

        User u = new User(username, HashUtils.getMd5(password), type, -1);
        u.save();
        registerComplete();
    }

    public static void registerComplete(){
        render();
    }


    public static boolean isPasswordValid(String password){
        return password.length() > 7;
    }
}
