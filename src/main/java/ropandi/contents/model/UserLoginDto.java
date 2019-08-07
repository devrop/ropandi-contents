package ropandi.contents.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ropandi.contents.entity.Role;

public class UserLoginDto {
	
	
	private String id;
	private String username;
	private String password;
	private List<Role> roles;
	
	private List<PrivilegeMenu> menus = new ArrayList<>();

	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
	
	public UserLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLoginDto(String id, String username, String password, List<Role> roles, List<PrivilegeMenu> menus,
			String createdDate, String createdBy, String updatedDate, String updatedBy) {
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<PrivilegeMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<PrivilegeMenu> menus) {
		this.menus = menus;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
