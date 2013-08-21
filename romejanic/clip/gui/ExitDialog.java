package romejanic.clip.gui;

import javax.swing.JOptionPane;

import romejanic.clip.system.ClipPlay;

public class ExitDialog {
	
	public ExitDialog(String username){
		
		ClipPlay.getLogger().logInfo(new String(username + " wants to quit! Showing confirmation dialog..."));
		
		int shafala = JOptionPane.YES_NO_OPTION;
		int result = JOptionPane.showConfirmDialog(null, "Woah there "+username+"! Do you really want to quit?", "Confirm quit", shafala);
		
		if(result == JOptionPane.OK_OPTION){
			
			ClipPlay.close(0);
			
		}
		else{
			
			ClipPlay.getLogger().logInfo(username + " chose not to quit");
			
		}
				
	}

}
