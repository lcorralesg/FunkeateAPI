package com.example.funkeateapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity 
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "varchar(255)", 
			unique = true, nullable = false)
	private String username;
	
    @Column(columnDefinition = "varchar(255)", unique = true, nullable = false)
	private String nickname;
	
	@Column(columnDefinition = "varchar(255)", unique = true, nullable = false)
	private String email;
	
	@Column(columnDefinition = "varchar(124)", unique = true, nullable = false)
	private String password;
	
    @Column(columnDefinition = "boolean default false")
	private boolean is_superuser;
	
    @Column(columnDefinition = "boolean default false")
	private boolean is_staff;
	
    @Column(columnDefinition = "boolean default true")
	private boolean is_active;
	
    @Column(columnDefinition = "boolean default false")
	private boolean email_Verified;
    
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date last_login;
	
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date_joined;
	
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public boolean isIs_superuser() {
		return is_superuser;
	}

	public void setIs_superuser(boolean is_superuser) {
		this.is_superuser = is_superuser;
	}

	public boolean isIs_staff() {
		return is_staff;
	}

	public void setIs_staff(boolean is_staff) {
		this.is_staff = is_staff;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public Date getDate_joined() {
		return date_joined;
	}

	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public boolean getEmail_Verified() {
		return email_Verified;
	}

	public void setEmail_Verified(boolean email_Verified) {
		this.email_Verified = email_Verified;
	}
	
	

}