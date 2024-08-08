package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;


import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Triangles script = new Triangles();
        if (command.equals("runScript")) {
            System.out.println("Starting...");
            JFrame mainFrame = new JFrame("Triangles");

            mainFrame.setSize(1000,300);
            JLabel mes=new JLabel("Input number string: ");
            mes.setFont(new Font("sans-serif,plain",Font.PLAIN,20));
            mes.setForeground(Color.WHITE);
            mes.setBounds(30,50,200,50);
            JTextArea textArea = new JTextArea();
            textArea.setBounds(230,50,700,60);
            mainFrame.getContentPane().add(mes);
            JButton submit = new JButton("Submit");
            submit.setBounds(50,150,90,30);
            JButton saveToFile = new JButton("Save to file");
            saveToFile.setBounds(840,150,90,30);
            JLabel resLabel=new JLabel();
            resLabel.setText("Script result: ");
            resLabel.setBounds(425,200,100,30);
            JLabel result =new JLabel();
            resLabel.setVisible(false);
            result.setVisible(false);
            result.setBounds(525,200,100,30);
            resLabel.setForeground(Color.WHITE);
            result.setForeground(Color.WHITE);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String resultString=script.task(textArea.getText());
                    result.setText(resultString);
                    resLabel.setVisible(true);
                    result.setVisible(true);
                }
            });
            saveToFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                    System.out.println(script.lastInput+" -> "+script.lastResult);
                    File file=new File("backup.txt");
                        FileWriter writer=new FileWriter(file,true);
                        if(script.lastInput!="" && script.lastResult!="" && script.lastResult!="Error")
                        writer.write("\n"+script.lastInput+" -> "+script.lastResult);
                        writer.close();
                }
                catch(Exception ex){ex.printStackTrace();}
                }
            });
            mainFrame.getContentPane().setLayout(null);
            mainFrame.getContentPane().setVisible(true);
            mainFrame.setResizable(false);
            textArea.setBackground(Color.lightGray);
            mainFrame.getContentPane().setBackground(Color.darkGray);
            mainFrame.getContentPane().add(textArea);
            mainFrame.getContentPane().add(submit);
            mainFrame.getContentPane().add(saveToFile);
            mainFrame.getContentPane().add(result);
            mainFrame.getContentPane().add(resLabel);
            mainFrame.setVisible(true);


        }
        if(command.equals("info")) {
            JFrame mainFrame = new JFrame("Triangles");
            mainFrame.getContentPane().setBackground(Color.darkGray);
            mainFrame.setSize(600, 250);
            JLabel mes = new JLabel("<html>  <h1>Project v1.0</h1><br> <h2>  Task: Triangles (IO)</h2> <br>   Task Overview: For a list of numbers from 1 to 1000000000,<br>   check if there is a set of three numbers that could satisfy the traingle condition, else print NIE</html>", SwingConstants.CENTER);
            mes.setBounds(30, 50, 300, 200);
            mes.setForeground(Color.WHITE);
            mainFrame.getContentPane().add(mes);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
            mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            script.info();
        }
        if(command.equals("backup")){
            System.out.println("Doing backup...");
        }

        if(command.equals("quit")){
            System.out.println("Exiting...");
            JFrame quitConfirm = new JFrame("Quit");
            quitConfirm.getContentPane().setBackground(Color.darkGray);
            quitConfirm.setSize(400,250);
            JLabel mes=new JLabel("Do you want to quit?");
            JButton yes=new JButton("Yes");
            JButton no=new JButton("No");
            yes.setActionCommand("exit");
            quitConfirm.setResizable(false);
            mes.setBounds(145,50,200,50);
            yes.setBounds(80,100,80,50);
            no.setBounds(240,100,80,50);
            quitConfirm.getContentPane().setLayout(null);
            quitConfirm.getContentPane().setVisible(true);
            no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { quitConfirm.dispose();
                }
            });
            yes.addActionListener(new ButtonActionListener());
            mes.setForeground(Color.WHITE);
            quitConfirm.add(mes);
            quitConfirm.add(yes);
            quitConfirm.add(no);
            quitConfirm.setVisible(true);
        }
        if(command.equals("exit")){System.exit(0);}
    }
}
