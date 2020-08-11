package tarena.day18_swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat {
	private JTextArea text = new JTextArea();
	private JTextField msgText = new JTextField(15);
	private JButton sendButton = new JButton("发送");
	private class SendListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String msg = msgText.getText();
			text.append(msg);
			text.append("\n");
			msgText.setText("");
		}
	}
	public Chat() {
		JFrame f = new JFrame("聊天室");
		Font font = new Font(null, Font.BOLD, 20);
		text.setFont(font);
		msgText.setFont(font);
		f.add(text);
		JPanel panel = new JPanel();
		panel.add(msgText);
		panel.add(sendButton);
		f.add(panel, BorderLayout.SOUTH);
		
		f.setSize(400, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		ActionListener listener = new SendListener();
		sendButton.addActionListener(listener);
		msgText.addActionListener(listener);
		
	}
	public static void main(String[] args) {
		new Chat();
	}
}
