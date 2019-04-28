package com.garen.ssm.controller.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 * @author 0283000196
 *
 */
public class CustomDateConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String source) {
		
//		// 实现日期串转成日期类型(格式是：yyyy-MM-dd hh:mm:ss)
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			// 转换成功直接返回
//			return simpleDateFormat.parse(source);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 如果参数转换失败则返回null
//		return null;
		
		
		Timestamp date = Timestamp.valueOf(source);
		
		return date;
		
	}

}
