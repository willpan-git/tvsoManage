/**
 * 
 */
package com.skyworth.service;

import java.util.List;

import org.activiti.engine.task.Task;

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
    void startProcesses(String wfId,String bizId);
    List<Task> findTasksByUserId(String wfId,String userId);
    void completeTask(String taskId,String userId,String result);
}
