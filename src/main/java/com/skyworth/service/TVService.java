/**
 * 
 */
package com.skyworth.service;

import com.skyworth.entity.TV;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: TVService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月23日 下午7:12:08 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月23日     Administrator           v1.0.0               修改原因
*/
public interface TVService {
    TV queryTVInfo(Integer equipId);
}
