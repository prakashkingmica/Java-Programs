import java.awt.*;
import java.applet.*;
import java.io.*;
public class FileSaveApp extends Applet{

	public void init(){
			File polycyFile = new File("D:/Documents and Settings/Administrator/.java.policy");
			System.out.println("File Exists---" + polycyFile.exists());
	}

}