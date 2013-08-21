package romejanic.clip.system;

public class Utilities {

	public static enum OS
	{
		WINDOWS, MACOS, SOLARIS, LINUX, UNKNOWN;
	}

	public static OS getPlatform()
	{
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win")) return OS.WINDOWS;
		if (osName.contains("mac")) return OS.MACOS;
		if (osName.contains("linux")) return OS.LINUX;
		if (osName.contains("unix")) return OS.LINUX;
		return OS.UNKNOWN;
	}

}
