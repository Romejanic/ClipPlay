package romejanic.clip.gui;

import java.awt.Component;

import javax.swing.JOptionPane;

import romejanic.clip.system.SystemLog;

public class ErrorDialog {
	
	public ErrorDialog(String error, String title, Exception exception, Component component){
		
		new SystemLog("Error Dialog", 1.0D).logError("Caught "+exception+"! Showing error dialog...");
		exception.printStackTrace();
		JOptionPane.showMessageDialog(component, error, title + " | " + exception, JOptionPane.ERROR_MESSAGE);
		
	}

}
