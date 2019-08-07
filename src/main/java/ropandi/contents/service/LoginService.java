package ropandi.contents.service;

import java.util.List;

import ropandi.contents.model.AccessToken;
import ropandi.contents.model.BaseModel;
import ropandi.contents.model.LoginRequest;
import ropandi.contents.model.LoginResponse;

public interface LoginService {

	 BaseModel<List<LoginResponse>> login(LoginRequest request);
	
	
	 AccessToken getToken(String token);
	 
	
	
}
