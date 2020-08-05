package com.mohanamalini.users.model;

import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Value;

/**
 * Class defining User object both being consumed and returning.
 */
//@Value
public class User {

  @JsonProperty("id")
  private int id;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("ip_address")
  private String ipAddress;

  @JsonProperty("latitude")
  private double latitude;

  @JsonProperty("longitude")
  private double longitude;

public User(int id, String firstName, String lastName, String email, String ipAddress, double latitude,
		double longitude) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.ipAddress = ipAddress;
	this.latitude = latitude;
	this.longitude = longitude;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

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

public String getIpAddress() {
	return ipAddress;
}

public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
}

public double getLatitude() {
	return latitude;
}

public void setLatitude(double latitude) {
	this.latitude = latitude;
}

public double getLongitude() {
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}

@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", ipAddress=" + ipAddress + ", latitude=" + latitude + ", longitude=" + longitude + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	long temp;
	temp = Double.doubleToLongBits(latitude);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(longitude);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id != other.id)
		return false;
	if (ipAddress == null) {
		if (other.ipAddress != null)
			return false;
	} else if (!ipAddress.equals(other.ipAddress))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
		return false;
	if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
		return false;
	return true;
}
  
  
  
  
}