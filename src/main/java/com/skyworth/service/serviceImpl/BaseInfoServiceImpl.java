/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Parameter;
import com.skyworth.mapper.BaseInfoMapper;
import com.skyworth.service.BaseInfoService;

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
	// TODO Auto-generated method stub
	baseInfoMapper.addParameterCode(parameter);
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
	// TODO Auto-generated method stub
	baseInfoMapper.updateParameterCode(parameter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#unableParameterCode(java.lang.Integer)
     */
    @Override
    public void unableParameterCode(Integer codeId) {
	// TODO Auto-generated method stub
	baseInfoMapper.unableParameterCode(codeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#effectParameterCode(java.lang.Integer)
     */
    @Override
    public void effectParameterCode(Integer codeId) {
	// TODO Auto-generated method stub
	baseInfoMapper.effectParameterCode(codeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#deleteParameterCode(java.lang.Integer)
     */
    @Override
    public void deleteParameterCode(Integer codeId) {
	// TODO Auto-generated method stub
	baseInfoMapper.deleteParameterCode(codeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.skyworth.service.BaseInfoService#findParameterById(java.lang.Integer)
     */
    @Override
    public Parameter findParameterById(Integer codeId) {
	// TODO Auto-generated method stub
	return baseInfoMapper.findParameterById(codeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.skyworth.service.BaseInfoService#queryParameterList(java.util.Map)
     */
    @Override
    public List<Parameter> queryParameterList(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return baseInfoMapper.queryParameterList(map);
    }

}
