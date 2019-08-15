package ropandi.contents.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuDto {

	@JsonProperty("id_menu")
	private String idMenu;
	@JsonProperty("menu_name")
	private String menuName;
	@JsonProperty("link")
	private String link;
	@JsonProperty("cetegory_code")
	private String categoryCode;
	private String status;
	@JsonProperty("created_date")
	private String createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private String updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;
	
	
	public MenuDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public MenuDto(String idMenu, String menuName, String link, String categoryCode, String status, String createdDate,
			String createdBy, String updatedDate, String updatedBy) {
		super();
		this.idMenu = idMenu;
		this.menuName = menuName;
		this.link = link;
		this.categoryCode = categoryCode;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}




	public String getCategoryCode() {
		return categoryCode;
	}




	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}




	public String getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
