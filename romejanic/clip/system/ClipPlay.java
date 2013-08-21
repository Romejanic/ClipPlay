package romejanic.clip.system;

import java.io.File;

import romejanic.clip.gui.*;

public class ClipPlay {

	public static double version = 1.0;

	public static final String username = System.getProperty("user.name");
	public static final String os = System.getProperty("os.name") + " " + System.getProperty("os.version");
	
	public static File appDataDir = new File("");
	
	public static MainWindow window = null;

	public static void main(String[] args) {

		getLogger().logInfo("Started normally with no errors!");
		getLogger().logInfo("System username is: "+username);
		getLogger().logInfo("System operating system is: "+os);

		appDataDir = getAppDataDir();

		DownloadInProgressUI ui = new DownloadInProgressUI();
		
		@SuppressWarnings("unused")
		boolean createDirectory = (new File(appDataDir, "/ClipPlay/Example Audio/")).mkdirs();

		File exampleAudio = new File(appDataDir, "/ClipPlay/Example Audio/example1.wav");

		if(!exampleAudio.exists()) {

			new Downloader("https://dl.dropboxusercontent.com/s/2sqbx4m3bt62rd7/Ambler.wav?token_hash=AAGXH4qWS1n5-Z1Ma5zGnW_vrgqd__fqntUDF3Ip0ubkDQ&dl=1", "example1.wav", appDataDir+"/ClipPlay/Example Audio");
			exampleAudio.mkdirs();

		}
		else{

			getLogger().logInfo("The file \"example1.wav\" already exists! A download is not nessicary!");

		}
		
		ui.close();
		
		getLogger().logInfo("All good! Starting UI...");
		window = new MainWindow();

	}

	private static File getAppDataDir(){

		String userHome = System.getProperty("user.home", ".");
		File tempLoc = null;
		Utilities.OS os = Utilities.getPlatform();

		if(os == Utilities.OS.WINDOWS){
			String applicationData = System.getenv("APPDATA");
			String folder = applicationData != null ? applicationData : userHome;
			tempLoc = new File(folder);
		}
		if(os == Utilities.OS.MACOS){

			tempLoc = new File(userHome, "Library/Application Support/");

		}
		if(os == Utilities.OS.LINUX || os == Utilities.OS.SOLARIS){

			tempLoc = new File(userHome);

		}

		return tempLoc;

	}
	
	public static void close(int exitCode){
		
		switch(exitCode){
		
		case 0:
			getLogger().logInfo("Ended correctly! (Exit code "+exitCode+")");
			break;
			
		default:
			getLogger().logInfo("Ended in a bad state! (Exit code "+exitCode+")");
			break;
		
		}
		
		System.exit(exitCode);
		
	}

	public static SystemLog getLogger() {

		return new SystemLog("ClipPlay", version);

	}

}
