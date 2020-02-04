package views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import controllers.JBActions;
import controllers.MainController;

public class JTBMain extends JToolBar{

	private static final long serialVersionUID = 1L;
	private MainController mainController;
	private JButton jbStatistics;
	
	public JTBMain(MainController mainController) {
		this.mainController = mainController;
		this.setBackground(Color.decode("#44adf5"));
		this.setFloatable(false);
		this.setRollover(true);
		init();
	}
	
	private void init() {
		this.addSeparator();
		addButton(jbStatistics, ConstantsGUI.URL_IMAGE_STATISTICS, JBActions.SHOW_STATISTICS, ConstantsGUI.TT_JB_STATISTICS, true);
	}
	
	private void addButton(JButton jb, String urlImage, JBActions command, String toolTip, boolean enabled) {
		jb = new JButton(new ImageIcon(getClass().getResource(urlImage)));
		jb.setEnabled(enabled);
		jb.addActionListener(mainController);
		jb.setActionCommand(command.toString());
		jb.setToolTipText(toolTip);
		this.add(jb);
	}
}