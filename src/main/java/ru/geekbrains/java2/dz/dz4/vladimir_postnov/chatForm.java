package ru.geekbrains.java2.dz.dz4.vladimir_postnov;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class chatForm extends JFrame {
	
	JPanel textChatPanel = new JPanel();
	JPanel enterChatPanel = new JPanel();
	
	final JTextArea textArea = new JTextArea();
	final JScrollPane scrollPane = new JScrollPane(textArea);
	JButton button = new JButton("Enter");
	final JTextField TextField = new JTextField();
	
	chatForm() {
		
		setTitle("Chat Form");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(300, 300, 400, 400);
		setLayout(new BorderLayout());	
		add(textChatPanel, BorderLayout.CENTER);
		add(enterChatPanel, BorderLayout.SOUTH);
		textChatPanel.setLayout(new BorderLayout());
		enterChatPanel.setLayout(new BoxLayout(enterChatPanel, BoxLayout.X_AXIS));
		enterChatPanel.setPreferredSize(new Dimension(0, 30));
		enterChatPanel.add(TextField);
		enterChatPanel.add(button);		
		textChatPanel.add(scrollPane);
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			      if (String.valueOf(e.getKeyChar())!="") {
			         e.consume();
			      }
			   }
		});
		
		TextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			      if (e.getKeyChar()==KeyEvent.VK_ENTER) {
			    	  textToChat();
			      }
			   }
		});
		
		button.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent e) {
				textToChat();	
			 }
			});		
		setVisible(true);
		
	}
	
	public void textToChat() {
		
		textArea.setText(textArea.getText() + TextField.getText() + "\n");		
		try {
			FileWriter writer = new FileWriter("src\\ru\\geekbrains\\java2\\dz\\dz4\\vladimir_postnov\\chat666.txt", true);
			writer.write("\n" + TextField.getText());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Файл не найден");
			e.printStackTrace();
		}
		TextField.setText("");
	}
	

}
