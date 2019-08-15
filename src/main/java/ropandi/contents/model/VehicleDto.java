package ropandi.contents.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleDto {

	@JsonProperty("id_vehicle")
	private String idVehicle;
	@JsonProperty("police_number")
	private String policeNumber;
	private String brand;
	@JsonProperty("rental_price")
	private Double rentalPrice;
	@JsonProperty("unit_stock")
	private Integer unitStock;
	@JsonProperty("created_date")
	private String createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private String updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;
	public VehicleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VehicleDto(String idVehicle, String policeNumber, String brand, Double rentalPrice, Integer unitStock,
			String createdDate, String createdBy, String updatedDate, String updatedBy) {
		super();
		this.idVehicle = idVehicle;
		this.policeNumber = policeNumber;
		this.brand = brand;
		this.rentalPrice = rentalPrice;
		this.unitStock = unitStock;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	public String getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(String idVehicle) {
		this.idVehicle = idVehicle;
	}
	public String getPoliceNumber() {
		return policeNumber;
	}
	public void setPoliceNumber(String policeNumber) {
		this.policeNumber = policeNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public Integer getUnitStock() {
		return unitStock;
	}
	public void setUnitStock(Integer unitStock) {
		this.unitStock = unitStock;
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
