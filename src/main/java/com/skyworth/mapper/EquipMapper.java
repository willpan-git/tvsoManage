/**
 * 
 */
package com.skyworth.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skyworth.entity.Equip;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: EquipMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月18日 上午11:41:32
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月18日
 *        Administrator v1.0.0 修改原因
 */
public interface EquipMapper {
    List<Equip> queryEquipList(Map<String, Object> map);

    Equip findEquipById(Integer toeiId);

    void addEquip(Equip equip);

    void updateEquip(Equip equip);

    void unableEquip(Integer toeiId);
    
    void effectEquip(Integer toeiId);

    void deleteEquip(Integer toeiId);

    HashMap<String, Object> getDefaultScheme(String Core, String type, String country);
    
    HashMap<String, Object> getSchemeList(String Core, String type, String country);
    
    List<Map<String, String>> queryEquipByKey(String keyWord);
}
