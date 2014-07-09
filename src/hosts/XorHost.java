package hosts;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;

import tcp.ShortFlow;
import tcp.Transmission;
import xorLogic.TempInfo;
import xorLogic.XorHelper;

public class XorHost {
	//the possibility the flow will be congested
	public static final int CONGESTION_POSSIBILITY = 10;
	//set the longest waiting time 10,000ms;
	public static final int MAX_TIME = 10000;
	//an array to store packets info
	public static ArrayList<TempInfo> cache = new ArrayList<TempInfo>();
	
	/*every flow's running process is a Thread, 
	*the possibility to be congested is CONGESTION_POSSIBILITY%
	*/
	
	public void createFlows(){
		Properties properties = new Properties();
		int num = 0;
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("config.properties"));
			properties.load(in);
			num = Integer.parseInt(properties.getProperty("num"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < num; i++){
			ShortFlow s = new ShortFlow();
			s.setFlowID(properties.getProperty("fid"+i));
			s.setStartID(Integer.parseInt(properties.getProperty("sid"+i)));
			s.setDestinationID(Integer.parseInt(properties.getProperty("did"+i)));
//			s.setPackets(Byte.parseByte(properties.getProperty("packets"+i)));
			s.setStartTime(XorHelper.getCurrentTime());
			try {
				Thread.sleep(Integer.parseInt(properties.getProperty("sleep"+i)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			findAndSend(s.getDestinationID(), s.getFlowID());
			Transmission t = new Transmission(s, false);
			t.start();
		}
		
		
//		ShortFlow s1 = new ShortFlow();
//		s1.setFlowID("A");
//		s1.setDestinationID(0);
//		
//		ShortFlow s2 = new ShortFlow();
//		s2.setFlowID("B");
//		s2.setDestinationID(0);
//		
//		findAndSend(s1.getDestinationID(), s1.getFlowID());
//		Transmission t1 = new Transmission(s1, false);
//		t1.start();
//		
//		try {
//			new Thread().sleep(13000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		findAndSend(s2.getDestinationID(), s2.getFlowID());
//		Transmission t2 = new Transmission(s2, false);
//		t2.start();
	}
	
	/*
	 * judge whether there is any flow with the same destination in the cache, then do the xor and send the new flow
	 */
	public void findAndSend(int desID, String flowID){
		for(int i = 0; i <cache.size(); i++){
			TempInfo temp = cache.get(i);
			//judge whether the save time is exceeded
			if(XorHelper.getCurrentTime() - temp.getSaveTime() > MAX_TIME){
				cache.remove(temp);
				continue;
			}
			//judge whether there is a flow with the same destination, if the flow exists, then do the xor operation and send it.
			if(temp.getDestinationID() == desID){
				ShortFlow xorFlow = new ShortFlow();
				xorFlow.setFlowID(temp.getFlowID() + "&" + flowID);
				xorFlow.setDestinationID(desID);
				xorFlow.setStartTime(XorHelper.getCurrentTime());
				Transmission trans = new Transmission(xorFlow, true);
				trans.start();
			}
		}
	}

	public static void main(String[] args) {
		new XorHost().createFlows();
	}
}
