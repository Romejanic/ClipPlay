package romejanic.clip.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.*;

import romejanic.clip.logic.AudioPlayerLogic;
import romejanic.clip.system.ClipPlay;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6331465084245146508L;

	public static JLabel name = new JLabel("Nothing selected!");
	JButton chooseFile = new JButton("Open");
	public JButton play = new JButton("▶");
	public JButton stop = new JButton("◼");

	public MainWindow(){

		super("ClipPlay "+ClipPlay.version); setBounds(300, 300, 300, 300); setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container con = getContentPane(); JPanel pane = new JPanel(); con.add(pane);

		pane.add(name);
		pane.add(chooseFile);
		pane.add(play);
		pane.add(stop);

		chooseFile.addActionListener(this);
		play.addActionListener(this);
		stop.addActionListener(this);
		
		stop.setVisible(false);
		
		addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				
				new ExitDialog(ClipPlay.username);
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

		setVisible(true); setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object source = arg0.getSource();

		if(source == chooseFile){

			final JFileChooser fc = new JFileChooser();
			
			int returnVal = fc.showOpenDialog(MainWindow.this);

			ClipPlay.getLogger().logInfo("Showing file chooser dialog...");
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				AudioPlayerLogic.loadAudioFile(file);
			}

		}
		if(source == play){
			
			AudioPlayerLogic.play();
			
		}
		if(source == stop){
			
			AudioPlayerLogic.pause();
			
		}

	}

}
