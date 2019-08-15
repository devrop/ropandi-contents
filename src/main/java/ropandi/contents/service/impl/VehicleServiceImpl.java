package ropandi.contents.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ropandi.contents.entity.Menu;
import ropandi.contents.entity.Vehicle;
import ropandi.contents.model.MenuDto;
import ropandi.contents.model.VehicleDto;
import ropandi.contents.repository.VehicleRepository;
import ropandi.contents.service.VehicleService;
import ropandi.contents.variable.Variable;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
	private VehicleRepository vehicleRepo;
	
	
	
	@Override
	public List<VehicleDto> findAll() {
		// TODO Auto-generated method stub
		List<VehicleDto> ves = vehicleRepo.findAll().stream().map(v ->{
			VehicleDto dto = new VehicleDto();
			dto.setIdVehicle(v.getIdVehicle());
			dto.setPoliceNumber(v.getPoliceNumber());
			dto.setBrand(v.getBrand());
			dto.setRentalPrice(v.getRentalPrice());
			dto.setUnitStock(v.getUnitStock());
			return dto;
		}).collect(Collectors.toList());
		
		return ves;
	}

	@Override
	public Map<String, String> save(VehicleDto vehicle) {
		Map<String,String> response = new HashMap<>();
		try {
			response.put(Variable.STATUS, Variable.STATUSOK);
			//jika ada dia Update
			Optional<Vehicle>  isExist = vehicleRepo.findById(vehicle.getIdVehicle());
			//exist update
			if(isExist.isPresent()) {
				vehicleRepo.save(
						 Vehicle.newVechile(
								 vehicle.getIdVehicle(), 
								 vehicle.getPoliceNumber(), 
								 vehicle.getBrand(), 
								 vehicle.getRentalPrice(), 
								 vehicle.getUnitStock(), 
								 isExist.get().getCreatedDate(), 
								 isExist.get().getCreatedBy(), 
								 LocalDateTime.now(), 
								 vehicle.getCreatedBy()).build()
						);
				response.put(Variable.MESSAGE, Variable.SUCCESSUPDATED);
			}else {
				//save
				String uuid = UUID.randomUUID().toString();
				vehicleRepo.save(
						 Vehicle.newVechile(
								 uuid, 
								 vehicle.getPoliceNumber(), 
								 vehicle.getBrand(), 
								 vehicle.getRentalPrice(), 
								 vehicle.getUnitStock(), 
								 LocalDateTime.now(), 
								 vehicle.getCreatedBy(), 
								 LocalDateTime.now(), 
								 vehicle.getCreatedBy()).build()
						);
				response.put(Variable.MESSAGE, Variable.SUCCESSSAVE);
			}
				
			return response;
		} catch (Exception e) {
			response.put(Variable.STATUS, Variable.STATUSERROR);
			String message = "Error in service with message : " + e.getMessage();
			response.put(Variable.MESSAGE, message);
			return response;
		}
	}

	@Override
	public Map<String, String> delete(String id) {
		Map<String,String> response = new HashMap<String,String>();
		try {
			vehicleRepo.deleteById(id);
			response.put(Variable.STATUS, Variable.STATUSOK);
			response.put(Variable.MESSAGE, Variable.SUCCESSDELETE);
			return response;
		}catch(Exception e) {
			response.put(Variable.STATUS, Variable.STATUSERROR);
			String message = "Error in service with message : " + e.getMessage();
			response.put(Variable.MESSAGE, message);
			return response;
		}
	}

	@Override
	public List<VehicleDto> findById(String id) {
		List<VehicleDto> ves = new ArrayList<>();
		vehicleRepo.findById(id).ifPresent(v ->{
			VehicleDto dto = new VehicleDto();
			dto.setIdVehicle(v.getIdVehicle());
			dto.setPoliceNumber(v.getPoliceNumber());
			dto.setRentalPrice(v.getRentalPrice());
			dto.setUnitStock(v.getUnitStock());	
			ves.add(dto);
		});
		
		return ves;
	}

}
