package sample;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


public class GUI {

    public void Menu(){

        JFrame frame = new JFrame("Главное меню");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(500, 330);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Регистрация");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b2 = new JButton("Вход");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b3 = new JButton("Выход");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b4 = new JButton("Открыть");
        b4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b4.setForeground(Color.blue);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b5 = new JButton("Сохранить");
        b5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b5.setForeground(Color.blue);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() { //Регистрация
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration();
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() { //Вход
            @Override
            public void actionPerformed(ActionEvent e) {
                Authorization();
                frame.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {//Выход
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        b4.addActionListener(new ActionListener() {//Открыть файл
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = fc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fc.getSelectedFile();
                    ClassSeriyazableFile csf = new ClassSeriyazableFile(selectedFile.getAbsolutePath());
                    try {
                        LogisticSystem.users = csf.readfile();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                }
            }
        });

        b5.addActionListener(new ActionListener() {//Сохранить файл
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = fc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fc.getSelectedFile();
                    ClassSeriyazableFile csf = new ClassSeriyazableFile(selectedFile.getAbsolutePath());
                    try {
                        csf.collection((ArrayList<User>) LogisticSystem.users);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                }
            }
        });

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void Registration(){
        JFrame frame = new JFrame("Регистрация пользователя");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Имя");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Логин");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Пароль");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l3.setForeground(Color.blue);
        l3.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t3 = new JTextField(10);
        t3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t3.setForeground(Color.blue);
        t3.setAlignmentX(Component.LEFT_ALIGNMENT);
        p3.add(l3);
        p3.add(t3);

        JPanel p4 = new JPanel();
        JButton b1 = new JButton("Зарегистрироваться");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean repeat = false;
                String name = t1.getText();
                String login = t2.getText();
                String password = t3.getText();

                for (User user : LogisticSystem.users){
                    if (user.getLogin().compareTo(login) == 0){
                        JOptionPane.showMessageDialog(null, "Этот логин уже занят");
                        repeat = true;
                        break;
                    }
                }
                if(repeat)
                    return;
                LogisticSystem.addUser(name, login, password);



                frame.dispose();
                Menu();
            }
        });
        p4.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void Authorization(){
        JFrame frame = new JFrame("Авторизация пользователя");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 100);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Логин");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Пароль");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Войти");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = t1.getText();
                String password = t2.getText();

                if (login.equals("")|| password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Вы ничего не заполнили");
                    frame.dispose();
                    Menu();
                    return;
                } else if (login.equals("admin") && password.equals("admin")) {
                    frame.dispose();
                    Admin();
                } else if (LogisticSystem.FindUser(login, password) == true) {
                    frame.dispose();
                   User();
                } else {
                    JOptionPane.showMessageDialog(null, "В списках нет такого пользователя");
                    frame.dispose();
                    Menu();
                    return;
                }

            }
        });
        p3.add(b1);
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void Admin(){
        JFrame frame = new JFrame("Панель Администратора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Добавить связь между районами");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b2 = new JButton("Добавить информацию о пробке");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b3 = new JButton("Узнать маршрут");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b4 = new JButton("Выход");
        b4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b4.setForeground(Color.blue);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] tables = {"Имя", "Логин", "Пароль"};
        String[][] data = new String[LogisticSystem.users.size()][3];
        int i = 0;
        for (User u : LogisticSystem.users){
            data[i][0] = u.getName();
            data[i][1] = u.getLogin();
            data[i][2] = u.getPassword();
            i++;
        }
        JTable t = new JTable(data, tables);
        t.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t.setForeground(Color.blue);
        t.setAlignmentX(Component.LEFT_ALIGNMENT);
        t.setPreferredScrollableViewportSize(t.getPreferredSize());
        t.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(t);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                new AddEdge().on(i);
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                new AddBackpoint().on(i);
                frame.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                new SearchWay().on(i);
                frame.dispose();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu();
            }
        });

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(sp);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void User(){
        JFrame frame = new JFrame("Добро пожаловать пользователь");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JButton b2 = new JButton("Добавить информацию о пробке");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b3 = new JButton("Узнать маршрут");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b4 = new JButton("Выход");
        b4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b4.setForeground(Color.blue);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);



        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 1;
                new AddBackpoint().on(i);
                frame.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 1;
                new SearchWay().on(i);
                frame.dispose();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu();
            }
        });

        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

