
public class Member {
	private String uname, email, phone, password;
	
	public Member() {
		super();
	}
	public Member(String uname, String email, String phone, String password) {
		super();
		this.uname = uname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
