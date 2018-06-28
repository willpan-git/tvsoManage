/**
 * 
 */
package com.skyworth.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skyworth.entity.Scheme;
import com.skyworth.entity.SchemeDetail;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: SchemeMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月22日 上午11:39:13 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月22日     Administrator           v1.0.0               修改原因
*/
public interface SchemeMapper {
    List<HashMap<String, Object>> querySchemeList(Map<String, Object> map);
    
    Scheme findSchemeById(Integer toseId);
    
    List<HashMap<String, String>> GetSchemeNameSug(String toseName);
    
    List<HashMap<String, String>> GetSchemeCustSug(String custName);
    
    void addScheme(Scheme scheme);
    
    void addSchemeDetail(ArrayList<SchemeDetail> list);
    
    void updateScheme(Scheme scheme);
    
    void deleteScheme(Integer toseId);
    
    void deleteSchemeDetail(Integer toseId);
    
    void unableScheme(Integer toseId);
    
    void effectScheme(Integer toseId);
    
    List<HashMap<String, Object>> GetSchemeFillMaterial(Map<String, Object> map);
}
