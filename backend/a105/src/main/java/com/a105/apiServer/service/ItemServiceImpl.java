package com.a105.apiServer.service;

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
		int flag = 1;
		if(list == null) {
			return 2;
		}
		for(ItemDto item : list) {
			flag = itemDao.addItem(item);
			if(flag == 0) {
				break;
			}
		}
		
		return flag;
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
