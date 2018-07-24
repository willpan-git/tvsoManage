/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Equip;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.EquipMapper;
import com.skyworth.service.EquipService;
import com.skyworth.util.LogUtil;

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
	try {
	    return equipMapper.queryEquipList(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Equip findEquipById(Integer toeiId) {
	try {
	    return equipMapper.findEquipById(toeiId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void addEquip(Equip equip) {
	try {
	    equipMapper.addEquip(equip);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void updateEquip(Equip equip) {
	try {
	    equipMapper.updateEquip(equip);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void unableEquip(Integer toeiId) {
	try {
	    equipMapper.unableEquip(toeiId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void effectEquip(Integer toeiId) {
	try {
	    equipMapper.effectEquip(toeiId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void deleteEquip(Integer toeiId) {
	try {
	    equipMapper.deleteEquip(toeiId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Map<String, Map<String, Object>> getDefaultScheme(String toeiEquipmentCore, String toeiEquipmentType,
	    String toeiEquipmentCountry) {
	try {
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("toeiEquipmentCore", toeiEquipmentCore);
	    map.put("toeiEquipmentType", toeiEquipmentType);
	    map.put("toeiEquipmentCountry", toeiEquipmentCountry);

	    Map<String, Map<String, Object>> tResultMap = new LinkedHashMap<String, Map<String, Object>>();
	    HashMap<String, Object> tMap = new HashMap<String, Object>();
	    tMap = equipMapper.getDefaultScheme(map);
	    tResultMap.put("data", tMap);
	    return tResultMap;
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Map<String, Map<String, Object>> getSchemeList(String toeiEquipmentCore, String toeiEquipmentType,
	    String toeiEquipmentCountry) {
	try {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("toeiEquipmentCore", toeiEquipmentCore);
	    map.put("toeiEquipmentType", toeiEquipmentType);
	    map.put("toeiEquipmentCountry", toeiEquipmentCountry);

	    Map<String, Map<String, Object>> tResultMap = new LinkedHashMap<String, Map<String, Object>>();
	    HashMap<String, Object> tMap = new HashMap<String, Object>();
	    tMap = equipMapper.getSchemeList(map);
	    tResultMap.put("data", tMap);
	    return tResultMap;
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<Map<String, String>> queryEquipByKey(String keyWord) {
	try {
	    return equipMapper.queryEquipByKey(keyWord);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Integer checkEquipExists(String toeiEquipmentCore, String toeiEquipmentType, String toeiEquipmentCountry) {
	try {
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("toeiEquipmentCore", toeiEquipmentCore);
	    map.put("toeiEquipmentType", toeiEquipmentType);
	    map.put("toeiEquipmentCountry", toeiEquipmentCountry);
	    return equipMapper.checkEquipExists(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}
