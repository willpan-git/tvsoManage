/**
 * 
 */
package com.skyworth.service;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.Material;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MaterialService.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月28日 下午6:06:50
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月28日
 *        Administrator v1.0.0 修改原因
 */
public interface MaterialService {
    List<Material> queryMaterialList(Map<String, Object> map);

    Material findMaterialById(Integer tomdId);

    void addMaterial(Material material);

    void updateMaterial(Material material);

    void deleteMaterial(Integer tomdId);

    void unableMaterial(Integer tomdId);

    void effectMaterial(Integer tomdId);
}
