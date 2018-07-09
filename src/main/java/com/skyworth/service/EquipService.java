/**
 * 
 */
package com.skyworth.service;

import java.util.HashMap;
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
    public List<Equip> queryEquipList(Map<String, Object> map);

    public Equip findEquipById(Integer toeiId);
    
    public void addEquip(Equip equip);

    public void updateEquip(Equip equip);

    public void unableEquip(Integer toeiId);
    
    public void effectEquip(Integer toeiId);

    public void deleteEquip(Integer toeiId);

    public HashMap<String, Object> getDefaultScheme(String Core, String type, String country);
    
    public HashMap<String, Object> getSchemeList(String Core, String type, String country);
    
    public List<Map<String, String>> queryEquipByKey(String keyWord);
}
