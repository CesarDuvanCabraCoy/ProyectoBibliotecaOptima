package utils;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

public class Utils {

	public static void generateBasicGrid(Container comp, int quantityColumns, GridBagConstraints gbc){
		gbc.weightx = 1;
		for (int i = 0; i < quantityColumns; i++) {
			gbc.gridx = i;
			comp.add(new JLabel(""), gbc);
		}
	}
	
	public static void generateBasicLabelsPCs(Container comp, int quantityRows, GridBagConstraints gbc) {
		gbc.weighty = 10;
		gbc.fill = GridBagConstraints.BOTH;
		for (int i = 0; i < quantityRows; i++) {
			gbc.weighty= 100;
			gbc.gridy = i;
			comp.add(new JLabel("A"), gbc);
			System.out.println("El hijo de puta i: " + i);
		}
	}
	
}
