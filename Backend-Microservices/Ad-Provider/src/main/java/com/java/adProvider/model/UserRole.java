package com.java.adProvider.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_userrole")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@ManyToOne()
	private Role roles;

	private boolean isSystem = false;
	private String created_by;
	private String created_date;
	private String modified_by;
	private String modified_date;
	private boolean is_system_modified=false;
	private String system_modified_date;
    private Timestamp row_version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return roles;
	}

	public void setRole(Role role) {
		this.roles = role;
	}

	public boolean isSystem() {
		return isSystem;
	}

	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isIs_system_modified() {
		return is_system_modified;
	}

	public void setIs_system_modified(boolean is_system_modified) {
		this.is_system_modified = is_system_modified;
	}

	public String getSystem_modified_date() {
		return system_modified_date;
	}

	public void setSystem_modified_date(String system_modified_date) {
		this.system_modified_date = system_modified_date;
	}



	public UserRole( User user, Role roles, boolean isSystem, String created_by, String created_date,
			String modified_by, String modified_date, boolean is_system_modified, String system_modified_date) {
		super();
		this.user = user;
		this.roles = roles;
		this.isSystem = isSystem;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
		this.is_system_modified = is_system_modified;
		this.system_modified_date = system_modified_date;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}





}
