package com.example.funkeateapi.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * author = Jacko Tinoco
 *
 * */

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
	
    @Column(columnDefinition = "boolean default false", name="is_superuser")
	private boolean isSuperuser;
	
    @Column(columnDefinition = "boolean default false", name="is_staff")
	private boolean isStaff;
	
    @Column(columnDefinition = "boolean default true", name="is_active")
	private boolean isActive;
	
    @Column(columnDefinition = "boolean default false", name="email_Verified")
	private boolean emailVerified;
    
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name="last_login")
	private Date lastLogin;
	
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name="date_joined")
	private Date dateJoined;
	
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name="created_at")
	private Date createdAt;

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

	public boolean isSuperuser() {
		return isSuperuser;
	}

	public void setSuperuser(boolean superuser) {
		isSuperuser = superuser;
	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean staff) {
		isStaff = staff;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}