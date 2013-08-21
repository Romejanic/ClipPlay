package romejanic.clip.system;

import java.util.Date;

public class SystemLog {
	
	private static String appName = null;
	private static double appVersion = 0.0;
	
	public SystemLog(String name, double version){
		
		appName = name;
		appVersion = version;
		
	}
	
	public void logInfo(String message){
		
		System.out.println(new Date() + " - "+appName+" "+appVersion+" - [INFO] "+message);
		
	}
	
	public void logError(String message){
		
		System.err.println(new Date() + " - "+appName+" "+appVersion+" - [ERROR] "+message);
		
	}
	
	public void logWithCustomPre(String message, String prefix, boolean isError){
		
		if(!isError) System.out.println(new Date() + " - "+appName+" "+appVersion+" - ["+prefix+"] "+message);
		else System.err.println(new Date() + " - "+appName+" "+appVersion+" - ["+prefix+"] "+message);
		
	}

}
