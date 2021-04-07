package com.a105.apiServer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a105.apiServer.dao.ItemDao;
import com.a105.apiServer.dto.ItemDto;
import com.a105.apiServer.dto.UserItemDto;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemDao itemDao;
	
	@Override
	public List<ItemDto> itemList(Map map) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getItemList(map);
	}

	@Override
	public ItemDto itemSearch(Map map) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getItem(map);
	}

	@Override
	public int itemAdd(List<ItemDto> list) throws Exception {
		// TODO Auto-generated method stub
		if(list == null) {
			return -1;
		}

		Map map = new HashMap();
		map.put("userid", list.get(0).getUserid());
		for(ItemDto item : list) {
			map.put("appid", item.getAppid());
			if(itemDao.getItem(map) != null) {
				itemDao.deleteItem(map);
			}
			itemDao.addItem(item);
		}
		
		return 1;
	}

	@Override
	public int itemDelete(Map map) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.deleteItem(map);
	}

	@Override
	public List<UserItemDto> formSearch(Map map) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getUserItem(map);
	}

}
