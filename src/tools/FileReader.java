package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	private ArrayList<String> lines = null;
	
	public FileReader(String filePath,String charsetName){
		lines = new ArrayList<String>();
		read(filePath,charsetName);
	}

	private void read(String filePath, String charsetName) {
		// TODO Auto-generated method stub
		Scanner sc = null;
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			sc = new Scanner(inputStream,charsetName);
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sc != null)
				sc.close();
		}	
	}
	public String[] getLines(){
		return lines.toArray(new String[lines.size()]);
	}

}
