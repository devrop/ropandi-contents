package ropandi.contents.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "priveleges")
public class Privilege {

	@Id
	@JsonProperty("id_privilege")
	private String idPrivilege;
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
	@JsonProperty("created_delete")
	private LocalDateTime createdDate;
	@JsonProperty("created_by")
	private String createdBy;

	@JsonProperty("updated_date")
	private LocalDateTime updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;

	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Privilege(String idPrivilege, String privilegeName, String flagAdd, String flagEdit, String flagView,
			String flagDelete, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate,
			String updatedBy) {
		super();
		this.idPrivilege = idPrivilege;
		this.privilegeName = privilegeName;
		this.flagAdd = flagAdd;
		this.flagEdit = flagEdit;
		this.flagView = flagView;
		this.flagDelete = flagDelete;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}


	public String getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(String idPrivilege) {
		this.idPrivilege = idPrivilege;
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

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public static Privilege newPrivilege(String idPrivilege, 
			String privilegeName, 
			String flagAdd, 
			String flagEdit,
			String flagView,
			String flagDelete, 
			LocalDateTime createdDate, 
			String createdBy, 
			LocalDateTime updatedDate,
			String updatedBy) {
		Privilege priv = new Privilege();
		priv.idPrivilege = idPrivilege;
		priv.privilegeName = privilegeName;
		priv.flagAdd = flagAdd;
		priv.flagEdit = flagEdit;
		priv.flagView = flagView;
		priv.flagDelete = flagDelete;
		priv.createdDate = createdDate;
		priv.createdBy = createdBy;
		priv.updatedDate = updatedDate;
		priv.updatedBy = updatedBy;
		return priv;
	}

	public Privilege build() {
		return new Privilege(idPrivilege, privilegeName, flagAdd, flagEdit, flagView, flagDelete, createdDate, createdBy, updatedDate, updatedBy);
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
