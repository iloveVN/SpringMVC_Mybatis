package com.garen.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garen.ssm.mapper.ItemsMapper;
import com.garen.ssm.mapper.ItemsMapperCustom;
import com.garen.ssm.po.Items;
import com.garen.ssm.po.ItemsCustom;
import com.garen.ssm.po.ItemsQueryVo;
import com.garen.ssm.service.ItemsService;

@Service
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
	public ItemsCustom findItemsById(Integer id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom = new ItemsCustom();
		
		// 将items中的属性值copy到itemsCustom中
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsQueryVo itemsQueryVo) throws Exception {
		
		// 添加业务校验，通常在service接口对关键参数进行校验
		// 验证id是否为空，如果为空则抛出异常
		
		// 更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中的所有字段，包括大文本类型字段
		// updateByPrimaryKeyWithBLOBs要求必须传入id
		itemsQueryVo.getItemsCustom().setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsQueryVo);
		
	}

}
