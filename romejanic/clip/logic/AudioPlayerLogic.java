package romejanic.clip.logic;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import romejanic.clip.gui.ErrorDialog;
import romejanic.clip.gui.InfoDialog;
import romejanic.clip.gui.MainWindow;
import romejanic.clip.system.ClipPlay;

public class AudioPlayerLogic {

	private static AudioClip clip = null;
	private static String fileName = null;

	public static void loadAudioFile(File fileToPlay) {

		ClipPlay.window.setTitle("ClipPlay "+ClipPlay.version+" | "+fileToPlay.getName());

		try {
			
			if(clip != null){
				
				clip.stop();
				
			}
			clip = Applet.newAudioClip(fileToPlay.toURI().toURL());
			ClipPlay.getLogger().logInfo("Loaded file: "+fileToPlay);
			fileName = fileToPlay.getName();
			MainWindow.name.setText("Now playing: "+fileName);
		} catch (MalformedURLException e) {
			ClipPlay.getLogger().logError("Failed to load the file: "+fileToPlay);
			new ErrorDialog("The file "+fileToPlay.getName()+" could not be loaded! If this problem continues, \ntry dowloading the app again", "Couldn't load file!", e, null);
		}

	}

	public static void play(){

		if(clip == null){

			new InfoDialog("Before you can play, select a file by pressing \"Open\"!", "Failed to play", null);

		}
		else {

			ClipPlay.window.play.setVisible(false);
			ClipPlay.window.stop.setVisible(true);
			clip.play();

		}

	}

	public static void pause(){

		ClipPlay.window.play.setVisible(true);
		ClipPlay.window.stop.setVisible(false);
		clip.stop();

	}

}
