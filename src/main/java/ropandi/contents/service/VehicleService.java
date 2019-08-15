package ropandi.contents.service;

import java.util.List;
import java.util.Map;

import ropandi.contents.model.MenuDto;
import ropandi.contents.model.VehicleDto;

public interface VehicleService {

	List<VehicleDto> findAll();
	Map<String,String> save(VehicleDto vehicle);
	Map<String,String> delete(String id);
	List<VehicleDto> findById(String id);
}
