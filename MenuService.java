package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entity.Menu;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.MenuNotFoundException;

public interface MenuService {

	Menu addMenu(@Valid Menu menu);

	List<Menu> getAllMenu();

	Menu findByMenuName(String menuname) throws MenuNotFoundException;

	Menu choosedMenuByCustomer(Integer menuid, Integer cid) throws CustomerNotFoundException, MenuNotFoundException;

	

	

}
