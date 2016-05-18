package exam.po;

import java.sql.Date;

public class User {
	private String name;
	private String gender;
	private String phone;
	private String email;
	private Date birthday;
	private Date lastSinginTime;
	private String password;
	
	
	public Date getLastSinginTime() {
		return lastSinginTime;
	}
	public void setLastSinginTime(Date lastSinginTime) {
		this.lastSinginTime = lastSinginTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
