package ropandi.contents.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ropandi.contents.model.BaseModel;
import ropandi.contents.model.VehicleDto;
import ropandi.contents.service.VehicleService;
import ropandi.contents.variable.Variable;

@RestController
@RequestMapping("vehicle")
public class VehicleController {
	

	@Autowired
	private VehicleService vehicleService;
	
	@CrossOrigin
	@GetMapping("all")
	public ResponseEntity<BaseModel<List<VehicleDto>>> getAllVehicles(){
		 List<VehicleDto> listPre = vehicleService.findAll();
		 BaseModel<List<VehicleDto>> response = new BaseModel<List<VehicleDto>>();
		 
		 if(listPre ==null) { 
			 response.setStatus(Variable.BADRESPONSE);
			 response.setMessage(Variable.MESSAGENOTFOUND);
			 response.setDataObject("Data empty");
			 //return new ResponseEntity<ResponseJson>(notFound,HttpStatus.OK);
		 }else {
			 response.setStatus(Variable.RESPONSEOK);
			 response.setMessage(Variable.MESSAGESUCCES);
			 response.setDatasEntity(listPre);
			 
		 }
		 return new  ResponseEntity<BaseModel<List<VehicleDto>>>(response,HttpStatus.OK);
		 
	}
	@CrossOrigin
	@PostMapping("save")
	public ResponseEntity<BaseModel<String>> saveVehicle(@RequestBody VehicleDto veDto){
		String id = veDto.getIdVehicle() ==null?"save":veDto.getIdVehicle();
		System.out.println("system " + id);
		veDto.setIdVehicle(id);
		Map<String,String> data = vehicleService.save(veDto);
		BaseModel<String> response = new BaseModel<String>();
		response.setStatus(Variable.RESPONSEOK);
		String status = data.get(Variable.STATUS);
		if(status.equalsIgnoreCase(Variable.STATUSOK)) {
			response.setStatus(Variable.RESPONSEOK);
			response.setMessage(data.get(Variable.MESSAGE));
		}else {
			response.setStatus(Variable.RESPONSEERROR);
			response.setMessage(data.get(Variable.MESSAGE));
		}
		return new ResponseEntity<BaseModel<String>>(response,HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("delete/{id}")
	public ResponseEntity<BaseModel<String>> deleteVehicle(@PathVariable("id") String id){
		Map<String,String> data = vehicleService.delete(id);
		BaseModel<String> response = new BaseModel<String>();
		response.setStatus(Variable.RESPONSEOK);
		String status = data.get(Variable.STATUS);
		if(status.equalsIgnoreCase(Variable.STATUSOK)) {
			response.setStatus(Variable.RESPONSEOK);
			response.setMessage(data.get(Variable.MESSAGE));
		}else {
			response.setStatus(Variable.RESPONSEERROR);
			response.setMessage(data.get(Variable.MESSAGE));
		}
		return new ResponseEntity<BaseModel<String>>(response,HttpStatus.OK);
		
	}
	@CrossOrigin
	@GetMapping("getone/{id}")
	public ResponseEntity<BaseModel<List<VehicleDto>>> getOneMenu(@PathVariable("id") String id){
		List<VehicleDto> listP = vehicleService.findById(id);
		BaseModel<List<VehicleDto>> response = new BaseModel<>();
		response.setStatus(Variable.RESPONSEOK);
		 if(listP ==null) { 
			 response.setStatus(Variable.BADRESPONSE);
			 response.setMessage(Variable.MESSAGENOTFOUND);
			 response.setDataObject("Data empty");
		 }else {
			 response.setStatus(Variable.RESPONSEOK);
			 response.setMessage(Variable.MESSAGESUCCES);
			 response.setDatasEntity(listP);
			 
		 }
		 return new  ResponseEntity<BaseModel<List<VehicleDto>>>(response,HttpStatus.OK);
	}
	

}
