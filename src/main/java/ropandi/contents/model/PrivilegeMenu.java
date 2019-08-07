package ropandi.contents.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrivilegeMenu {
	@JsonProperty("id_menu")
	private String idMenu;
	@JsonProperty("id_privilege")
	private String idPrivilege;
	@JsonProperty("menu_name")
	private String menuName;
	private String link;
	private String privilege;
	@JsonProperty("action_add")
	private String actionAdd;
	@JsonProperty("action_edit")
	private String actionEdit;
	@JsonProperty("action_view")
	private String actionView;
	@JsonProperty("action_delete")
	private String actionDelete;
	public PrivilegeMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PrivilegeMenu(String idMenu, String idPrivilege, String menuName, String link, String privilege,
			String actionAdd, String actionEdit, String actionView, String actionDelete) {
		super();
		this.idMenu = idMenu;
		this.idPrivilege = idPrivilege;
		this.menuName = menuName;
		this.link = link;
		this.privilege = privilege;
		this.actionAdd = actionAdd;
		this.actionEdit = actionEdit;
		this.actionView = actionView;
		this.actionDelete = actionDelete;
	}


	public String getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}
	public String getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(String idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getActionAdd() {
		return actionAdd;
	}
	public void setActionAdd(String actionAdd) {
		this.actionAdd = actionAdd;
	}
	public String getActionEdit() {
		return actionEdit;
	}
	public void setActionEdit(String actionEdit) {
		this.actionEdit = actionEdit;
	}
	public String getActionView() {
		return actionView;
	}
	public void setActionView(String actionView) {
		this.actionView = actionView;
	}
	public String getActionDelete() {
		return actionDelete;
	}
	public void setActionDelete(String actionDelete) {
		this.actionDelete = actionDelete;
	}
	
	public static PrivilegeMenu newPrivilegeMenu(String idMenu, String idPrivilege, String menuName, String link, String privilege,
			String actionAdd, String actionEdit, String actionView, String actionDelete) {
		PrivilegeMenu newPrivilegeMenu = new PrivilegeMenu();
		newPrivilegeMenu.idMenu = idMenu;
		newPrivilegeMenu.idPrivilege = idPrivilege;
		newPrivilegeMenu.menuName = menuName;
		newPrivilegeMenu.link = link;
		newPrivilegeMenu.privilege = privilege;
		newPrivilegeMenu.actionAdd = actionAdd;
		newPrivilegeMenu.actionEdit = actionEdit;
		newPrivilegeMenu.actionView = actionView;
		newPrivilegeMenu.actionDelete = actionDelete;
		return newPrivilegeMenu;
		
	}
  public PrivilegeMenu build() {
	  return new PrivilegeMenu(idMenu, idPrivilege, menuName, link, privilege, actionAdd, actionEdit, actionView, actionDelete);
	  
  }
	
}
