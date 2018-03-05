package game.pow211;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class RoundJPanel extends JPanel {
	
	private Shape shape;

	public RoundJPanel(int size) {
		super();
		setOpaque(false); // ?
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 55, 55);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRoundRect(0, 1, getWidth() - 1, getHeight() - 2, 55, 55);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}
}

