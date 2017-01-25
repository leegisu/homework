package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;

	@Column(length = 15, nullable = false) // userId
	private String userId; // 카멜표기법으로 하면 디비에 _가 자동 추가됨

	@Column(length = 15, nullable = false) // password
	private String password;

	@Column(length = 15, nullable = false) // name
	private String name;

	@Column(length = 30, nullable = false) // email
	private String email;

	public User() {

	}

	public User(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}

	public boolean matchPassword(String password) {

		return this.password.equals(password);
	}

	public void update(User user) {

		if (matchPassword(user.password)) {
			this.name = user.name;
			this.email = user.email;

		}
	}

	public boolean matchId(Long id) {

		return this.id == id;
	}

}
