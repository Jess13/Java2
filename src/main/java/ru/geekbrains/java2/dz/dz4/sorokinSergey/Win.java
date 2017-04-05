package ru.geekbrains.java2.dz.dz4.sorokinSergey;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Win extends JFrame  {
	
	public static FileWriter writer = null;
	JTextArea jta = new JTextArea();
	JTextField jtf = new JTextField();
	
	public Win() {
		setBounds(200, 100, 800, 600);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(new GridBagLayout());
		constraints.weightx = 1.0;
		constraints.insets.set(10,10,10,10);
		constraints.fill = GridBagConstraints.BOTH;
		
		/*Textarea*/
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta);
		jta.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		constraints.weighty = 0.95;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		add(jta, constraints);
		
		/*TextFiedle*/
        constraints.weighty = 0.05;
        constraints.weightx = 0.9;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
        add(jtf, constraints);
        jtf.requestFocus();
        jtf.addActionListener(e -> {writeMassage();});
		
        /*Button*/
        JButton buttonPost = new JButton("send");
        constraints.weightx = 0.1;
		constraints.gridx = 1;
		constraints.gridy = 1;
        add(buttonPost, constraints);
        buttonPost.addActionListener(e -> {writeMassage();});

		setVisible(true);
	}

	private void writeMassage() {
		jta.append(jtf.getText() + "\n");
		try {
			writer = new FileWriter("java2//src//ru//geekbrains//java2//dz//dz4//sorokinSergey//archivChat.txt", true);
			writer.write(jtf.getText() + "\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			if (writer != null) {
				try {
					 jtf.setText("");
	            	 writer.flush();
					 writer.close();
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		
	}
	
	

}
