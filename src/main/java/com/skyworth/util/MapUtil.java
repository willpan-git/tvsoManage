/**
 * 
 */
package com.skyworth.util;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MapUtil.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月16日 下午5:22:27
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月16日
 *        Administrator v1.0.0 修改原因
 */

// 根据key获取map中的value值，如果该map为null或者为空，或者找不到传入key，或者类型不一致则返回空。

public class MapUtil {
    public static String getMapValue(Map<String, Object> mapPara, String strKey) {

	return getMapValue(mapPara, strKey);

    }

    public static String getMapValue(Map<String, Object> mapPara, String strKey, String strDefault) {

	return getMapValue(mapPara, strKey, strDefault, "String");

    }

    /**
     * 获取Map数据中的数值
     * @param mapPara
     *            存储容器
     * @param strKey
     *            存取KEY
     * @param strDefault
     *            非法返回默认值
     * @return
     */

    public static String getMapValue(Map<String, Object> mapPara, String strKey, String strDefault, String strType) {

	String strRes = "";

	if (mapPara == null || mapPara.size() == 0) {

	    return strDefault;

	}

	if (mapPara.get(strKey) == null) {

	    return strDefault;

	}

	if (strType.equals("int")) {

	    strRes = (Integer) mapPara.get(strKey) + "";

	} else {

	    strRes = (String) mapPara.get(strKey);

	}

	if (strRes == null || strRes.trim().equals("")) {

	    return strDefault;

	}

	strRes = strRes.trim();

	return strRes;

    }

}
