package com.garen.ssm.po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

public class ItemsQueryVo {
	
	// 商品信息
	private Items items;
	
	// 为了系统的可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	
	private List<ItemsCustom> itemsList;
	
	
	private Map<String, Object> itemInfo = new HashMap<String, Object>();

	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
	
	@Validated
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	public Map<String, Object> getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(Map<String, Object> itemInfo) {
		this.itemInfo = itemInfo;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [items=" + items + ", itemsCustom=" + itemsCustom + ", itemsList=" + itemsList
				+ ", itemInfo=" + itemInfo + "]";
	}


	

}
