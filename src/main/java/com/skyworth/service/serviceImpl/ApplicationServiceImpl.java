/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skyworth.entity.Application;
import com.skyworth.entity.LoadData;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.ApplicationMapper;
import com.skyworth.service.ApplicationService;
import com.skyworth.util.LogUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ApplicationServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年6月14日 下午2:55:05
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年6月14日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public List<HashMap<String, Object>> queryApplicationList(Map<String, Object> map) {
	try {
	    return applicationMapper.queryApplicationList(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Application queryApplicationById(Integer toanId) {
	try {
	    return applicationMapper.queryApplicationById(toanId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void addApplication(Application application) {
	try {
	    applicationMapper.addApplication(application);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void updateApplication(Application application) {
	try {
	    applicationMapper.updateApplication(application);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void deleteApplication(Integer toanId) {
	try {
	    applicationMapper.deleteApplication(toanId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void unableApplication(Integer toanId) {
	try {
	    applicationMapper.unableApplication(toanId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public void effectApplication(Integer toanId) {
	try {
	    applicationMapper.effectApplication(toanId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    // app每下载一次，更新下载量，
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateApplicationLoad(Integer toalYear, Integer toalMonth, Integer toalWeek, Integer toanId) {
	try {
	    HashMap<String, Object> map = new HashMap<String, Object>();

	    map.put("toalYear", toalYear);
	    map.put("toalMonth", toalMonth);
	    map.put("toalWeek", toalWeek);
	    map.put("toanId", toanId);
	    // 先检查
	    applicationMapper.checkApplicationLoadExists(map);
	    // 再更新
	    applicationMapper.updateApplicationLoad(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<HashMap<String, Object>> queryAppTypePercentList() {
	try {
	    return applicationMapper.queryAppTypePercentList();
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<LoadData> queryAppLoadDetailsByMonth(String idx) {
	try {
	    return applicationMapper.queryAppLoadDetailsByMonth(idx);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<LoadData> queryAppLoadDetailsByWeek(String idx) {
	try {
	    return applicationMapper.queryAppLoadDetailsByWeek(idx);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}
