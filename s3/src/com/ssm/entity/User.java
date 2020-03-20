package com.ssm.entity;

public class User {
	private Integer id;
	private String name;
	private String password;
	private String sex;
	private String hobby;
	private Integer age;

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

	}

	public User(Integer id, String name,String password, String sex, String hobby, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.hobby = hobby;
		this.age = age;
		this.password=password;
	}

	 

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", sex=" + sex + ", hobby=" + hobby + ", age=" + age + "]";
	}
	

}
