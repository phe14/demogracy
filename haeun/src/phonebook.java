import java.io.Serializable;

public class phonebook implements Serializable{

	private String name;	//�й�
	private String phonenumber;	//�̸�
	 
	//private static int studentCount=0; 			// number of Students
	
	public phonebook(String name, String phonenumber) {
		
		this.name = name;
		this.phonenumber = phonenumber;

		//studentCount++;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


}
