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
import ropandi.contents.model.UserLoginDto;
import ropandi.contents.service.UserService;
import ropandi.contents.variable.Variable;

@RestController
@RequestMapping("user")
public class UserController {
   
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@GetMapping("all")
	public ResponseEntity<BaseModel<List<UserLoginDto>>> getAllUserLogin(){
		 List<UserLoginDto> list = userService.findAll();
		 BaseModel<List<UserLoginDto>> response = new BaseModel<List<UserLoginDto>>();
		 
		 if(list ==null || list.isEmpty()) { 
			 response.setStatus(Variable.BADRESPONSE);
			 response.setMessage(Variable.MESSAGENOTFOUND);
			 response.setDataObject("Data empty");
			 //return new ResponseEntity<ResponseJson>(notFound,HttpStatus.OK);
		 }else {
			 response.setStatus(Variable.RESPONSEOK);
			 response.setMessage(Variable.MESSAGESUCCES);
			 response.setDatasEntity(list);
			 
		 }
		 return new  ResponseEntity<BaseModel<List<UserLoginDto>>>(response,HttpStatus.OK);
		 
	}
	@CrossOrigin
	@PostMapping("save")
	public ResponseEntity<BaseModel<String>> saveUser(@RequestBody UserLoginDto userLoginDto){
		String id = userLoginDto.getId() ==null?"save":userLoginDto.getId();
		userLoginDto.setId(id);
		Map<String,String> data = userService.save(userLoginDto);
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
	public ResponseEntity<BaseModel<String>> deleteUser(@PathVariable("id") String id){
		Map<String,String> data = userService.delete(id);
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
	public ResponseEntity<BaseModel<List<UserLoginDto>>> getOneUser(@PathVariable("id") String id){
		List<UserLoginDto> listP = userService.findById(id);
		BaseModel<List<UserLoginDto>> response = new BaseModel<>();
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
		 return new  ResponseEntity<BaseModel<List<UserLoginDto>>>(response,HttpStatus.OK);
	}
	

}
