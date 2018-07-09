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

    public HashMap<String, Object> getDefaultScheme(String Core, String type, String country) {
	return equipMapper.getDefaultScheme(Core, type, country);
    }

    public HashMap<String, Object> getSchemeList(String Core, String type, String country) {
	return equipMapper.getSchemeList(Core, type, country);
    }

    public List<Map<String, String>> queryEquipByKey(String keyWord) {
	return equipMapper.queryEquipByKey(keyWord);
    }
}
