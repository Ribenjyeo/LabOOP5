package sample;

import java.io.Serializable;

public class User implements Serializable{
    public static Object Admin;
    private String name;
    private String login;
    private String password;

    public User(){}

    public User(String name, String login, String password){
        super();
        this.name = name;
        this.login = login;
        this.password = password; }

    String getName(){//Возвращает имя
        return this.name;
    }

    String getLogin(){ //Возвращает логин
        return this.login;
    }

    public String getPassword(){ //Возвращает пароль
        return this.password;
    }

    @Override
    public String toString(){
        return "User [name = " +name +", login = " + login +", password = " +password + "]";
    }

    static class Admin {
        private String login = "admin";
        private String password = "admin";

        Admin(String login, String password){
            login = this.login;
            password = this.password;
        }

        String getLogin(){
            return this.login;
        }

        String getPassword(){
            return this.password;
        }
    }
}
