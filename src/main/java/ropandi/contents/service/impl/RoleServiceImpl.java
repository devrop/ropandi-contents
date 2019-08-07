package ropandi.contents.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ropandi.contents.entity.Menu;
import ropandi.contents.entity.Role;
import ropandi.contents.model.MenuDto;
import ropandi.contents.model.PrivilegeDto;
import ropandi.contents.model.RoleDto;
import ropandi.contents.repository.RoleRepository;
import ropandi.contents.service.RoleService;
import ropandi.contents.utility.Utility;
import ropandi.contents.variable.Variable;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	
	
	@Override
	public List<RoleDto> findAll() {
		// TODO Auto-generated method stub
				List<RoleDto> roles = roleRepository.findAll().stream().map(r ->{
					RoleDto dto = new RoleDto();
					dto.setIdRole(r.getIdRole());
					dto.setRoleName(r.getRoleName());
					return dto;
				}).collect(Collectors.toList());
				
				return roles;
	}

	@Override
	public Map<String, String> save(RoleDto role) {
		Map<String,String> response = new HashMap<>();
		try {
			response.put(Variable.STATUS, Variable.STATUSOK);
			//jika ada dia Update
			boolean isExist = roleRepository.findById(role.getIdRole()).isPresent();
			//exist update
			if(isExist) {
				roleRepository.save(
						Role.newRole(
								role.getIdRole(), 
								role.getRoleName(), 
								Utility.convertStringToLocalDate(role.getCreatedDate()), 
								role.getCreatedBy(), 
								LocalDateTime.now(), 
								role.getUpdatedBy()
								).build()
						);
				response.put(Variable.MESSAGE, Variable.SUCCESSUPDATED);
			}else {
				//save
				String uuid = UUID.randomUUID().toString();
				roleRepository.save(
						Role.newRole(
								uuid, 
								role.getRoleName().toUpperCase(), 
								LocalDateTime.now(), 
								role.getCreatedBy(), 
								LocalDateTime.now(), 
								role.getUpdatedBy()
								).build()
						);
				response.put(Variable.MESSAGE, Variable.SUCCESSSAVE);
			}
				
			return response;
		} catch (Exception e) {
			response.put(Variable.STATUS, Variable.STATUSERROR);
			String message = "Error in service with message : " + e.getMessage();
			response.put(Variable.MESSAGE, message);
			return response;
		}
	}

	@Override
	public Map<String, String> deleteRole(String id) {
		Map<String,String> response = new HashMap<String,String>();
		try {
			roleRepository.deleteById(id);
			response.put(Variable.STATUS, Variable.STATUSOK);
			response.put(Variable.MESSAGE, Variable.SUCCESSDELETE);
			return response;
		}catch(Exception e) {
			response.put(Variable.STATUS, Variable.STATUSERROR);
			String message = "Error in service with message : " + e.getMessage();
			response.put(Variable.MESSAGE, message);
			return response;
		}
	}

	@Override
	public List<RoleDto> findById(String id) {
		// TODO Auto-generated method stub
		List<RoleDto> list = new ArrayList<>();
		roleRepository.findById(id).ifPresent(r->{
			RoleDto dto = new RoleDto();
			dto.setIdRole(r.getIdRole());
			dto.setRoleName(r.getRoleName());
			list.add(dto);
			
		});
		
		return list;
	}

}
