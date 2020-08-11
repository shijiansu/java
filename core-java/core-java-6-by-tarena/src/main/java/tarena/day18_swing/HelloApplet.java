package tarena.day18_swing;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;

public class HelloApplet extends JApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5048546660912328196L;

	@Override
	public void paint(Graphics g) {
		g.setFont(new Font(null, Font.BOLD, 18));
		g.drawString("Hello Applet", 20, 20);
	}
}
