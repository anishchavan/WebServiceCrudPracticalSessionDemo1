package com.cjc.servicei;

import java.util.List;

import com.cjc.item.Item;

public interface ServiceI {

	Item saveItem(Item itm);

	List<Item> showItem();

	List<Item> getByName(String name);

	List<Item> deleteById(int id);

	Item updateById(int id);

}
