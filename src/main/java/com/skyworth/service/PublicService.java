/**
 * 
 */
package com.skyworth.service;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: PublicService.java
 * @Description: 公共方法服务
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月21日 下午5:47:49
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月21日
 *        Administrator v1.0.0 修改原因
 */
public interface PublicService {
    // 自动生成编码 WF+年+月+4位编码 例：SC-18050001
    String autoCoding(String WF, String table, String nbr);
    // 参数的公共查询方法
    List<Map<String, String>> queryBaseType(String codeType);
    // 根据日期字符串获取是当年的第几周
    Integer getWeekOfYear(String date_str);
}
