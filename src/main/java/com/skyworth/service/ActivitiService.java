/**
 * 
 */
package com.skyworth.service;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: ProcessService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月26日 下午2:45:17 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月26日     Administrator           v1.0.0               修改原因
*/
public interface ActivitiService {
    void startProcesses(String wfId,String bizId,String addUser);
    void completeTask(String wfId,String mid, String userId, Boolean result);
    void updateProcessStatus(String tableName,String statusName,String midName,String mid,String status);
}
