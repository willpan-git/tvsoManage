/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skyworth.mapper.PublicMapper;
import com.skyworth.service.PublicService;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: PublicServiceImpl.java
 * @Description: 公共方法服务实现类
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月21日 下午5:48:56
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月21日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class PublicServiceImpl implements PublicService {
    @Autowired
    private PublicMapper publicMapper;

    @Override
    public synchronized String autoCoding(String WF, String table, String nbr) {
	// 定义单据类型，预订单
	String billType = WF;
	// 获取最大的预订单号
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("nbr", nbr);
	map.put("table", table);
	String MaxNum = publicMapper.getMaxNum(map);
	// 存放最终生成的单据编号的字符串
	String billCode = new String();

	if ("".equals(MaxNum) || MaxNum == null) {
	    SimpleDateFormat formatTemp = new SimpleDateFormat("yyMMdd");
	    String billdate = formatTemp.format(new Date()).substring(0, 4);
	    billCode = billType + "-" + billdate + "0001";
	} else {
	    // 取出单据号中的固定位
	    String str = billType + MaxNum.substring(4, 8);
	    // 取出流水号
	    String temp = MaxNum.substring(MaxNum.length() - 4, MaxNum.length());
	    // 取出当天的所有单号中最大的单号截取后自增1
	    if (Integer.parseInt(temp) >= 1 && Integer.parseInt(temp) < 999) {
		temp = String.valueOf(Integer.parseInt(temp) + 1);
	    }
	    switch (temp.length()) {
	    case 1:
		temp = "000" + temp;
		break;
	    case 2:
		temp = "00" + temp;
		break;
	    case 3:
		temp = "0" + temp;
		break;
	    default:
		break;
	    }
	    billCode = str + temp;
	}
	return billCode;
    }

    @Override
    public List<Map<String, String>> queryBaseType(String codeType) {
	return publicMapper.queryBaseType(codeType);
    }
}
