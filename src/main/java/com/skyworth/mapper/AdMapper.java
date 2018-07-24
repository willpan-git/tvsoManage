/**
 * 
 */
package com.skyworth.mapper;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.Advertisement;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: AdMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月23日 上午11:27:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月23日     Administrator           v1.0.0               修改原因
*/
public interface AdMapper {
    
    List<Advertisement> queryAdvertisementList(Map<String, Object> map);
    
    Advertisement queryAdvertisementById(Integer toatId);
    
    void addAdvertisement(Advertisement advertisement);
    
    void updateAdvertisement(Advertisement advertisement);
    
    void deleteAdvertisement(Integer toatId);
}
