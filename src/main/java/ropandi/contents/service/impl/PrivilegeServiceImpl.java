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

import ropandi.contents.entity.Privilege;
import ropandi.contents.model.PrivilegeDto;
import ropandi.contents.repository.PrivilegeRepository;
import ropandi.contents.service.PrivilegeService;
import ropandi.contents.utility.Utility;
import ropandi.contents.variable.Variable;
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	
	
	
	@Override
	public List<PrivilegeDto> findAll() {
		// TODO Auto-generated method stub
		List<PrivilegeDto> list = privilegeRepository.findAll().stream().map(p -> {
			PrivilegeDto pReturn = new PrivilegeDto(
					p.getIdPrivilege(), 
					p.getPrivilegeName(),
					p.getFlagAdd(), 
					p.getFlagEdit(),
					p.getFlagView(), 
					p.getFlagDelete(),
					p.getCreatedBy(),
					Utility.convertLocalDateToString(p.getCreatedDate()),
					Utility.convertLocalDateToString(p.getUpdatedDate()),
					p.getUpdatedBy());
			return pReturn;
		}).collect(Collectors.toList());

		return list;
	}

	@Override
	public Map<String, String> save(PrivilegeDto privelege) {
		Map<String,String> response = new HashMap<>();
		try {
			response.put(Variable.STATUS, Variable.STATUSOK);
			//jika ada dia Update
			boolean isExist = privilegeRepository.findById(privelege.getId()).isPresent();
			System.out.println("is Exist" + isExist);
			if(isExist) {
				
				privilegeRepository.save(
						Privilege.newPrivilege(
								privelege.getId(), 
								privelege.getPrivilegeName(),
								privelege.getFlagAdd(),
						        privelege.getFlagEdit(), 
						        privelege.getFlagView(), 
						        privelege.getFlagDelete(),
						        Utility.convertStringToLocalDate(privelege.getCreatedDate()),
						        privelege.getCreatedBy(),
						        LocalDateTime.now(),
						        privelege.getUpdatedBy()
						        ).build());
				
				response.put(Variable.MESSAGE, Variable.SUCCESSUPDATED);
			}else {
				//save new 
				
				String uuid = UUID.randomUUID().toString();
				privilegeRepository.save(
						Privilege.newPrivilege(
								uuid, 
								privelege.getPrivilegeName(),
								privelege.getFlagAdd(),
						        privelege.getFlagEdit(), 
						        privelege.getFlagView(), 
						        privelege.getFlagDelete(),
						        LocalDateTime.now(),
						        privelege.getCreatedBy(),
						        LocalDateTime.now(),
						        privelege.getUpdatedBy()
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
	public Map<String, String> deletePrivilege(String id) {
		Map<String,String> response = new HashMap<String,String>();
		try {
			privilegeRepository.deleteById(id);
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
	public List<PrivilegeDto> findById(String id) {
      List<PrivilegeDto> listP = new ArrayList<>();
		
		
		privilegeRepository.findById(id).ifPresent(p->{
			PrivilegeDto pp = new PrivilegeDto(
					p.getIdPrivilege(), 
					p.getPrivilegeName(),
					p.getFlagAdd(), 
					p.getFlagEdit(),
					p.getFlagView(), 
					p.getFlagDelete(),
					p.getCreatedBy(),
					Utility.convertLocalDateToString(p.getCreatedDate()),
					Utility.convertLocalDateToString(p.getUpdatedDate()),
					p.getUpdatedBy());
			listP.add(pp);
			}
				);
		return listP;
	}
}
