package ru.geekbrains.java2.dz.dz4.esomov;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jess on 25.03.2017.
 */
class MyWindow extends JFrame{

    private static String FileBD = "src\\ru\\geekbrains\\java2\\dz\\dz4\\esomov\\History.txt"; //Файл переписки
    private static JTextArea ta; //Поле для всех сообщений
    private static JTextField t; //Поле для ввода сообщений

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

        //Обработка нажатия клавиши Enter
        t.addActionListener(e -> sendText());
        snd.addActionListener(new ActionListener() { //Обработка нажатия клавиши Send
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });
        upd.addActionListener(new ActionListener() { //Обработка нажатия клавиши Update
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

    //Добаление текста в поле TextArea и запись в файл
    private void sendText()  {
        String sText = t.getText(); //получений значения из TextField
        if (!sText.equals("")) { //проверка на пустой ввод данных
            sText += "\n"; //Запись перевода строки
            ta.append(sText); //Добаление сообщения в TextArea
            writeChat(sText); //Запись сообщения в файл
            t.setText(null); //Очистить поле TextField
        }
    }

    //Чтение из файла в поле TextArea - отображение переписки
    private void readChat() throws IOException {
        java.util.List<String> lines = Files.readAllLines(Paths.get(FileBD), StandardCharsets.UTF_8);
        String input = ""; //запись всех строк в input
        for(String line: lines) input += line+"\n"; //Чтение каждой строки с добавлением перевода
        ta.setText(input); //добавление текста в TextArea - чат
    }

    //Запись введенного сообщения из TextField в файл
    private void writeChat(String data) {
        File file = new File(FileBD); //создание или перезапись файла для переписки
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true); //append true - текст добавляется, а не перезаписывается
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
