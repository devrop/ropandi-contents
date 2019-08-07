package ropandi.contents.service;

import java.util.List;
import java.util.Map;

import ropandi.contents.model.MenuDto;



public interface MenuService {
	
	List<MenuDto> findAll();
	Map<String,String> save(MenuDto privelege);
	Map<String,String> delete(String id);
	List<MenuDto> findById(String id);

}
