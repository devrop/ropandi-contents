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
import org.springframework.web.bind.annotation.RestController;

import ropandi.contents.model.AccessToken;
import ropandi.contents.model.BaseModel;
import ropandi.contents.model.LoginRequest;
import ropandi.contents.model.LoginResponse;
import ropandi.contents.service.LoginService;
import ropandi.contents.service.UserService;
import ropandi.contents.variable.Variable;

@RestController()
@RequestMapping("auth")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("login")
	public ResponseEntity<BaseModel<List<LoginResponse>>> login(@RequestBody LoginRequest login) {
		try {
			BaseModel<List<LoginResponse>> result = loginService.login(login);
			return new ResponseEntity<BaseModel<List<LoginResponse>>>(result, HttpStatus.OK);
		} catch (Exception e) {
			BaseModel<List<LoginResponse>> result = new BaseModel<List<LoginResponse>>();
			result.setStatus(Variable.BADRESPONSE);
			result.setMessage("Error in Controller with message : " + e.getMessage());
			return new ResponseEntity<BaseModel<List<LoginResponse>>>(result, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("accestoken/{token}")
	public ResponseEntity<AccessToken> getToken(@PathVariable String token){
		String acct = token ==null? "" : token;
		AccessToken ctg = loginService.getToken(acct);
		return new ResponseEntity<AccessToken>(ctg,HttpStatus.OK);
	}
	
	

}