package tcp;

import java.io.File;

import hosts.XorHost;
import xorLogic.TempInfo;
import xorLogic.XorHelper;

public class Transmission extends Thread {
	private ShortFlow shortFlow;
	
	public Transmission(ShortFlow shortFlow, boolean isXor){
		this.setShortFlow(shortFlow);
		if(!isXor){
			XorHost.cache.add(new TempInfo(shortFlow.getFlowID(), shortFlow.getDestinationID(), XorHelper.getCurrentTime(), shortFlow.getPackets()));
		}
	}
	
	public void run(){
		System.out.println("flow " + shortFlow.getFlowID() + " is running! " + XorHelper.getCurrentTime() );
		
		if(Math.random() < 0.5){
//			System.out.println("sleep!!!");
			XorHelper.suspend(this, 100);
//			System.out.println("congestion!");
		}
//		System.out.println("flow " + shortFlow.getFlowID() + " second time!");
		
		//arrive at the endHost and save data
		XorHelper.suspend(this, 1000);
		XorHelper.write("experiment2.xls", shortFlow.getFlowID() + "\t" + shortFlow.getStartTime() + "\t" + XorHelper.getCurrentTime() + "\t"  + (XorHelper.getCurrentTime() - shortFlow.getStartTime()));
	}

	public ShortFlow getShortFlow() {
		return shortFlow;
	}
	public void setShortFlow(ShortFlow shortFlow) {
		this.shortFlow = shortFlow;
	}
}
