package ropandi.contents.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ropandi.contents.entity.Menu;
import ropandi.contents.entity.Privilege;
import ropandi.contents.entity.Role;
import ropandi.contents.entity.UserLogin;
import ropandi.contents.model.PrivilegeDto;
import ropandi.contents.model.PrivilegeMenu;
import ropandi.contents.model.UserLoginDto;
import ropandi.contents.repository.MenuRepository;
import ropandi.contents.repository.PrivilegeRepository;
import ropandi.contents.repository.RoleRepository;
import ropandi.contents.repository.UserLoginRepository;
import ropandi.contents.security.jwt.JwtProvider;
import ropandi.contents.service.UserService;
import ropandi.contents.utility.Utility;
import ropandi.contents.variable.Variable;

@Service
public class UserServiceImpl implements UserService {

	
	
	
	
	@Autowired
	private UserLoginRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private MenuRepository menuRepository;
	
	
	
	
	
	
	@Override
	public List<UserLoginDto> findAll() {
		// TODO Auto-generated method stub
		List<UserLoginDto> list = userRepository.findAll().stream().map(p -> {
			UserLoginDto pReturn = new UserLoginDto(
					p.getId(), 
					p.getUsername(),
					"", 
					p.getRoles(), 
					p.getMenus(), 
					Utility.convertLocalDateToString(p.getCreatedDate()), 
					p.getCreatedBy(), 
					Utility.convertLocalDateToString(p.getUpdatedDate()),
					p.getUpdatedBy());
					
			return pReturn;
		}).collect(Collectors.toList());

		return list;
	}

	@Override
	public Map<String, String> save(UserLoginDto login) {
		// TODO Auto-generated method stub
		Map<String,String> result = new HashMap<String, String>();
		try{
			
			List<String> listRoleId = login.getRoles().stream().map(r-> r.getIdRole()).collect(Collectors.toList());
            List<Role> listRole = new ArrayList<>();
            roleRepository.findAllById(listRoleId).forEach(listRole::add);
        	List<String> listMenu = new ArrayList<String>();
        	List<String> listPrivilege = new ArrayList<String>();
            login.getMenus().stream().forEach(s->{
            	listMenu.add(s.getIdMenu());
            	listPrivilege.add(s.getIdPrivilege());
            });
            //getmenu
            List<Menu> metaMenus = new ArrayList<>();
            menuRepository.findAllById(listMenu).forEach(metaMenus::add);
            List<Privilege> metaPrivilege = new ArrayList<Privilege>();
            //
            privilegeRepository.findAllById(listPrivilege).forEach(metaPrivilege::add);
            
            List<PrivilegeMenu> listPm = 
            login.getMenus().stream().map(s->{
                 Menu menu = metaMenus.stream().filter(su -> s.getIdMenu().equalsIgnoreCase(su.getIdMenu())).findFirst().get();
                 Privilege pri = metaPrivilege.stream().filter(pu-> s.getIdPrivilege().equalsIgnoreCase(pu.getIdPrivilege())).findFirst().get();

            	return PrivilegeMenu.
            			newPrivilegeMenu(
            					menu.getIdMenu(), 
            			        pri.getIdPrivilege(), 
            			        menu.getMenuName(), 
            			        menu.getLink(), 
            			        pri.getPrivilegeName(), 
            			        pri.getFlagAdd(), 
            			        pri.getFlagEdit(),
            			        pri.getFlagView(),
            			        pri.getFlagDelete(),
            			        menu.getCategoryCode()).build();
            }).collect(Collectors.toList());	
			Optional<UserLogin> userExist = userRepository.findById(login.getId());
			//System.out.println("password : " + login.getPassword());
			if(userExist.isPresent()) {
				userRepository.save(UserLogin.
	            		newUserLogin(login.getId(), 
	            		login.getUsername(), 
	            		login.getPassword(), 
	            		listRole, 
	            		listPm,
	            		userExist.get().getCreatedDate(),
	            		userExist.get().getCreatedBy(),
	            		LocalDateTime.now(),
	            		userExist.get().getUpdatedBy()).build());
				
				result.put(Variable.MESSAGE, Variable.SUCCESSUPDATED);
			}else {
	            String uuid = UUID.randomUUID().toString();
	            userRepository.save(UserLogin.
	            		newUserLogin(uuid, 
	            		login.getUsername(), 
	            		login.getPassword(), 
	            		listRole, 
	            		listPm,
	            		LocalDateTime.now(),
	            		login.getCreatedBy(),
	            		LocalDateTime.now(),
	            		login.getCreatedBy()).build());
	            result.put(Variable.MESSAGE, Variable.SUCCESSSAVE);
				
			}
            
            //send result
			result.put(Variable.STATUS, Variable.STATUSOK);
			return result;
		}catch(Exception e) {
			result.put(Variable.STATUS, Variable.STATUSERROR);
            result.put(Variable.MESSAGE, "ERROR in UserServiceImpl class save proccess with message : " + e.getMessage());
			return result;
		}
		
	}

	@Override
	public Map<String, String> delete(String id) {
		// TODO Auto-generated method stub
		Map<String,String> response = new HashMap<String,String>();
		try {
			System.out.println("Id " + id);
			userRepository.deleteById(id);
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
	public List<UserLoginDto> findById(String id) {
		// TODO Auto-generated method stub
List<UserLoginDto> list = new ArrayList<>();
		
		
		userRepository.findById(id).ifPresent(p->{
			UserLoginDto pReturn = new UserLoginDto(
					p.getId(), 
					p.getUsername(),
					"", 
					p.getRoles(), 
					p.getMenus(), 
					Utility.convertLocalDateToString(p.getCreatedDate()), 
					p.getCreatedBy(), 
					Utility.convertLocalDateToString(p.getUpdatedDate()),
					p.getUpdatedBy());
			list.add(pReturn );
			}
				);
		return list;
	}

}
