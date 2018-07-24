/**
 * 
 */
package com.skyworth.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.TV;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.TVMapper;
import com.skyworth.service.TVService;
import com.skyworth.util.LogUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: TVServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月23日 下午7:13:21
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月23日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class TVServiceImpl implements TVService {

    @Autowired
    private TVMapper tvMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.skyworth.service.TVService#queryTVInfo(java.lang.Integer)
     */
    @Override
    public TV queryTVInfo(Integer equipId) {
	try {
	    return tvMapper.queryTVInfo(equipId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

}
