package romejanic.clip.gui;

import java.awt.Component;

import javax.swing.JOptionPane;

import romejanic.clip.system.SystemLog;

public class InfoDialog {
	
	public InfoDialog(String message, String title, Component component){
		
		new SystemLog("Info Dialog", 1.0D).logError("Showing info message: "+title);
		JOptionPane.showMessageDialog(component, message, title, JOptionPane.INFORMATION_MESSAGE);
		
	}

}
