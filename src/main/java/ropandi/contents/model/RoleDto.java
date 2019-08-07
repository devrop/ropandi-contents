package ropandi.contents.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDto {

	@JsonProperty("id_role")
	private String idRole;
	@JsonProperty("role_name")
	private String roleName;
	@JsonProperty("created_date")
	private String createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private String updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;
	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDto(String idRole, String roleName, String createdDate, String createdBy, String updatedDate,
			String updatedBy) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
