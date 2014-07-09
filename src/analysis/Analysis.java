package analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Analysis {
	public static void main(String[] args) {
		new Analysis();
	}
	
	public Analysis(){
		HashMap<String, FlowTimeInfo> info = new HashMap<String, FlowTimeInfo>();
		
		String[] temp1 = null;
		String[] temp2 = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("experiment1.txt")));
			
			String line = null;
			while((line = reader.readLine()) != null){
				temp1 = line.split("@");
				if(temp1[0].indexOf("&") != -1){
//					System.out.println(temp1[0]);
					temp2 = temp1[0].split("&");
				}
				else{
					
				}
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
