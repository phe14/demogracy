import java.io.Serializable;

public class Phonebook implements Serializable {
	private String name;
	private String phonenumber;	
	
	public Phonebook(String name, String phonenumber) {
		this.name = name;
		this.phonenumber = phonenumber;
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
	
	public String toString() {
		String description;
		description = name+"\t"+phonenumber;
		
		return description;
	}
}
