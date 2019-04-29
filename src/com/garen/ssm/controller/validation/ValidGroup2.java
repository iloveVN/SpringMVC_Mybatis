/**
 * <p> Title : ValidGroup1.java </p>
 * <p> Description : TODO </p>
 * <p> Package : com.garen.ssm.controller.validation </p>
 * CreateDate : 2019年4月29日 下午5:30:35 </p>
 * Author : 0283000196 
 *
 * @Version V1.0.0 </p> 
*/

package com.garen.ssm.controller.validation;

import javax.validation.groups.Default;

/**
 * <p> ClassName : ValidGroup1 </p>
 * <p> Description : 校验分组 </p>
 * CreateDate : 2019年4月29日 下午5:30:35
 * Author : 0283000196
 */

public interface ValidGroup2 extends Default{
	
	// 此分组只校验商品生产日期不能为空
}
