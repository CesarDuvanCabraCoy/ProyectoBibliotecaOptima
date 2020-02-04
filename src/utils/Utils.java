package utils;

import java.awt.Container;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class Utils {

	public static void generateBasicGrid(Container comp, int quantityColumns, GridBagConstraints gbc){
		gbc.weightx = 1;
		for (int i = 0; i < quantityColumns; i++) {
			gbc.gridx = i;
			comp.add(new JLabel(""), gbc);
		}
	}
	
}
