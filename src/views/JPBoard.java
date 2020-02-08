package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import models.Computer;
import utils.Utils;

public class JPBoard extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Computer> computers;
	private int size = 0;
	private GridBagConstraints gbc;

	public JPBoard() {
		computers = new ArrayList<Computer>();
		this.setBackground(Color.WHITE);
		gbc = new GridBagConstraints();
	}
	
	public void updateBoard(ArrayList<Computer> computers) {
		this.computers = computers;
		this.repaint();
	}
	
	private void drawComputer(Computer com, int x, int y, Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource(ConstantsGUI.URL_PC)).getImage(), x, y, this);
		defineColorStatePC(com, g);
		g.fillRect(x+30, y, 10, 10);
		g.setColor(Color.BLACK);
		g.drawString("Id: " + com.getId(), x, y +50);
	}
	
	private void defineColorStatePC(Computer com, Graphics g) {
		switch (com.getComputerState()) {
		case FREE:
			g.setColor(Color.decode("#25ec0e"));
			break;
		case DAMAGED:
			g.setColor(Color.RED);
			break;
		case OCCUPIED:
			g.setColor(Color.BLUE);
			break;
		default:
			break;
		}
	}
	
	private void paintBoard(Graphics g) {
		int x = 20;
		int y = 30;
		for (int i = 0; i < computers.size(); i++) {
			drawComputer(computers.get(i), x, y, g);
			if (x <= (this.getWidth() - 130)) {
				x+=120;				
			}else {
				y+=100;
				x = 20;
				size++;
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintBoard(g);
		Utils.generateBasicGrid(this, size, gbc);
	}
	
}
