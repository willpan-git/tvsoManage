/**
 * 
 */
package com.skyworth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skyworth.entity.Application;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: ApplicationService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月14日 下午2:54:29 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月14日     Administrator           v1.0.0               修改原因
*/
public interface ApplicationService {
    List<HashMap<String, Object>> queryApplicationList(Map<String, Object> map);

    Application queryApplicationById(Integer toanId);

    //List<ApplicationLoad> queryApplicationLoadById(Integer toanId);

    void addApplication(Application application);

    void updateApplication(Application application);

    void deleteApplication(Integer toanId);

    void unableApplication(Integer toanId);

    void effectApplication(Integer toanId);

    void updateApplicationLoad(Integer toalYear,Integer toalMonth,Integer toalWeek,Integer toanId);
}
