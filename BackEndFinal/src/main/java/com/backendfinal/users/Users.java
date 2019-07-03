package com.backendfinal.users;

//I didn't do javax.persistence.* because it was causing a bug.
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private static Long id;

	@Column(nullable = false, unique = true)
	private static String firstname;
	private static String lastname;
	private static String username;
	private static String password;

	public Long getId() {
		return id;
	}

	public static void setId(Long id) {
		Users.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public static void setFirstname(String firstname) {
		Users.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public static void setLastname(String lastname) {
		Users.lastname = lastname;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Users.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Users.password = password;
	}
}