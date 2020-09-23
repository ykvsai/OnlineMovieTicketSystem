package com.capgemini.omts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.capgemini.omts.util.TheatreConstants;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "Theatre")
public class Theatre {

	@Id
	@Column(name = "Tid")
	private int theatreId;

	@Pattern(regexp = TheatreConstants.REGEX)
	@NotEmpty(message = TheatreConstants.NAMENOTEMPTY)
	@NotBlank(message = TheatreConstants.BLANK)
	@Size(min = 3, max = 25, message = TheatreConstants.SIZE)
	@Column(name = "Tname")
	private String theatreName;

	@Pattern(regexp = TheatreConstants.REGEX)
	@NotEmpty(message = TheatreConstants.CITYNOTEMPTY)
	@NotBlank(message = TheatreConstants.BLANK)
	@Size(min = 3, max = 25, message = TheatreConstants.SIZE)
	@Column(name = "Tcity")
	private String theatreCity;

	@Pattern(regexp = TheatreConstants.REGEX)
	@NotEmpty(message = TheatreConstants.MGNAMENOTEMTY)
	@NotBlank(message = TheatreConstants.BLANK)
	@Size(min = 3, max = 25, message = TheatreConstants.SIZE)
	@Column(name = "TMname")
	private String managerName;

	@NotEmpty(message = TheatreConstants.MGCTNOTEMPTY)
	@NotBlank(message = TheatreConstants.BLANK)
	@Email(message = TheatreConstants.MAIL)
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
