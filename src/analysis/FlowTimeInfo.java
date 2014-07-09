package analysis;

public class FlowTimeInfo {
	private String flowID;
	private long startTime;
	private long endTime;
	
	public FlowTimeInfo(String flowID, long startTime, long endTime) {
		this.flowID = flowID;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
}
