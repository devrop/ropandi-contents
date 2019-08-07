package ropandi.contents.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ropandi.contents.model.BaseModel;
import ropandi.contents.model.MenuDto;
import ropandi.contents.service.MenuService;
import ropandi.contents.variable.Variable;

@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	@GetMapping("all")
	public ResponseEntity<BaseModel<List<MenuDto>>> getAllMenus(){
		 List<MenuDto> listPre = menuService.findAll();
		 BaseModel<List<MenuDto>> response = new BaseModel<List<MenuDto>>();
		 
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
		 return new  ResponseEntity<BaseModel<List<MenuDto>>>(response,HttpStatus.OK);
		 
	}
	
	@PostMapping("save")
	public ResponseEntity<BaseModel<String>> saveMenu(@RequestBody MenuDto menuDto){
		String id = menuDto.getIdMenu() ==null?"save":menuDto.getIdMenu();
		menuDto.setIdMenu(id);
		Map<String,String> data = menuService.save(menuDto);
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
	
	@GetMapping("delete")
	public ResponseEntity<BaseModel<String>> deleteMenu(@RequestParam("id") String id){
		Map<String,String> data = menuService.delete(id);
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
	
	@GetMapping("privilege/{id}")
	public ResponseEntity<BaseModel<List<MenuDto>>> getOneMenu(@PathVariable("id") String id){
		List<MenuDto> listP = menuService.findById(id);
		BaseModel<List<MenuDto>> response = new BaseModel<>();
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
		 return new  ResponseEntity<BaseModel<List<MenuDto>>>(response,HttpStatus.OK);
	}
	
}
