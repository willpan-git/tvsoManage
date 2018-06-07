/**
 * 
 */
package com.skyworth.mapper;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.Parameter;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: BaseInfoMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月30日 上午10:25:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月30日     Administrator           v1.0.0               修改原因
*/
public interface BaseInfoMapper {
    public void addParameterCode(Parameter parameter);

    public void updateParameterCode(Parameter parameter);

    public void unableParameterCode(Integer codeId);
    
    public void effectParameterCode(Integer codeId);

    public void deleteParameterCode(Integer codeId);
    
    public Parameter findParameterById(Integer codeId);
    
    public List<Parameter> queryParameterList(Map<String, Object> map);
}
