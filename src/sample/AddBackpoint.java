package sample;

import javax.swing.*;
import java.awt.event.*;

public class AddBackpoint extends JDialog {
    private JPanel Pane1;
    private JButton buttonOK;
    private JFrame frame;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton buttonCancel;
    private int n;

    public AddBackpoint() {

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String backup =  textField1.getText();
                String place1 = (String) comboBox1.getSelectedItem();
                String place2 = (String) comboBox2.getSelectedItem();
                for(Edge u: Map.edge) {
                    if(u.getPoint1().equals(place1) && u.getPoint2().equals(place2)){
                        Map.addBackup(place1, place2, Integer.parseInt(backup));}
                }

                if(n == 0){
                        frame.dispose();
                        new GUI().Admin();
                }
                else{
                    frame.dispose();
                    new GUI().User();
                }
            }
        });
    }

    public void on(int i){
        n = i;
        frame = new JFrame();
        frame.setContentPane(Pane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        for(Edge u : Map.edge){
            comboBox1.addItem(u.getPoint1());
            comboBox2.addItem(u.getPoint2());
        }


    }
}
