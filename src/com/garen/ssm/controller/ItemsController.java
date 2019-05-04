package com.garen.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.garen.ssm.controller.validation.ValidGroup1;
import com.garen.ssm.po.ItemsCustom;
import com.garen.ssm.po.ItemsQueryVo;
import com.garen.ssm.service.ItemsService;

/**
 * 商品的controller
 * @author 0283000196
 *
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
	
	
	@Autowired
	private ItemsService itemsService;
	
	// 商品查询列表
	// @RequestMapping注解实现了方法与url的映射关系，一个方法对应一个url
	// 一般建议将url和方法名写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		
		// 测试forward转发，request对象共享
		System.out.println(request.getParameter("id"));
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView mav = new ModelAndView();
		// 在jsp页面中通过itemslist获取数据
		mav.addObject("itemslist", list);
		// 指定试图
		mav.setViewName("items/itemsList");

		return mav;
	}
	
//	// 商品信息修改页面显示
//	@RequestMapping(value="/editItems", method={RequestMethod.POST, RequestMethod.GET})
//	public ModelAndView editItems() throws Exception {
//		
//		// 调用Service根据商品id查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		// 返回ModelAndView
//		ModelAndView mvn = new ModelAndView();
//		
//		// 将商品信息方到model中
//		mvn.addObject("itemsCustom", itemsCustom);
//		
//		// 商品修改页面
//		mvn.setViewName("items/editItems");
//		
//		return mvn;
//	}
	
	// 商品信息修改页面显示
	@RequestMapping(value="/editItems", method={RequestMethod.POST, RequestMethod.GET})
	// @RequestParam里面指定request传入的名称和形参进行绑定
	public String editItems(Model model, @RequestParam(value="id", required=true, defaultValue="1") Integer items_id) throws Exception {
		
		// 调用Service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
				
		// 通过形参中的model，将model数据传到页面， 相当于mvn.addObject()方法
		model.addAttribute("itemsCustom", itemsCustom);
		
		return "items/editItems";
	}
	
	// 商品信息修改提交
	// 在需要校验的pojo前面需要添加@Validated， 在需要校验的pojo后面添加BindingResult接收校验出错信息
	// 注意：@Validated和BindingResult是成对出现的，并且参数循序固定()
	// 指定@Validated(value={ValidGroup1.class})使用ValidGroup1分组的校验
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model, HttpServletRequest request,String name,Integer id, 
				@ModelAttribute("itemsCustom") @Validated({ValidGroup1.class}) ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
		
		// 获取校验的错误信息
		if(bindingResult.hasErrors()){
			// 输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for(ObjectError objectError : allErrors) {
				// 输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			
			return "items/editItems";
		}
		
		itemsService.updateItems(id, itemsCustom);
		
		// 重定向到商品列表
		return "redirect:queryItems.action";
		
		// 页面转发
//		return "forward:queryItems.action";
		
		// 返回页面
//		return "success";
	}
	
	
	/**
	 * 
	 * <p> Title : deleteItems </p>
	 * <p> Description : 批量删除商品信息,该功能主要实现的是参数数组的绑定 </p>
	 * CreateDate : 2019年4月29日 上午10:14:55
	 * Author : 0283000196
	 * @param @param items_id
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		
		// 调用service批量删除商品
		
		return null;
	}
	
	
	
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuer(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView mav = new ModelAndView();
		// 在jsp页面中通过itemslist获取数据
		mav.addObject("itemslist", list);
		// 指定试图
		mav.setViewName("items/editItemsQuery");

		return mav;
	} 
	
	/**
	 * 
	 * <p> Title : editItemsAllSubmit </p>
	 * <p> Description : 批量修改商品信息，该功能主要实现的是接收list数据，通过包装类来接收 </p>
	 * CreateDate : 2019年4月29日 上午10:37:45
	 * Author : 0283000196
	 * @param @param itemsQueryVo
	 * @param @return 逻辑视图名
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
	
		return "success";
	}
	
	
}
