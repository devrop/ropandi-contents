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
import org.springframework.stereotype.Service;

import ropandi.contents.entity.Menu;
import ropandi.contents.model.MenuDto;
import ropandi.contents.repository.MenuRepository;
import ropandi.contents.service.MenuService;
import ropandi.contents.utility.Utility;
import ropandi.contents.variable.Variable;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<MenuDto> findAll() {
		// TODO Auto-generated method stub
		List<MenuDto> menus = menuRepository.findAll().stream().map(m ->{
			MenuDto dto = new MenuDto();
			dto.setIdMenu(m.getIdMenu());
			dto.setMenuName(m.getMenuName());
			dto.setStatus(m.getStatus());
			dto.setLink(m.getLink());
			dto.setCategoryCode(m.getCategoryCode());
			return dto;
		}).collect(Collectors.toList());
		
		return menus;
	}

	@Override
	public Map<String, String> save(MenuDto menu) {
		Map<String,String> response = new HashMap<>();
		try {
			response.put(Variable.STATUS, Variable.STATUSOK);
			//jika ada dia Update
			Optional<Menu>  isExist = menuRepository.findById(menu.getIdMenu());
			//exist update
			if(isExist.isPresent()) {
				menuRepository.save(
						Menu.newMenu(
								menu.getIdMenu(), 
								menu.getMenuName(), 
								menu.getLink(), 
								menu.getStatus(),
								isExist.get().getCreatedDate(),
								menu.getCreatedBy(),
								LocalDateTime.now(),
								menu.getUpdatedBy(),
								menu.getCategoryCode()
								).build()
						);
				response.put(Variable.MESSAGE, Variable.SUCCESSUPDATED);
			}else {
				//save
				String uuid = UUID.randomUUID().toString();
				menuRepository.save(
						Menu.newMenu(uuid, 
								menu.getMenuName(),
								menu.getLink(),
								menu.getStatus(),
								LocalDateTime.now(),
								menu.getCreatedBy(),
								LocalDateTime.now(),
								"",
								menu.getCategoryCode()
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
	public Map<String, String> delete(String id) {
		Map<String,String> response = new HashMap<String,String>();
		try {
			menuRepository.deleteById(id);
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
	public List<MenuDto> findById(String id) {
		// TODO Auto-generated method stub
		List<MenuDto> menus = new ArrayList<>();
		menuRepository.findById(id).ifPresent(m ->{
			MenuDto dto = new MenuDto();
			dto.setIdMenu(m.getIdMenu());
			dto.setMenuName(m.getMenuName());
			dto.setStatus(m.getStatus());
			dto.setLink(m.getLink());
			dto.setCategoryCode(m.getCategoryCode());
			menus.add(dto);
		});
		
		return menus;
	}

}
