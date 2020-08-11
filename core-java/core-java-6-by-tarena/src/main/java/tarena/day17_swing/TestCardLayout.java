package tarena.day17_swing;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCardLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试CardLayout");
		CardLayout layout = new CardLayout();
		f.setLayout(layout);
		JPanel p1 = new JPanel();
		//Color red = new Color(255,0,0);
		//Color red = Color.RED;
		p1.setBackground(Color.RED);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.BLUE);
		JPanel p3 = new JPanel();
		p3.setBackground(Color.BLACK);
		
		f.add(p1, "red");
		f.add(p2, "blue");
		f.add(p3, "black");
		//layout.show(f.getContentPane(), "black");
		f.setSize(400, 300);
		f.setVisible(true);
		for(int i=0; i<100; i++){
			layout.next(f.getContentPane());
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}
}
