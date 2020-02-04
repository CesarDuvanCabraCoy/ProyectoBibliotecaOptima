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
import controllers.JSActions;
import controllers.MainController;
import utils.Utils;

public class JPData extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlInfo;
	private JLabel jlDays;
	private JSlider jsDays;
	private JLabel jlValDays;
	private JLabel jlPCs;
	private JSlider jsPCs;
	private JLabel jlValPCs;
	private JLabel jlServiceTime;
	private JSlider jsServiceTime;
	private JLabel jlValServiceTime;
	private JButton jbStartSimulation;
	private MainController mainController;
	
	
	public JPData(MainController mainController) {
		this.mainController = mainController;
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
		
		jlDays = new JLabel(ConstantsGUI.JL_INFO_DAYS);
		jlDays.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		this.add(jlDays, gbc);
		
		jsDays = new JSlider();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 5;
		createSlider(jsDays, JSActions.HOUR.toString(),8, 21, 10, 1, 5, gbc);
		
		jlPCs = new JLabel(ConstantsGUI.JL_INFO_PCS);
		jlPCs.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		this.add(jlPCs, gbc);
		
		
		jsPCs = new JSlider();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 5;
		createSlider(jsPCs, JSActions.PCS.toString(),90, 180, 140, 10, 10, gbc);
		
		jlServiceTime = new JLabel(ConstantsGUI.JL_INFO_SERVICE_TIME);
		jlServiceTime.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		this.add(jlServiceTime, gbc);
		
		jsServiceTime = new JSlider();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 5;
		createSlider(jsServiceTime, JSActions.SERVICE_TIME.toString(),40, 180, 120, 10, 10, gbc);
		
		jbStartSimulation = new JButton(ConstantsGUI.JB_START_SIMULATION);
		jbStartSimulation.setFont(new Font(ConstantsGUI.TYPE_LETTER, Font.BOLD, 20));
		jbStartSimulation.setActionCommand(JBActions.PLAY_SIMULATION.name());
		jbStartSimulation.addActionListener(mainController);
		jbStartSimulation.setBackground(Color.decode("#3adf27"));
		gbc.gridx = 10;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.3;
		this.add(jbStartSimulation, gbc);
	}
	
	
	private void createSlider(JSlider js, String name, int min, int max, int valueInit, int majorSpacing, int minorSpacing,
			GridBagConstraints gbc) {
//		js = new JSlider(min, max, valueInit);
		js.setMinimum(min);
		js.setMaximum(max);
		js.setValue(valueInit);
		js.setMajorTickSpacing(majorSpacing);
		js.setMinorTickSpacing (minorSpacing);
		js.setPaintTicks(true);
		js.setName(name);
		js.addChangeListener(mainController);
		js.setBackground(Color.WHITE);
		js.setPaintLabels(true);
		this.add(js, gbc);
	}

	public int getDataDays() {
		return jsDays.getValue();
	}
	
	public int getDataPCs() {
		return jsPCs.getValue();
	}
	
	public int getDataServiceTime() {
		return jsServiceTime.getValue();
	}
	
}
