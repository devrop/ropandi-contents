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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ropandi.contents.model.BaseModel;
import ropandi.contents.model.MenuDto;
import ropandi.contents.model.RoleDto;
import ropandi.contents.service.RoleService;
import ropandi.contents.variable.Variable;
@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	@CrossOrigin
	@GetMapping("all")
	public ResponseEntity<BaseModel<List<RoleDto>>> getAllMenus(){
		 List<RoleDto> listPre = roleService.findAll();
		 BaseModel<List<RoleDto>> response = new BaseModel<List<RoleDto>>();
		 
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
		 return new  ResponseEntity<BaseModel<List<RoleDto>>>(response,HttpStatus.OK);
		 
	}
	@CrossOrigin
	@PostMapping("save")
	public ResponseEntity<BaseModel<String>> saveRole(@RequestBody RoleDto roleDto){
		String id = roleDto.getIdRole() ==null?"save":roleDto.getIdRole();
		System.out.println("role id" + id);
		roleDto.setIdRole(id);
		Map<String,String> data = roleService.save(roleDto);
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
	public ResponseEntity<BaseModel<String>> deleteRole(@PathVariable("id") String id){
		Map<String,String> data = roleService.deleteRole(id);
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
	public ResponseEntity<BaseModel<List<RoleDto>>> getOneRole(@PathVariable("id") String id){
		List<RoleDto> listP = roleService.findById(id); 
		BaseModel<List<RoleDto>> response = new BaseModel<>();
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
		 return new  ResponseEntity<BaseModel<List<RoleDto>>>(response,HttpStatus.OK);
	}
	
}
