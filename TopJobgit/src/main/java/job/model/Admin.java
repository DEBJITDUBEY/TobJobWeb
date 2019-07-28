package job.model;

public class Admin {
	private String id;
	private String Password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Admin(String id, String password) {
		super();
		this.id = id;
		Password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
