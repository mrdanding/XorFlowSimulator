package test;

import java.nio.ByteBuffer;
import java.util.Date;

import tcp.ShortFlow;
import tcp.Transmission;
import xorLogic.XorHelper;

public class Test extends Thread {
//	public static void main(String[] args) {
//		ShortFlow s1 = new ShortFlow();
//		ShortFlow s2 = new ShortFlow();
//		ShortFlow s3 = new ShortFlow();
//		s1.setFlowID(1);
//		s2.setFlowID(2);
//		s3.setFlowID(3);
//		
//		Transmission t1 = new Transmission(s1);
//		
//		Transmission t2 = new Transmission(s2);
//		Transmission t3 = new Transmission(s3);
//		
//		t1.start();
//		try {
//			new Thread().sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		t2.start();
//		t3.start();
//	}
//	public static void main(String[] args) {
//		for(int i = 0; i < 10; i++){
//			XorHelper.write(i+"", i+"");
//		}
//	}
	
//	private String s = null;
//	public static void main(String[] args) {
//		Test t1 = new Test("a");
//		Test t2 = new Test("b");
//		Test t3 = new Test("c");
//		
//		t1.run(t1);
//		t2.run(t2);
//		t3.run(t3);
//	}
//	
//	public Test(String s){
//		this.s = s;
//	}
//	
//	public void run(Thread t){
//		for(int i = 0; i < 10; i++){
//			XorHelper.suspend(t);
//			System.out.println(s);
//		}
//	}
}
