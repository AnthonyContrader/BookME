package it.contrader.dto;

public class UserDTO {
	
	private int id;

	private String username;
	
	private String password;
	
	private String usertype;

	
	public UserDTO() {
		
	}

	public UserDTO (String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public UserDTO (int id, String username, String password, String usertype) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return  id + "\t"  + username +"\t\t" +   password + "\t\t" + usertype;
	}
}
