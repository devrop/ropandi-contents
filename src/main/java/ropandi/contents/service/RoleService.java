package ropandi.contents.service;

import java.util.List;
import java.util.Map;

import ropandi.contents.model.PrivilegeDto;
import ropandi.contents.model.RoleDto;


public interface RoleService {

	List<RoleDto> findAll();
	Map<String,String> save(RoleDto privelege);
	Map<String,String> deleteRole(String id);
	List<RoleDto> findById(String id);
}
