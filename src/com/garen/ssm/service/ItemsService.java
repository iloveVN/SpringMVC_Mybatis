package com.garen.ssm.service;

import java.util.List;

import com.garen.ssm.po.ItemsCustom;
import com.garen.ssm.po.ItemsQueryVo;

// 商品的管理service
public interface ItemsService {
	
	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	// 根据id查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	// 根据id修改商品信息
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
	
}
