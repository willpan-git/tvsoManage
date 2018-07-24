/**
 * 
 */
package com.skyworth.mapper;

import com.skyworth.entity.TV;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: TVMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月23日 下午6:42:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月23日     Administrator           v1.0.0               修改原因
*/
public interface TVMapper {
    TV queryTVInfo(Integer equipId);
}
