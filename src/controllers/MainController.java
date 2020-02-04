package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainWindow;

public class MainController implements ActionListener{

	private MainWindow mainWindow;
	
	public MainController() {
		this.mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
