/**
 * 
 */
package com.skyworth.mapper;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: PublicMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月21日 下午5:50:09
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月21日
 *        Administrator v1.0.0 修改原因
 */
public interface PublicMapper {
    public String getMaxNum(Map<String, Object> map);

    public List<Map<String, String>> queryBaseType(String codeType);
}
