package com.garen.ssm.mapper;

import java.util.List;

import com.garen.ssm.po.ItemsCustom;
import com.garen.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
