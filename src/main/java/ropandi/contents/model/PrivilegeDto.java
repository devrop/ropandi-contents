package ropandi.contents.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrivilegeDto {

	@JsonProperty("id")
	private String id;
	@JsonProperty("privilege_name")
	private String privilegeName;
	@JsonProperty("flag_add")
	private String flagAdd;
	@JsonProperty("flag_edit")
	private String flagEdit;
	@JsonProperty("flag_view")
	private String flagView;
	@JsonProperty("flag_delete")
	private String flagDelete;
	
	private String createdBy;
	private String createdDate;
	private String updatedDate;
	private String updatedBy;
	
	
	
	
	
	public PrivilegeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlagAdd() {
		return flagAdd;
	}
	public void setFlagAdd(String flagAdd) {
		this.flagAdd = flagAdd;
	}
	public String getFlagEdit() {
		return flagEdit;
	}
	public void setFlagEdit(String flagEdit) {
		this.flagEdit = flagEdit;
	}
	public String getFlagView() {
		return flagView;
	}
	public void setFlagView(String flagView) {
		this.flagView = flagView;
	}
	public String getFlagDelete() {
		return flagDelete;
	}
	public void setFlagDelete(String flagDelete) {
		this.flagDelete = flagDelete;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
	public PrivilegeDto(String id, String privilegeName, String flagAdd, String flagEdit, String flagView,
			String flagDelete, String createdBy, String createdDate, String updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.privilegeName = privilegeName;
		this.flagAdd = flagAdd;
		this.flagEdit = flagEdit;
		this.flagView = flagView;
		this.flagDelete = flagDelete;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	

	
}
