package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Menu;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.MenuNotFoundException;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuRepository menuRepository;
	@PostMapping("/addMenu")
	public ResponseEntity<Menu> addMenu(@Valid @RequestBody Menu menu) {
		Menu saveMenu=menuService.addMenu(menu);
		return new ResponseEntity<Menu>(saveMenu,HttpStatus.CREATED);
	}
	@GetMapping("/getMenu")
	public List<Menu> getAllMenu(){
		return menuService.getAllMenu();
	}
	
	@GetMapping("/getMenuByName/{menuname}")
	public Menu findByMenuName(@PathVariable ("menuname") String menuname) throws MenuNotFoundException {
		return menuService.findByMenuName(menuname);
	}
	
	@PutMapping("/menu/{menuid}/customer/{cid}")
	public Menu choosedMenuByCustomer(@PathVariable("menuid") Integer menuid,@PathVariable("cid") Integer cid) throws CustomerNotFoundException, MenuNotFoundException {
		return menuService.choosedMenuByCustomer(menuid,cid);
	}
	@Transactional
	@DeleteMapping("/deleteMenu/{cid}")
	public String deleteMenuByCustomerId(@PathVariable("cid") Integer cid) {
		menuRepository.deleteMenuByCustomerId(cid);
		return "MenuSuccessfully Deleted ";
		
	}
	
}
