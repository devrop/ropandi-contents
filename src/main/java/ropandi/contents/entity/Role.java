package ropandi.contents.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection ="roles")
public class Role {
	
	@Id
	@JsonProperty("id_role")
	private String idRole;
	@JsonProperty("role_name")
	private String roleName;
	@JsonProperty("created_date")
	private LocalDateTime createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private LocalDateTime updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(String idRole, String roleName, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate,
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
	
	public static Role newRole(String idRole, String roleName, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate,
			String updatedBy) {
		Role newRole = new Role();
		newRole.idRole = idRole;
		newRole.roleName = roleName;
		newRole.createdDate = createdDate;
		newRole.createdBy = createdBy;
		newRole.updatedDate = updatedDate;
		newRole.updatedBy = updatedBy;
		return newRole;
	}
	
	public Role build() {
		return new Role(idRole, roleName, createdDate, createdBy, updatedDate, updatedBy);
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

}
