/**
 * 
 */
package com.skyworth.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skyworth.entity.Application;
import com.skyworth.entity.ApplicationLoad;
import com.skyworth.entity.LoadData;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ApplicationMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年6月14日 下午2:34:16
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年6月14日
 *        Administrator v1.0.0 修改原因
 */
public interface ApplicationMapper {
    List<HashMap<String, Object>> queryApplicationList(Map<String, Object> map);

    Application queryApplicationById(Integer toanId);

    List<ApplicationLoad> queryApplicationLoadById(Integer toanId);

    void addApplication(Application application);

    void updateApplication(Application application);

    void deleteApplication(Integer toanId);

    void unableApplication(Integer toanId);

    void effectApplication(Integer toanId);

    void checkApplicationLoadExists(Map<String, Object> map);

    void updateApplicationLoad(Map<String, Object> map);
    
    List<HashMap<String, Object>> queryAppTypePercentList();
    
    List<LoadData> queryAppLoadDetailsByMonth(String idx);
    
    List<LoadData> queryAppLoadDetailsByWeek(String idx);
}
