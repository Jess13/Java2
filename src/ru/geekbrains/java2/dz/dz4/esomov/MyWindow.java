package ru.geekbrains.java2.dz.dz4.esomov;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Jess on 25.03.2017.
 */
class MyWindow extends JFrame{

    private static String FileBD = "src\\ru\\geekbrains\\java2\\dz\\dz4\\esomov\\History.txt"; //Файл переписки
    private static JTextArea ta; //Поле для всех сообщений
    private static JTextField t; //Поле для ввода сообщений
    private static BufferedReader reader;
    private static PrintWriter writer;
    private static String nick;

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
        ta.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton sndFile = new JButton("SendFile");
        JButton updFile = new JButton("UpdateFile");
        JButton updSrv = new JButton("UpdateSrv");
        nick = "";

//        while (nick.equals("")) {
//            nick = JOptionPane.showInputDialog("Введите NickName");
//        }

        //Обработка нажатия клавиши Enter
        t.addActionListener(e -> sendText());
        //Обработка нажатия клавиши Send
        //sndFile.addActionListener(e -> sendText());
        sndFile.addActionListener(new Send());
        //Обработка нажатия клавиши Update
        updFile.addActionListener(e -> readChat());
        updSrv.addActionListener(e -> writer.print(""));

        Thread thread = new Thread(new Listen());
        thread.start();

        p.add(sp);
        p.add(t);
        p.add(sndFile);
        p.add(updFile);
        p.add(updSrv);
        p.setBackground(new Color(100, 155,155));

        f.getContentPane().add(BorderLayout.CENTER, p);
        f.setSize(400,350);
        f.setVisible(true);
    }

    private static class Listen implements Runnable {
        @Override
        public void run() {
            String msg;
            try {
                while (((msg=reader.readLine())!=null)) {
                    ta.append(msg+"\n");
                }
            } catch (Exception ex) {}
        }
    }

    private static class Send implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String msg = nick+": "+t.getText();
            writer.println(msg);
            writer.flush();
            t.setText(null); //Очистить поле TextField
            t.requestFocus(); //Поставить курсор в TextField
        }
    }

    //Установление соединения с сервером
    private void setNet() {
        try {
            Socket socket = new Socket("127.0.0.1", 5432);
            InputStreamReader inpStr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(inpStr);
            writer = new PrintWriter(socket.getOutputStream());
        } catch (Exception ex) {
            System.out.println("Can not connect to server!");
        }
    }

    //Добаление текста в поле TextArea и запись в файл
    private void sendText()  {
        String msg = nick+": "+t.getText(); //получений значения из TextField
        if (!t.getText().equals("")) { //проверка на пустой ввод данных
            msg += "\n"; //Запись перевода строки
            ta.append(msg); //Добаление сообщения в TextArea
            writeChat(msg); //Запись сообщения в файл
            t.setText(null); //Очистить поле TextField
            t.requestFocus(); //Поставить курсор в TextField
        }
    }

    //Чтение из файла в поле TextArea - отображение переписки
    private void readChat() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(FileBD), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input = ""; //запись всех строк в input
        assert lines != null;
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
