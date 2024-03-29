package com.cjc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.homerepository.HomeRepository;
import com.cjc.item.Item;
import com.cjc.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {
	@Autowired
	HomeRepository hr;
	
	@Override
	public Item saveItem(Item itm) {
		
		return hr.save(itm);
		
	}

	@Override
	public List<Item> showItem() {
		
		return (List<Item>) hr.findAll();
	}

	@Override
	public List<Item> getByName(String name) {
		
		return hr.getSpecificData(name);
	}

//	@Override
//	public List<Item> deleteById(int id) {
//		hr.deleteById(id);
//		return (List<Item>) hr.findAll();
//	}
	
	@Override
	public List<Item> deleteById(int id) {

		 hr.deleteItem(id);
		 
		 return (List<Item>) hr.findAll();
	 
	}

	@Override
	public Item updateById(int id) {
		
		return hr.findById(id).get();
	}

}
