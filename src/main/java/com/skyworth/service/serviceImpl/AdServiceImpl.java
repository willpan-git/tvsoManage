/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.Advertisement;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.AdMapper;
import com.skyworth.service.AdService;
import com.skyworth.util.LogUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: AdServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月23日 上午11:29:46
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月23日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    @Override
    public List<Advertisement> queryAdvertisementList(Map<String, Object> map) {
	try {
	    return adMapper.queryAdvertisementList(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Advertisement queryAdvertisementById(Integer toatId) {
	try {
	    return adMapper.queryAdvertisementById(toatId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void addAdvertisement(Advertisement advertisement) {
	try {
	    adMapper.addAdvertisement(advertisement);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void updateAdvertisement(Advertisement advertisement) {
	try {
	    adMapper.updateAdvertisement(advertisement);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void deleteAdvertisement(Integer toatId) {
	try {
	    adMapper.deleteAdvertisement(toatId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

}
