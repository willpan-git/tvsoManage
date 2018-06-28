/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Equip;
import com.skyworth.mapper.EquipMapper;
import com.skyworth.service.EquipService;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: EquipServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月18日 上午11:40:56
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月18日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class EquipServiceImpl implements EquipService {
    @Autowired
    private EquipMapper equipMapper;

    @Override
    public List<Equip> queryEquipList(Map<String, Object> map) {
	return equipMapper.queryEquipList(map);
    }

    @Override
    public Equip findEquipById(Integer toeiId) {
	return equipMapper.findEquipById(toeiId);
    }

    @Override
    public void addEquip(Equip equip) {
	equipMapper.addEquip(equip);
    }

    @Override
    public void updateEquip(Equip equip) {
	equipMapper.updateEquip(equip);
    }

    @Override
    public void unableEquip(Integer toeiId) {
	equipMapper.unableEquip(toeiId);
    }

    @Override
    public void effectEquip(Integer toeiId) {
	equipMapper.effectEquip(toeiId);
    }

    @Override
    public void deleteEquip(Integer toeiId) {
	equipMapper.deleteEquip(toeiId);
    }

    @Override
    public HashMap<String, Object> getDefaultScheme(String toeiEquipmentCore, String toeiEquipmentType,
	    String toeiEquipmentCountry) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("toeiEquipmentCore", toeiEquipmentCore);
	map.put("toeiEquipmentType", toeiEquipmentType);
	map.put("toeiEquipmentCountry", toeiEquipmentCountry);
	return equipMapper.getDefaultScheme(map);
    }

    @Override
    public HashMap<String, Object> getSchemeList(String toeiEquipmentCore, String toeiEquipmentType,
	    String toeiEquipmentCountry) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("toeiEquipmentCore", toeiEquipmentCore);
	map.put("toeiEquipmentType", toeiEquipmentType);
	map.put("toeiEquipmentCountry", toeiEquipmentCountry);
	return equipMapper.getSchemeList(map);
    }

    @Override
    public List<Map<String, String>> queryEquipByKey(String keyWord) {
	return equipMapper.queryEquipByKey(keyWord);
    }

    @Override
    public String checkEquipExists(String toeiEquipmentCore, String toeiEquipmentType, String toeiEquipmentCountry) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("toeiEquipmentCore", toeiEquipmentCore);
	map.put("toeiEquipmentType", toeiEquipmentType);
	map.put("toeiEquipmentCountry", toeiEquipmentCountry);
	return equipMapper.checkEquipExists(map);
    }
}
