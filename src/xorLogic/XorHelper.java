package xorLogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import tcp.ShortFlow;

public class XorHelper {
	//xor A and B
	public static ShortFlow xorTwoFlows(ShortFlow f1, ShortFlow f2){
		ShortFlow f = new ShortFlow();
		
		f.setStartID(f1.getStartID());
		f.setDestinationID(f1.getDestinationID());
		f.setPackets((byte) (f1.getPackets() ^ f2.getPackets()));
		
		return f;
	}
	
	/*
	 * get current time  (ms)
	 * 
	 */
	public static long getCurrentTime(){
		Date d = new Date();
		return d.getTime();
	}
	
	/*
	 * suspend a thread for 1000ms
	 */
	@SuppressWarnings("static-access")
	public static void suspend(Thread t, long time){
		try {
			t.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * save flow info
	 */
	public static void write(String fileName, String words){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName), true));
			writer.write(words);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
