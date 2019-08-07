package ropandi.contents.service;

import java.util.List;
import java.util.Map;

import ropandi.contents.entity.Privilege;
import ropandi.contents.model.PrivilegeDto;

public interface PrivilegeService {

	List<PrivilegeDto> findAll();
	Map<String,String> save(PrivilegeDto privelege);
	Map<String,String> deletePrivilege(String id);
	List<PrivilegeDto> findById(String id);
}

