package ropandi.contents.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import ropandi.contents.model.PrivilegeMenu;
@Document(collection="users-login")
public class UserLogin {
	
	@Id
	private String id;
	private String username;
	private String password;
	private List<Role> roles;
	
	private List<PrivilegeMenu> menus = new ArrayList<>();
	@JsonProperty("created_date")
	private LocalDateTime createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private LocalDateTime updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;
	
	
	
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public UserLogin(String id, String username, String password, List<Role> roles, List<PrivilegeMenu> menus,
			LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.menus = menus;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<PrivilegeMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<PrivilegeMenu> menus) {
		this.menus = menus;
	}
	
	

	
	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public static UserLogin newUserLogin(
			String id, 
			String username, 
			String password,
			List<Role> roles, 
			List<PrivilegeMenu> menus,
			LocalDateTime createdDate,
			String createdBy,
			LocalDateTime updatedDate,
			String updatedBy) {
		UserLogin login = new UserLogin();
		login.id = id;
		login.username = username;
		login.password = password;
		login.roles = roles;
		login.menus = menus;
		login.createdDate = createdDate;
		login.createdBy = createdBy;
		login.updatedDate = updatedDate;
		login.updatedBy = updatedBy;
		return login;
	}
	
	public UserLogin build() {
		return new UserLogin(id, username, password, roles, menus, createdDate, createdBy, updatedDate, updatedBy);
	}
	
	

}
