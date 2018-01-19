package com.ibcash.qa.data;

//pojo - plain old java object
public class Users {
	
	String firstName;
	String lastName;
	String email;
	String createdBy;
	String modifiedBy;
	int id;
	long createdOn;
	long modifiedOn;
	
	
	public Users() {
		
	}
	
	public Users(String firstName, String lastName, String email, String createdBy, String modifiedBy ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}
	
	
	//getters and setters methods:
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public long getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	

}
