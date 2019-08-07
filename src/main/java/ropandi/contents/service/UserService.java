package ropandi.contents.service;

import java.util.List;
import java.util.Map;

import ropandi.contents.model.UserLoginDto;

public interface UserService {

	List<UserLoginDto> findAll();
	Map<String,String> save(UserLoginDto privelege);
	Map<String,String> delete(String id);
	List<UserLoginDto> findById(String id);
}
