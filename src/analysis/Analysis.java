package analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {
	public static int MAX = 10000;

	public int numOfXor = 0;
	public BigInteger timeBetter = new BigInteger("0");
	
	public static void main(String[] args) {
		new Analysis();
	}
	
	public Analysis(){
		ArrayList<BigInteger> normalFlowTime = new ArrayList<BigInteger>();
		ArrayList<BigInteger> xorTimeDiff = new ArrayList <BigInteger>();
		
		for(int i = 0; i < MAX; i++){
			normalFlowTime.add(new BigInteger("0"));
			xorTimeDiff.add(new BigInteger("0"));
		}
		
		String[] temp1 = null;
		String[] temp2 = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("experiment" + MAX + ".xls")));
			
			String line = null;
			while((line = reader.readLine()) != null){
				temp1 = line.split("\\s");
				if(temp1[0].indexOf("&") != -1){
					temp2 = temp1[0].split("&");
					System.out.println(temp1[2] + "!!!");
					xorTimeDiff.set(Integer.parseInt(temp2[1].split("fid")[1]), new BigInteger(temp1[2]));
				}
				else{
					System.out.println(temp1[2]);
					normalFlowTime.set(Integer.parseInt(temp1[0].split("fid")[1]), new BigInteger(temp1[2])); 
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < MAX; i++){
			if(xorTimeDiff.get(i).compareTo(new BigInteger("0")) !=0){
				numOfXor++;
			}
		}
		
		
		//caculate how many flows perform better
		int count = 0;
		for(int i = 0; i < MAX; i++){
			if(xorTimeDiff.get(i).compareTo(new BigInteger("0")) != 0){
				if(xorTimeDiff.get(i).compareTo(normalFlowTime.get(i)) == -1){
					timeBetter = timeBetter.add(normalFlowTime.get(i).subtract(xorTimeDiff.get(i)));
					count++;
				}
			}
		}
		
		System.out.println(timeBetter + "~");
		System.out.println(normalFlowTime.get(MAX-1) + "!");
//		System.out.println(normalFlowTime.get(0) + "-");
		
		System.out.println("The total number of flow is: " + MAX);
		System.out.println("The number of flows do XOR operation is: " + numOfXor);
		System.out.println("The number of flow performs better is: " + count);
		System.out.println("The percentage the total time perform better is: " + ((double)(timeBetter.intValue())) / (double)(((normalFlowTime.get(MAX-1).subtract(normalFlowTime.get(0))).intValue())));
	}
}
