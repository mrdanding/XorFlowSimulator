package tcp;

public class ShortFlow {
	private String flowID;
	private int destinationID;
	private int startID;
	private byte packets;
	private long startTime;
	private long arriveTime;
	
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public int getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
	public int getStartID() {
		return startID;
	}
	public void setStartID(int startID) {
		this.startID = startID;
	}
	public byte getPackets() {
		return packets;
	}
	public void setPackets(byte packets) {
		this.packets = packets;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(long arriveTime) {
		this.arriveTime = arriveTime;
	}
	
}
