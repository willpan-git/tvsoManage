/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Parameter;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.BaseInfoMapper;
import com.skyworth.service.BaseInfoService;
import com.skyworth.util.LogUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: BaseInfoServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月30日 上午10:23:57
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月30日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class BaseInfoServiceImpl implements BaseInfoService {
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#addParameterCode(com.skyworth.entity.
     * Parameter)
     */
    @Override
    public void addParameterCode(Parameter parameter) {
	try {
	    baseInfoMapper.addParameterCode(parameter);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#updateParameterCode(com.skyworth.entity.
     * Parameter)
     */
    @Override
    public void updateParameterCode(Parameter parameter) {
	try {
	    baseInfoMapper.updateParameterCode(parameter);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#unableParameterCode(java.lang.Integer)
     */
    @Override
    public void unableParameterCode(Integer codeId) {
	try {
	    baseInfoMapper.unableParameterCode(codeId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#effectParameterCode(java.lang.Integer)
     */
    @Override
    public void effectParameterCode(Integer codeId) {
	try {
	    baseInfoMapper.effectParameterCode(codeId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#deleteParameterCode(java.lang.Integer)
     */
    @Override
    public void deleteParameterCode(Integer codeId) {
	try {
	    baseInfoMapper.deleteParameterCode(codeId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#findParameterById(java.lang.Integer)
     */
    @Override
    public Parameter findParameterById(Integer codeId) {
	try {
	    return baseInfoMapper.findParameterById(codeId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.skyworth.service.BaseInfoService#queryParameterList(java.util.Map)
     */
    @Override
    public List<Parameter> queryParameterList(Map<String, Object> map) {
	try {
	    return baseInfoMapper.queryParameterList(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Integer checkParameterExists(String codeType, String codeCode) {
	try {
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("codeType", codeType);
	    map.put("codeCode",codeCode);
	    return baseInfoMapper.checkParameterExists(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}
