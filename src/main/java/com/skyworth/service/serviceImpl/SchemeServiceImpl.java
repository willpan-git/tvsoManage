/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.Scheme;
import com.skyworth.entity.SchemeDetail;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.SchemeMapper;
import com.skyworth.service.ActivitiService;
import com.skyworth.service.SchemeService;
import com.skyworth.util.LogUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: SchemeServiceImpl.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月22日 上午11:38:44
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月22日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class SchemeServiceImpl implements SchemeService {
    @Autowired
    private SchemeMapper schemeMapper;
    @Autowired
    private ActivitiService activitiService;

    @Override
    public List<HashMap<String, Object>> querySchemeList(Map<String, Object> map) {
	try {
	    return schemeMapper.querySchemeList(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public Scheme findSchemeById(Integer toseId) {
	try {
	    return schemeMapper.findSchemeById(toseId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<HashMap<String, String>> GetSchemeNameSug(String toseName) {
	try {
	    return schemeMapper.GetSchemeNameSug(toseName);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<HashMap<String, String>> GetSchemeCustSug(String custName) {
	try {
	    return schemeMapper.GetSchemeCustSug(custName);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    // 新增方案
    // 开启事务
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void addScheme(Scheme scheme) {
	try {
	    // 新增方案
	    schemeMapper.addScheme(scheme);

	    ArrayList<SchemeDetail> list = new ArrayList<SchemeDetail>();

	    // 判断明细是否为空
	    list = scheme.getSchemeDetail();
	    if (list != null && list.size() > 0) {
		Iterator<SchemeDetail> iter = list.iterator();
		while (iter.hasNext()) { // 执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
		    iter.next().setTosdToseId(scheme.getToseId());
		}
		schemeMapper.addSchemeDetail(list);
	    }

	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
	// 开启审核流(流程id+ mid+起始用户)
	String bizId = scheme.getToseId().toString();
	String addUser = scheme.getAddUser();
	activitiService.startProcesses("SchemeProcess", bizId, addUser);
    }

    // 修改方案
    // 开启事务
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void updateScheme(Scheme scheme) {

	try {
	    // 修改主表
	    schemeMapper.updateScheme(scheme);
	    // 修改明细表,先删除后新增
	    schemeMapper.deleteSchemeDetail(scheme.getToseId());
	    // 新增
	    ArrayList<SchemeDetail> list = new ArrayList<SchemeDetail>();

	    // 判断明细是否为空
	    list = scheme.getSchemeDetail();
	    if (list != null && list.size() > 0) {
		Iterator<SchemeDetail> iter = list.iterator();
		while (iter.hasNext()) { // 执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
		    iter.next().setTosdToseId(scheme.getToseId());
		}
		schemeMapper.addSchemeDetail(list);
	    }
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    // 删除方案
    // 开启事务
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void deleteScheme(Integer toseId) {
	try {
	    schemeMapper.deleteScheme(toseId);
	    schemeMapper.deleteSchemeDetail(toseId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    // 失效方案
    @Override
    public void unableScheme(Integer toseId) {
	try {
	    schemeMapper.unableScheme(toseId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    // 生效方案
    @Override
    public void effectScheme(Integer toseId) {
	try {
	    schemeMapper.effectScheme(toseId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @Override
    public List<HashMap<String, Object>> GetSchemeFillMaterial(Map<String, Object> map) {
	try {
	    return schemeMapper.GetSchemeFillMaterial(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}
