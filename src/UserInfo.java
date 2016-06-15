
public class UserInfo {
	
	
	private String email;
	private String username;
	private String password;
	private int staff;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStaff() {
		return staff;
	}
	public void setStaff(int staff) {
		this.staff = staff;
	}
	
	@Override
	public String toString() {
		return "UserInfo [email=" + email + ", username=" + username
				+ ", password=" + password + ", staff=" + staff + "]";
	}
	
	
	
	
	
}
