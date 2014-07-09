package test;

import xorLogic.XorHelper;

public class Config {
	public Config(){
		for(int i = 0; i < 500; i++){
			XorHelper.write("test", "sleep" + i + "=100");
			XorHelper.write("test", "fid" + i + "=fid" + i);
			XorHelper.write("test", "sid" + i + "=" + i);
			XorHelper.write("test", "did" + i + "=" + (int)(Math.random()*100));
			XorHelper.write("test", "");
		}
	}
	
	public static void main(String[] args) {
		new Config();
	}
}
