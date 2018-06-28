/**
 * 
 */
package com.skyworth.mapper;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.Material;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: MaterialMapper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月28日 下午6:05:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月28日     Administrator           v1.0.0               修改原因
*/
public interface MaterialMapper {
    public List<Material> queryMaterialList(Map<String, Object> map);
    
    public Material findMaterialById(Integer tomdId);
    
    public void addMaterial(Material material);
    
    public void updateMaterial(Material material);
    
    public void deleteMaterial(Integer tomdId);
    
    public void unableMaterial(Integer tomdId);
    
    public void effectMaterial(Integer tomdId);
}
