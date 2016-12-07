import java.io.Serializable;

public class Schedule implements Serializable {

	private String scheduleDate;	
	private String scheduleDescription;	
	
	
	public Schedule(String scheduleDate, String scheduleDescription) {
		
		this.scheduleDate = scheduleDate;
		this.scheduleDescription = scheduleDescription;

	}
	
	
	public String getName() {
		return scheduleDate;
	}


	public void setName(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}


	public String getSchedulenumbernumber() {
		return scheduleDescription;
	}


	public void setschedulenumber(String scheduleDescription) {
		this.scheduleDescription = scheduleDescription;
	}


}
