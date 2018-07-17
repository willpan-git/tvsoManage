/**
 * 
 */
package com.skyworth.mapper;

import java.util.Map;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: ActivitiMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月5日 上午9:17:33 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月5日     Administrator           v1.0.0               修改原因
*/
public interface ActivitiMapper {
    void updateProcessStatus(Map<String, Object> map);
    String getFatherUser(String nowUser);
}
