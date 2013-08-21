package romejanic.clip.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import romejanic.clip.system.ClipPlay;
import romejanic.clip.system.Downloader;

public class DownloadInProgressUI extends JFrame {

	private static final long serialVersionUID = 5673929319003986137L;

	private static DownloadInProgressUI instance;
	
	JLabel label = new JLabel("<html><head><h1>Please wait...</h1><h4>There are downloads in progress</h4></head></html>");
	JButton skip = new JButton("Skip");
	
	public DownloadInProgressUI(){
		
		super("Download in progress"); setBounds(300, 300, 400, 150); setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container con = getContentPane(); JPanel pane = new JPanel(); con.add(pane);
		
		pane.add(label);
		pane.add(skip);
		
		skip.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				if(arg0.getSource() == skip){
					
					instance.showSkipDialog();
					
				}
				
			}
			
		});
		
		addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent event){
				
				instance.showCloseDialog();
				
			}
			
		});
		
		setVisible(true); setResizable(false);
		
		instance = this;
		
	}
	
	public void showSkipDialog(){
		
		ClipPlay.getLogger().logInfo(ClipPlay.username+" wants to cancel a download!");
		
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to skip the download?\nThe downloads will continue next time you log in", "Cancel Downloads", JOptionPane.YES_NO_OPTION);
		
		if(result == 0){
			
			ClipPlay.getLogger().logInfo("Cancelling download \""+Downloader.getCurrentFile().getName()+"\"");
			Downloader.getCurrentFile().delete();
			close();
			ClipPlay.getLogger().logInfo("All good! Starting UI...");
			ClipPlay.window = new MainWindow();
			
		}
		ClipPlay.getLogger().logInfo("Continuing the download...");
		
	}
	
	public void showCloseDialog(){
		
		ClipPlay.getLogger().logInfo(ClipPlay.username+" wants to cancel a download to quit the app!");
		
		int result = JOptionPane.showConfirmDialog(null, "There are still downloads in progess! Do you still want to quit?", "Cancel Downloads", JOptionPane.YES_NO_OPTION);
		
		if(result == 0){
			
			ClipPlay.getLogger().logInfo("Cancelling download \""+Downloader.getCurrentFile().getName()+"\"");
			Downloader.getCurrentFile().delete();
			ClipPlay.close(0);
			
		}
		ClipPlay.getLogger().logInfo("Continuing the download...");
		
	}
	
	public void close(){
		
		setVisible(false);
		
	}

}
