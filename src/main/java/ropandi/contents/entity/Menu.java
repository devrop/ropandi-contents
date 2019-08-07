package ropandi.contents.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;


@Document(collection="menus")
public class Menu {
	
	@Id
	@JsonProperty("id_menu")
	private String idMenu;
	@JsonProperty("menu_name")
	private String menuName;
	private String link;
	private String status;
	@JsonProperty("created_date")
	private LocalDateTime createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private LocalDateTime updatedDate;
	@JsonProperty("update_by")
	private String updatedBy;
	

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public Menu(String idMenu, String menuName, String link, String status, LocalDateTime createdDate, String createdBy,
			LocalDateTime updatedDate, String updatedBy) {
		super();
		this.idMenu = idMenu;
		this.menuName = menuName;
		this.link = link;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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





	public static Menu newMenu(String idMenu, String menuName, String link, String status, LocalDateTime createdDate, String createdBy,
			LocalDateTime updatedDate, String updatedBy) {
		Menu newMenu = new Menu();
		newMenu.idMenu = idMenu;
		newMenu.menuName = menuName;
		newMenu.link = link;
		newMenu.status = status;
		newMenu.createdDate = createdDate;
		newMenu.createdBy = createdBy;
		newMenu.updatedDate = updatedDate;
		newMenu.updatedBy = updatedBy;
		return newMenu;
	}
	
	public Menu build() {
		return new Menu(idMenu, menuName, link, status, createdDate, createdBy, updatedDate, updatedBy);
	}
}


