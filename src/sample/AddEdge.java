package sample;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEdge{
    private JPanel contentPane;
    private JButton buttonOK;
    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private int n;

    public AddEdge() {

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String edge1 = textField1.getText();
                String edge2 = textField2.getText();
                Map.addEdge(edge1, edge2, -1);
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
            frame.setContentPane(contentPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);



        }

}
