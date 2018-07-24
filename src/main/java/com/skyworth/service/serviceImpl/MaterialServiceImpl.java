/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Material;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.MaterialMapper;
import com.skyworth.service.MaterialService;
import com.skyworth.util.LogUtil;

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
	try {
	    return materialMapper.queryMaterialList(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Material findMaterialById(Integer tomdId) {
	try {
	    return materialMapper.findMaterialById(tomdId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void addMaterial(Material material) {
	try {
	    materialMapper.addMaterial(material);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void updateMaterial(Material material) {
	try {
	    materialMapper.updateMaterial(material);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void deleteMaterial(Integer tomdId) {
	try {
	    materialMapper.deleteMaterial(tomdId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void unableMaterial(Integer tomdId) {
	try {
	    materialMapper.unableMaterial(tomdId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void effectMaterial(Integer tomdId) {
	try {
	    materialMapper.effectMaterial(tomdId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}
