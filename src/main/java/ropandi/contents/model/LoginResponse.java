package ropandi.contents.model;

import java.util.ArrayList;
import java.util.List;

import ropandi.contents.entity.Role;



public class LoginResponse {


	private String token;
	private String username;
	private List<Role> roles;
	private List<PrivilegeMenu> menus = new ArrayList<>();
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	
	
	
}
