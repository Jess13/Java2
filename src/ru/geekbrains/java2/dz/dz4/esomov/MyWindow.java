package ru.geekbrains.java2.dz.dz4.esomov;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Jess on 25.03.2017.
 */
class MyWindow extends JFrame{

    private static JTextArea ta;
    private static JTextField t;

    MyWindow(){
        JFrame f = new JFrame("Chat");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        JPanel p = new JPanel();
        ta = new JTextArea(15, 30);
        t = new JTextField(22);
        ta.setLineWrap(true);
        ta.setEditable(false);
        JScrollPane sp = new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton snd = new JButton("Send");
        JButton upd = new JButton("Update");

        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });
        snd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });
        upd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readChat();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        p.add(sp);
        p.add(t);
        p.add(snd);
        p.add(upd);
        p.setBackground(new Color(100, 155,155));

        f.getContentPane().add(BorderLayout.CENTER, p);
        f.setSize(400,345);
        f.setVisible(true);
    }

    private void sendText()  {
        String sText = t.getText();
        if (!sText.equals("")) {
            sText += "\n";
            ta.append(sText);
            writeChat(sText);
            t.setText(null);
        }
    }

    private void readChat() throws IOException {
        FileReader fileReader = new FileReader("src\\ru\\geekbrains\\java2\\dz\\dz4\\esomov\\History.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String inputFile = "";
        String textFieldReadable = bufferedReader.readLine();
        try {
            while (textFieldReadable != null) {
                inputFile += textFieldReadable;
                textFieldReadable = bufferedReader.readLine();
            }
            ta.setText(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не существует!");
        }
        catch (IOException e) {
            System.out.println("Ошибка Ввода/Вывода!");
        }
    }

    private void writeChat(String data) {
        File file = new File("src\\ru\\geekbrains\\java2\\dz\\dz4\\esomov\\History.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(data);
            fr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
