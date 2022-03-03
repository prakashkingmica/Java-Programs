package FileEx;
import java.io.*;
class DirectoryDemo{
	public static void main(String args[]){
		File f = new File("E:\\Prakash\\JavaCourse\\NewFileFolder");
		if(f.mkdir()){
			System.out.println("Successfully Created a Directory....");
		}else{
			System.out.println("Unable to create a Directory....");
		}
	}
}