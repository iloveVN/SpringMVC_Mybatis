package com.garen.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.garen.ssm.mapper.ItemsMapper;
import com.garen.ssm.mapper.ItemsMapperCustom;
import com.garen.ssm.po.Items;
import com.garen.ssm.po.ItemsCustom;
import com.garen.ssm.po.ItemsQueryVo;
import com.garen.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
	
		// 通过itemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	
	}

	@Override
	public ItemsCustom findItemsById(int id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		
		// 将items中的属性值copy到itemsCustom中
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(int id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
