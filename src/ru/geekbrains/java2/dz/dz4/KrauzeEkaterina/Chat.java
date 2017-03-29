package ru.geekbrains.java2.dz.dz4.KrauzeEkaterina;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Chat extends JFrame {

    private static final String FILE_NAME = "1.txt";

    Chat() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea(17, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);

        JTextField textField = new JTextField(40);
        textField.setToolTipText("Write your message");

        JButton button = new JButton("Send");
        button.setAlignmentX(CENTER_ALIGNMENT);

        getContentPane().add(textArea);
        getContentPane().add(textField);
        getContentPane().add(button);

        setVisible(true);

        textField.requestFocusInWindow();

        textField.addActionListener(e -> sendMessage(textField, textArea));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendMessage(textField, textArea);
            }
        });
    }

    private void sendMessage(JTextField textField, JTextArea textArea) {
        String text = textField.getText().trim();
        if (!text.isEmpty()) {
            String message = "Your message: " + text + "\n";
            writeToFile(message);
            textArea.append(message);
        }
        textField.setText("");
    }

    private void writeToFile(String message) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true));
            pw.append(message);
            pw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
