package keolid.profiler.services.model;

public class User {

	private String firstName;
	private String lastName;
	private String mail;
	private String phone;

	public User(String firstName,String lastName,String mail,String phone) {
		 this.firstName=firstName;
		 this.lastName=lastName;
		 this.mail=mail;
		 this.phone=phone;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + ", phone=" + phone + "]";
	}

	
}
