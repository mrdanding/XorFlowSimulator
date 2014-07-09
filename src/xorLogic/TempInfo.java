package xorLogic;

public class TempInfo {
	private String flowID;
	private int destinationID;
	private long saveTime;
	private byte packet;
	
	public TempInfo(String flowID, int destiantionID, long saveTime, byte packet){
		this.flowID = flowID;
		this.destinationID = destiantionID;
		this.saveTime = saveTime;
		this.packet = packet;
	}
	
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public long getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(long saveTime) {
		this.saveTime = saveTime;
	}
	public byte getPacket() {
		return packet;
	}
	public void setPacket(byte packet) {
		this.packet = packet;
	}
	public int getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
}
