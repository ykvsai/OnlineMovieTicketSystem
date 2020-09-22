package com.capgemini.omts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "Theatre")
public class Theatre {
	
	@Id
	@Column(name = "Tid")
	private int theatreId;
	
	@NotEmpty(message = "Theater name cannot be Empty")
	@NotBlank(message = "only giving White Spaces are not allowed")
	@Size(min = 1, max = 15, message = "Theatre Name should contain atleast 1 and atmost 25 characters")
	@Column(name = "Tname")
	private String theatreName;
	
	@NotEmpty(message = "Theater City cannot be Empty")
	@NotBlank(message = "only giving White Spaces are not allowed")
	@Size(min = 3, max = 25, message = "City should contain atleast 3 and atmost 25 characters")
	@Column(name = "Tcity")
	private String theatreCity;
	
	@NotEmpty(message = "Manager name cannot be Empty")
	@NotBlank(message = "only giving White Spaces are not allowed")
	@Size(min = 3, max = 25, message = "Manager Name should contain atleast 3 and atmost 25 characters")
	@Column(name = "TMname")
	private String managerName;
	
	@NotEmpty(message = "Manager Contact cannot be Empty")
	@NotBlank(message = "only giving White Spaces are not allowed")
	@Email(message = "Manager Contact must be mail id only")
	@Column(name = "TMcontact")
	private String managerContact;	
	
	public Theatre() {
		super();
	}	

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
				+ ", managerName=" + managerName + ", managerContact=" + managerContact;
	}
	
}
