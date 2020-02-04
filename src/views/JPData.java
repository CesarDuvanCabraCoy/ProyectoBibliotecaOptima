package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controllers.JBActions;
import controllers.MainController;
import utils.Utils;

public class JPData extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	private JLabel jlHour;
	private JSlider jsHour;
	private JLabel jlPCs;
	private JSlider jsPCs;
	private JLabel jlServiceTime;
	private JSlider jsServiceTime;
	private JButton jbStartSimulation;
	
	public JPData(MainController mainController) {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		init(mainController);
	}

	private void init(MainController mainController) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		Utils.generateBasicGrid(this, ConstantsGUI.COLUMNS_NUMBER, gbc);
		
		jlInfo = new JLabel(ConstantsGUI.JL_INFO_MODIFY_DATA);
		jlInfo.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 30));
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jlInfo, gbc);
		
		jlHour = new JLabel(ConstantsGUI.JL_INFO_HOUR);
		jlHour.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jlHour, gbc);
		
		jsHour = new JSlider();
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jsHour, gbc);
		
		jlPCs = new JLabel(ConstantsGUI.JL_INFO_PCS);
		jlPCs.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jlPCs, gbc);
		
		jsPCs = new JSlider();
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jsPCs, gbc);
		
		jlServiceTime = new JLabel(ConstantsGUI.JL_INFO_SERVICE_TIME);
		jlServiceTime.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jlServiceTime, gbc);
		
		jsServiceTime = new JSlider();  
		gbc.gridx = 5;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(jsServiceTime, gbc);
		
		jbStartSimulation = new JButton(ConstantsGUI.JB_START_SIMULATION);
		jbStartSimulation.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		jbStartSimulation.setActionCommand(JBActions.SHOW_STATISTICS.name());
		jbStartSimulation.addActionListener(mainController);
		jbStartSimulation.setBackground(Color.decode("#3adf27"));
		gbc.gridx = 10;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.3;
		this.add(jbStartSimulation, gbc);
	}
	

}
