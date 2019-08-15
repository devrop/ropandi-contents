package ropandi.contents.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "vehicles")
public class Vehicle {

	@Id
	@JsonProperty("id_vehicle")
	private String idVehicle;
	@JsonProperty("ploice_number")
	private String policeNumber;
	private String brand;
	@JsonProperty("rental_price")
	private Double rentalPrice;
	@JsonProperty("unit_stock")
	private Integer unitStock;
	@JsonProperty("created_date")
	private LocalDateTime createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private LocalDateTime updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String idVehicle, String policeNumber, String brand, Double rentalPrice, Integer unitStock,
			LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate, String updatedBy) {
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

	public static Vehicle newVechile(String idVehicle, String policeNumber, String brand, Double rentalPrice,
			Integer unitStock, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDate,
			String updatedBy) {
		Vehicle v = new Vehicle();
		v.idVehicle = idVehicle;
		v.policeNumber = policeNumber;
		v.brand = brand;
		v.rentalPrice = rentalPrice;
		v.unitStock = unitStock;
		v.createdDate = createdDate;
		v.createdBy = createdBy;
		v.updatedDate = updatedDate;
		v.updatedBy = updatedBy;
		return v;

	}

	public Vehicle build() {
		return new Vehicle(idVehicle, policeNumber, brand, rentalPrice, unitStock, createdDate, createdBy, updatedDate,
				updatedBy);
	}
}
