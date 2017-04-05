package ru.geekbrains.java2.dz.dz4.PeterKalashnikov;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Form extends JFrame {
    public Form() {
        setTitle("Chat Windows");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 75, 400, 500);
        setMinimumSize(new Dimension(300, 150));
        setLayout(new BorderLayout());

        JTextArea messageHistory = new JTextArea();
        messageHistory.setEnabled(false);
        messageHistory.setDisabledTextColor(Color.black);
        JScrollPane scrollPane = new JScrollPane(messageHistory);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.isMaximumSizeSet();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageHistory.setText(messageHistory.getText()+textField.getText()+"\n");
                writeMessageHistory("\n"+textField.getText());
                textField.setText("");
            }
        });
        panel.add(textField, BorderLayout.CENTER);

        JButton buttonSend = new JButton("Send");
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageHistory.setText(messageHistory.getText()+"\n"+textField.getText());
                writeMessageHistory(textField.getText());
                textField.setText("");
            }
        });
        panel.add(buttonSend, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);


        setVisible(true);
    }

    private void writeMessageHistory(String message) {
        try {
            if (new File("MessageHistory.txt").exists()) {
                writeToFile(readFromFile()+message);
            } else {
                writeToFile(message);
            }
        } catch (Exception e) {
            System.out.println("IO ERROR");
        }
    }

    private void writeToFile (String message) {
        try {
            PrintWriter writeToFile = new PrintWriter(new FileWriter("MessageHistory.txt"), true);
            writeToFile.println(message);
            writeToFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile () {
        String readFromFile = new String();
        int i;
        try {
            FileInputStream fileInputStream = new FileInputStream("MessageHistory.txt");
            do {
                i = fileInputStream.read();
                if (i!=-1) {
                    readFromFile += (char)i;
                }
            } while (i!=-1);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readFromFile;
    }
}