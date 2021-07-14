package tarena.day17_swing;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGridBagLayout {
	private JFrame frame = new JFrame("测试GridBagLayout");
	protected void makebutton(String name, GridBagLayout gridbag,
			GridBagConstraints c) {
		JButton button = new JButton(name);
		gridbag.setConstraints(button, c);
		frame.add(button);
	}

	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		frame.setFont(new Font("SansSerif", Font.PLAIN, 14));
		frame.setLayout(gridbag);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		makebutton("Button1", gridbag, c);
		makebutton("Button2", gridbag, c);
		makebutton("Button3", gridbag, c);

		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		makebutton("Button4", gridbag, c);

		c.weightx = 0.0; // reset to the default
		makebutton("Button5", gridbag, c); // another row

		c.gridwidth = GridBagConstraints.RELATIVE; // next-to-last in row
		makebutton("Button6", gridbag, c);

		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		makebutton("Button7", gridbag, c);

		c.gridwidth = 1; // reset to the default
		c.gridheight = 2;
		c.weighty = 1.0;
		makebutton("Button8", gridbag, c);

		c.weighty = 0.0; // reset to the default
		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		c.gridheight = 1; // reset to the default
		makebutton("Button9", gridbag, c);
		makebutton("Button10", gridbag, c);

		frame.setSize(400, 300);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		TestGridBagLayout test = new TestGridBagLayout();
		test.init();
	}

}
