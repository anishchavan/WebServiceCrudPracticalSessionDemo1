package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.item.Item;
import com.cjc.servicei.ServiceI;
@RestController
public class HomeController {
	@Autowired
	ServiceI si;
	
	@PostMapping("/postitem")
	public Item postItem(@RequestBody Item itm) {
		Item item  = si.saveItem(itm);
		return item;
	}
	
	@GetMapping("/getitem")
	public List<Item> getItem(){
		List<Item> list = si.showItem();
		return list;
	}
	
	@GetMapping("/getitembyname/{name}")
	public List<Item> getItemByName(@PathVariable String name) {
		List<Item> list = si.getByName(name);
		return list;
	}
	
	@PutMapping("/updatebyid/{id}")
	public Item updateItem(@PathVariable int id, @RequestBody Item itm) {
		Item item = si.updateById(id);
	    
		if(item == null) {
	         return null; 
	    }
	    
	    item.setName(itm.getName());
	    item.setQuantity(itm.getQuantity());
	    item.setPrice(itm.getPrice());
	
	    Item updatedItem = si.saveItem(item);
	    
	    return updatedItem;
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public List<Item> deleteItem(@PathVariable int id) {
		List<Item> list = si.deleteById(id);
		return list;
	}
}
