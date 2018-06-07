/**
 * 
 */
package com.skyworth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skyworth.entity.Scheme;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: SchemeService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月22日 上午11:38:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月22日     Administrator           v1.0.0               修改原因
*/
public interface SchemeService {
    public List<HashMap<String, Object>> querySchemeList(Map<String, Object> map);
    
    public Scheme findSchemeById(Integer toseId);
    
    public void addScheme(Scheme scheme);
    
    public void updateScheme(Scheme scheme);
    
    public void deleteScheme(Integer toseId);
    
    public void unableScheme(Integer toseId);
    
    public void effectScheme(Integer toseId);
}
