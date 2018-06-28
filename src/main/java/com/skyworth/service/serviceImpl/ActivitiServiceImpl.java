/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.service.ActivitiService;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ProcessServiceImpl.java
 * @Description: 流程服务
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年6月26日 下午2:46:37
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年6月26日
 *        Administrator v1.0.0 修改原因
 */
@Service
public class ActivitiServiceImpl implements ActivitiService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
/*    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngineConfigurationImpl processEngineConfiguration;*/

    /**
     * 启动流程
     * 
     * @param wfId
     *            流程图id; bizId 业务id
     */
    @Override
    public void startProcesses(String wfId, String bizId) {
	runtimeService.startProcessInstanceByKey(wfId, bizId);
    }

    /**
     * 
     * 描述: 根据用户id查询待办任务列表
     * 
     * @param wfId
     *            流程图id userId 用户id
     */
    @Override
    public List<Task> findTasksByUserId(String wfId, String userId) {
	List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey(wfId).taskCandidateOrAssigned(userId)
		.list();
	return resultTask;
    }

    /**
     * 
     * 描述:任务审批 （通过/拒接）
     * @param taskId
     *            任务id
     * @param userId
     *            用户id
     * @param result
     *            false OR true
     */
    @Override
    public void completeTask(String taskId, String userId, String result) {
	// 获取流程实例
	taskService.claim(taskId, userId);

	Map<String, Object> vars = new HashMap<String, Object>();
	vars.put("sign", result);
	taskService.complete(taskId, vars);
    }

}
