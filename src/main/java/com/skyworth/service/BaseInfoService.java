/**
 * 
 */
package com.skyworth.service;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.Parameter;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: BaseInfoService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月30日 上午10:22:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月30日     Administrator           v1.0.0               修改原因
*/
public interface BaseInfoService {
    public void addParameterCode(Parameter parameter);

    public void updateParameterCode(Parameter parameter);

    public void unableParameterCode(Integer codeId);
    
    public void effectParameterCode(Integer codeId);
    
    public void deleteParameterCode(Integer codeId);
    
    public Parameter findParameterById(Integer codeId);
    
    public List<Parameter> queryParameterList(Map<String, Object> map);
}
