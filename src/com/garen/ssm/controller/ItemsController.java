package com.garen.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garen.ssm.po.ItemsCustom;
import com.garen.ssm.service.ItemsService;

/**
 * 商品的controller
 * @author 0283000196
 *
 */
@Controller
public class ItemsController {
	
	@Autowired
	private ItemsService ItemsService;
	
	// 商品查询列表
	// @RequestMapping注解实现了方法与url的映射关系，一个方法对应一个url
	// 一般建议将url和方法名写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {
		
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> list = ItemsService.findItemsList(null);

		// 返回ModelAndView
		ModelAndView mav = new ModelAndView();
		// 在jsp页面中通过itemslist获取数据
		mav.addObject("itemslist", list);
		// 指定试图
		mav.setViewName("items/itemsList");

		return mav;
	}
	
}
