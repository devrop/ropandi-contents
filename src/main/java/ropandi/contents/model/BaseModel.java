package ropandi.contents.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseModel<T> {

	private int status;
	private String message;
	@JsonProperty("data_object")
	private Object dataObject;
	@JsonProperty("data_entity")
	private T datasEntity;
	
	
	public BaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseModel(int status, String message, Object dataObject, T datasEntity) {
		super();
		this.status = status;
		this.message = message;
		this.dataObject = dataObject;
		this.datasEntity = datasEntity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getDataObject() {
		return dataObject;
	}
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	public T getDatasEntity() {
		return datasEntity;
	}
	public void setDatasEntity(T datasEntity) {
		this.datasEntity = datasEntity;
	}
	
	
}
