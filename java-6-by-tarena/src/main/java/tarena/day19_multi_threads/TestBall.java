package tarena.day19_multi_threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestBall {
	public static void main(String[] args) {
		new BallFrame();
	}
}

class Ball{
	private static final int X_SIZE = 20;
	private static final int Y_SIZE = 20;
	private int x;
	private int y;
	private int dx = 5;
	private int dy = 5;
	private Color color;
	public Ball() {
		Color[] colors = {
				Color.BLACK,
				Color.BLUE,
				Color.CYAN,
				Color.DARK_GRAY,
				Color.GREEN,
				Color.MAGENTA,
				Color.ORANGE,
				Color.RED,
				Color.YELLOW
		};
		color = colors[new Random().nextInt(colors.length)];
	}
	
	public void move(JPanel panel){
		x += dx;
		y += dy;
		if(x+X_SIZE>=panel.getWidth()){
			dx = -dx;
		}
		if(y+Y_SIZE>=panel.getHeight()){
			dy = -dy;
		}
		if(x<=0){
			x = 0;
			dx = -dx;
		}
		if(y<=0){
			dy = -dy;
		}
	}
	
	public void draw(Graphics g){
		Ellipse2D shape = new Ellipse2D.Double(x, y, X_SIZE, Y_SIZE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fill(shape);
	}
}
class BallPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7593012545023439974L;
	private HashSet<Ball> balls = new HashSet<Ball>();
	public void addBall(Ball ball){
		balls.add(ball);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Ball ball : balls){
			ball.draw(g);
		}
	}
}

class BallThread extends Thread{
	private Ball ball;
	private BallPanel ballPanel;
	public BallThread(BallPanel ballPanel) {
		this.ballPanel = ballPanel;
	}
	public void setBall(Ball ball){
		this.ball = ball;
	}
	public void run(){
		for(int i=0; i<100000; i++){
			ball.move(ballPanel);
			ballPanel.repaint();
			try{Thread.sleep(20);}catch(Exception e){}
		}
	}
}
class BallFrame{
	private JFrame frame = new JFrame("弹球");
	private BallPanel ballPanel = new BallPanel();
	private JButton startButton = new JButton("开始");
	private JButton endButton = new JButton("结束");
	private class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Ball ball = new Ball();
			ballPanel.addBall(ball);
			BallThread t = new BallThread(ballPanel);
			t.setBall(ball);
			t.start();
		}
	}
	public BallFrame() {
		frame.add(ballPanel);
		JPanel panel = new JPanel();
		panel.add(startButton);
		panel.add(endButton);
		frame.add(panel, "South");
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ActionListener listener = new StartListener();
		startButton.addActionListener(listener);
	}
}

