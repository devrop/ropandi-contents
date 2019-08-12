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
import ropandi.contents.model.PrivilegeDto;
import ropandi.contents.service.PrivilegeService;
import ropandi.contents.variable.Variable;

@RestController
@RequestMapping("privilege")
public class PrivilegeController {

	@Autowired
	private PrivilegeService prvilegeService;
	
	@CrossOrigin
	@GetMapping("all")
	public ResponseEntity<BaseModel<List<PrivilegeDto>>> getAllPrivilege(){
		 List<PrivilegeDto> listPre = prvilegeService.findAll();
		 BaseModel<List<PrivilegeDto>> response = new BaseModel<List<PrivilegeDto>>();
		 
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
		 return new  ResponseEntity<BaseModel<List<PrivilegeDto>>>(response,HttpStatus.OK);
		 
	}
	@CrossOrigin
	@PostMapping("save")
	public ResponseEntity<BaseModel<String>> save(@RequestBody PrivilegeDto privilege){
		String id = privilege.getId() ==null?"save":privilege.getId();
		privilege.setId(id);
		Map<String,String> data = prvilegeService.save(privilege);
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
	public ResponseEntity<BaseModel<String>> deletePrivilege(@PathVariable("id") String id){
		Map<String,String> data = prvilegeService.deletePrivilege(id);
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
	public ResponseEntity<BaseModel<List<PrivilegeDto>>> getOnePrivilege(@PathVariable("id") String id){
		List<PrivilegeDto> listP = prvilegeService.findById(id);
		BaseModel<List<PrivilegeDto>> response = new BaseModel<>();
		response.setStatus(Variable.RESPONSEOK);
		 if(listP ==null) { 
			 response.setStatus(Variable.BADRESPONSE);
			 response.setMessage(Variable.MESSAGENOTFOUND);
			 response.setDataObject("Data empty");
			 //return new ResponseEntity<ResponseJson>(notFound,HttpStatus.OK);
		 }else {
			 response.setStatus(Variable.RESPONSEOK);
			 response.setMessage(Variable.MESSAGESUCCES);
			 response.setDatasEntity(listP);
			 
		 }
		 return new  ResponseEntity<BaseModel<List<PrivilegeDto>>>(response,HttpStatus.OK);
	}
}
