package com.java.adProvider.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tab_users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(unique = true,nullable=false)
	private String user_id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String password_salt;
	private String password_last_changed_date;      //date
    private boolean was_password_reset;
    private boolean is_password_changed;
    private String created_date;
    private String created_by;
    private String modified_date;
    private String modified_by;
    private Timestamp row_version;
    private boolean is_active =true;
	private String role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> auth=new HashSet<>();
		this.userRoles.forEach(userRole->{auth.add(new Authority(userRole.getRole().getDescription()));

		});
		return auth;

	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
















}
