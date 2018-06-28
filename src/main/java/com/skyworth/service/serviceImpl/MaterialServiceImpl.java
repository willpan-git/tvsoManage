/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Material;
import com.skyworth.mapper.MaterialMapper;
import com.skyworth.service.MaterialService;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MaterialServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月28日 下午6:07:33
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月28日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public List<Material> queryMaterialList(Map<String, Object> map) {
	return materialMapper.queryMaterialList(map);
    }

    @Override
    public Material findMaterialById(Integer tomdId) {
	return materialMapper.findMaterialById(tomdId);
    }

    @Override
    public void addMaterial(Material material) {
	materialMapper.addMaterial(material);
    }

    @Override
    public void updateMaterial(Material material) {
	materialMapper.updateMaterial(material);
    }

    @Override
    public void deleteMaterial(Integer tomdId) {
	materialMapper.deleteMaterial(tomdId);
    }

    @Override
    public void unableMaterial(Integer tomdId) {
	materialMapper.unableMaterial(tomdId);
    }

    @Override
    public void effectMaterial(Integer tomdId) {
	materialMapper.effectMaterial(tomdId);
    }
}
