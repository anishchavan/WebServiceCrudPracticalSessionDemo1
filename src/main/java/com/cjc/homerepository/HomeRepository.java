package com.cjc.homerepository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cjc.item.Item;

import jakarta.transaction.Transactional;

public interface HomeRepository extends CrudRepository<Item, Integer> {

	@Query("from Item where name=:name")
	public List<Item> getSpecificData(String name);
	
	@Transactional
	@Modifying
	@Query("delete from Item where id=:id")
	public void deleteItem(int id);

}
