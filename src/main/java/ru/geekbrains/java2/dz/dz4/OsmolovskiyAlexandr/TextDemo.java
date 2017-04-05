package ru.geekbrains.java2.dz.dz4.OsmolovskiyAlexandr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


/*public static void saveToFile(String text) {
        ObjectOutputStream out = null;
        try {
        out = new ObjectOutputStream(new FileOutputStream("text.txt"));
        out.writeObject(text);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } finally {
        try {
        if (out != null) {
        out.flush();
        out.close();
        }
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
        }
*/

public class TextDemo extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";

    public TextDemo() {
        super(new GridBagLayout());
        JFrame frame= new JFrame("Frame");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        textField = new JTextField(20);
        textField.addActionListener(this);
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton send1=new JButton("Send");
        send1.setSize(10,10);
        send1.setLocation(0,0);
        send1.addActionListener(new java.awt.event.ActionListener() { //привязываем слушатель
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = send1.getText();//получаем текст кнопки
                textField.setText(TextDemo.this.toString());
                //записываем этот текст в текстовое поле
            }
        });


        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        c.fill = GridBagConstraints.NONE;
        add(send1, c);



    }
    public static void createGUI() {

        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(270, 225));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();


        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
        System.out.println(text);

        // JButton

        ObjectOutputStream out = null;
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("1.txt")) ;
            //pw.println(textField);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {out = new ObjectOutputStream(new FileOutputStream("text.txt"));
                out.writeObject(textArea);


                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(270, 225));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //Add contents to the window.
//        frame.add(new ru.geekbrains.java2.dz.dz4.TextDemo());
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenuBar menuBar = new JMenuBar();
        //JMenuBar menuBar2 = new JMenuBar();

        JMenu fileMenu1 = new JMenu("File");
        fileMenu1.setFont(font);
        JMenu editMenu2 = new JMenu("Edit");
        editMenu2.setFont(font);


        JMenu newMenu = new JMenu("New");
        newMenu.setFont(font);
        fileMenu1.add(newMenu);

        JMenuItem txtFileItem = new JMenuItem("Text file");
        txtFileItem.setFont(font);
        newMenu.add(txtFileItem);

        JMenuItem imgFileItem = new JMenuItem("Image file");
        imgFileItem.setFont(font);
        newMenu.add(imgFileItem);

        JMenuItem folderItem = new JMenuItem("Folder");
        folderItem.setFont(font);
        newMenu.add(folderItem);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.setFont(font);
        fileMenu1.add(openItem);

        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.setFont(font);
        fileMenu1.add(closeItem);

        JMenuItem closeAllItem = new JMenuItem("Close all");
        closeAllItem.setFont(font);
        fileMenu1.add(closeAllItem);

        fileMenu1.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(font);
        fileMenu1.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu1);
        menuBar.add(editMenu2);

        frame.setJMenuBar(menuBar);


        frame.setPreferredSize(new Dimension(270, 225));
        frame.pack();


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();

            }
        });
    }
}
/*but.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

        s = tf.getText();
        }
        });*/

