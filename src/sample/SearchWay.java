package sample;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

public class SearchWay extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton найтиButton;
    private JFrame frame;
    private int n;

    public SearchWay() {

        найтиButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String place1 = (String) comboBox1.getSelectedItem();
                String place2 = (String) comboBox2.getSelectedItem();
                int g = 0;
                LinkedList Way = new LinkedList();
                for(Edge u: Map.edge){
                    if (u.getPoint1().equals(place1) && u.getPoint2().equals(place2)) {
                        JOptionPane.showMessageDialog(null, "Пусть который нужно пройти [" + place1 + ", " + place2 + "] Пробка составляет " + u.getBackup() / Map.edge.size());
                        if(n == 0){
                            frame.dispose();
                            new GUI().Admin();
                        }
                        else{
                            frame.dispose();
                            new GUI().User();
                        }
                        return;
                    }
                }
                for (Edge u : Map.edge) {
                    if (u.getPoint1().equals(place1)) {
                        Way.add(place1);
                        place1 = u.getPoint2();
                        g += u.getBackup();
                        if (u.getPoint2().equals(place2)) {
                            Way.add(place2);
                            JOptionPane.showMessageDialog(null, "Пусть который нужно пройти " + Way + "Пробка составляет " + g / Map.edge.size());
                            if(n == 0){
                                frame.dispose();
                                new GUI().Admin();
                            }
                            else{
                                frame.dispose();
                                new GUI().User();
                            }
                        }
                    }
                }


            }
        });

    }
    public void on(int i){
        n = i;
        frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        for(Edge u : Map.edge){
            comboBox1.addItem(u.getPoint1());
            comboBox2.addItem(u.getPoint2());
        }


        }
    }

