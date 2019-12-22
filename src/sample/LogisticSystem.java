package sample;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class LogisticSystem extends JFrame{
    public static List<User> users = new ArrayList<>(); //список пользователей

    static void addUser(String name, String login, String password){ //Добавление пользователя
        users.add(new User(name, login, password));

    }

   static boolean FindUser(String login, String password){ //Поиск пользователя по массиву пользователей
        for(User u: users){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        users = new ArrayList<User>();
        new GUI().Menu();
        Map map = new Map();

    }
}
