package tarena.day18_swing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HuaTu {
	public static void main(String[] args) {
		JFrame frame = new JFrame("画图");
		DrawPanel panel = new DrawPanel();
		frame.add(panel);
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class Point{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Line{
	private ArrayList<Point> points = new ArrayList<Point>();
	public void addPoint(Point p){
		points.add(p);
	}
	public void draw(Graphics g){
		Point start = points.get(0);
		if(start==null){
			return;
		}
		for(Point p : points){
			g.drawLine(start.getX(), start.getY(), p.getX(), p.getY());
			start = p;
		}
	}
}

class DrawPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8362088122046395520L;
	private ArrayList<Line> lines = new ArrayList<Line>();
	private Line currentLine;
	private class DrawPaneMousePressListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			currentLine = new Line();
		}

		public void mouseReleased(MouseEvent e) {
			lines.add(currentLine);
		}
		
	}
	private class DrawPanelMouseDragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			currentLine.addPoint(new Point(e.getX(), e.getY()));
			repaint();
		}
	}
	public DrawPanel() {
		this.addMouseListener(new DrawPaneMousePressListener());
		this.addMouseMotionListener(new DrawPanelMouseDragListener());
	}
	public void paint(Graphics g){
		for(Line line : lines){
			line.draw(g);
		}
		if(currentLine!=null){
			currentLine.draw(g);
		}
	}
}
