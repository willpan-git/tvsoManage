/**
 * 
 */
package com.skyworth.service;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.Equip;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: EquipService.java
 * @Description: 设备操作的关系服务
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月18日 上午11:37:55
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月18日
 *        Administrator v1.0.0 修改原因
 */
public interface EquipService {
    List<Equip> queryEquipList(Map<String, Object> map);

    Equip findEquipById(Integer toeiId);

    void addEquip(Equip equip);

    void updateEquip(Equip equip);

    void unableEquip(Integer toeiId);

    void effectEquip(Integer toeiId);

    void deleteEquip(Integer toeiId);

    Map<String, Map<String, Object>> getDefaultScheme(String toeiEquipmentCore, String toeiEquipmentType, String toeiEquipmentCountry);

    Map<String, Map<String, Object>> getSchemeList(String toeiEquipmentCore, String toeiEquipmentType, String toeiEquipmentCountry);

    List<Map<String, String>> queryEquipByKey(String keyWord);

    Integer checkEquipExists(String toeiEquipmentCore, String toeiEquipmentType, String toeiEquipmentCountry);
}
