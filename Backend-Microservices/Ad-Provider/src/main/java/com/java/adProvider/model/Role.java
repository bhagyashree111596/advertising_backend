package com.java.adProvider.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tab_roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	private Long roleId;
	private String description;
	private boolean isSystem = false;
	private String created_by;
	private String created_date;
	private String modified_by;
	private String modified_date;
	private boolean is_system_modified=false;
	private String system_modified_date;
    private Timestamp row_version;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

//	public Set<UserRole> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(Set<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}
//
//	public Long getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(Long roleId) {
//		this.roleId = roleId;
//	}
//
//
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getShort_description() {
//		return short_description;
//	}
//
//	public void setShort_description(String short_description) {
//		this.short_description = short_description;
//	}
//
//	public boolean isSystem() {
//		return isSystem;
//	}
//
//	public void setSystem(boolean isSystem) {
//		this.isSystem = isSystem;
//	}
//
//	public String getCreated_by() {
//		return created_by;
//	}
//
//	public void setCreated_by(String created_by) {
//		this.created_by = created_by;
//	}
//
//	public String getCreated_date() {
//		return created_date;
//	}
//
//	public void setCreated_date(String created_date) {
//		this.created_date = created_date;
//	}
//
//	public String getModified_by() {
//		return modified_by;
//	}
//
//	public void setModified_by(String modified_by) {
//		this.modified_by = modified_by;
//	}
//
//	public String getModified_date() {
//		return modified_date;
//	}
//
//	public void setModified_date(String modified_date) {
//		this.modified_date = modified_date;
//	}
//
//	public boolean isIs_system_modified() {
//		return is_system_modified;
//	}
//
//	public void setIs_system_modified(boolean is_system_modified) {
//		this.is_system_modified = is_system_modified;
//	}
//
//	public String getSystem_modified_date() {
//		return system_modified_date;
//	}
//
//	public void setSystem_modified_date(String system_modified_date) {
//		this.system_modified_date = system_modified_date;
//	}
//
//	public Role() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Role(Long roleId, String description, String short_description, boolean isSystem, String created_by,
//			String created_date, String modified_by, String modified_date, boolean is_system_modified,
//			String system_modified_date, Set<UserRole> userRoles) {
//		super();
//		this.roleId = roleId;
//		this.description = description;
//		this.short_description = short_description;
//		this.isSystem = isSystem;
//		this.created_by = created_by;
//		this.created_date = created_date;
//		this.modified_by = modified_by;
//		this.modified_date = modified_date;
//		this.is_system_modified = is_system_modified;
//		this.system_modified_date = system_modified_date;
//		this.userRoles = userRoles;
//	}
//
//	@Override
//	public String toString() {
//		return "Role [roleId=" + roleId + ", description=" + description + ", short_description=" + short_description
//				+ ", isSystem=" + isSystem + ", created_by=" + created_by + ", created_date=" + created_date
//				+ ", modified_by=" + modified_by + ", modified_date=" + modified_date + ", is_system_modified="
//				+ is_system_modified + ", system_modified_date=" + system_modified_date + ", userRoles=" + userRoles
//				+ "]";
//	}
//

}

