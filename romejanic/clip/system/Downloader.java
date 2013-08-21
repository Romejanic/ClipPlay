package romejanic.clip.system;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import romejanic.clip.gui.ErrorDialog;

public class Downloader {
	
	final static int size = 9000000;
	static File currentFile = null;

	public Downloader(String originURL, String outputFileName, String destination){
		
		downloadFile(originURL, outputFileName, destination);
		
	}
	
	public static void downloadFile(String fAddress, String localFileName, String destinationDir) {
	OutputStream outStream = null;
	URLConnection  uCon = null;

	InputStream is = null;
	try {
	URL Url;
	byte[] buf;
	int ByteRead,ByteWritten=0;
	Url= new URL(fAddress);
	outStream = new BufferedOutputStream(new
	FileOutputStream(destinationDir+"/"+localFileName));
	currentFile = new File(destinationDir+"/"+localFileName);

	uCon = Url.openConnection();
	is = uCon.getInputStream();
	buf = new byte[size];
	while ((ByteRead = is.read(buf)) != -1) {
	outStream.write(buf, 0, ByteRead);
	ByteWritten += ByteRead;
	}
	ClipPlay.getLogger().logInfo("Resource Downloaded Successfully.");
	ClipPlay.getLogger().logInfo("File name: \""+localFileName+ "\"");
	ClipPlay.getLogger().logInfo("Size in bytes: " + ByteWritten);
	currentFile = null;
	}
	catch (Exception e) {
	File failedDLDir = new File(destinationDir+"/"+localFileName);
	if(failedDLDir.exists()){
		
		failedDLDir.delete();
		
	}
	showErrDialog(e, localFileName);
	}
	finally {
	try {
	is.close();
	outStream.close();
	}
	catch (IOException e) {
	showErrDialog(e, localFileName);
	}}
	
	}
	
	private static void showErrDialog(Exception e, String fileName){
		
		new ErrorDialog("The file \""+fileName+"\" couldn't be downloaded! Never mind...", "Failed to download file", e, null);
		
	}
	
	public static File getCurrentFile(){
		
		return currentFile;
		
	}
	

}
