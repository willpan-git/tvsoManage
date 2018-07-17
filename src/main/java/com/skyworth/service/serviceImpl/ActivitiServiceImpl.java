/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.mapper.ActivitiMapper;
import com.skyworth.service.ActivitiService;
import com.skyworth.util.LogUtil;

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
    private ActivitiMapper activitiMapper;
    // 获取运行时服务组件
    @Autowired
    private RuntimeService runtimeService;
    // 获取流程任务组件
    @Autowired
    private TaskService taskService;
    // 获取流程存储服务组件
    @Autowired
    private RepositoryService repositoryService;
    // 获取历史流程服务组件
/*    @Autowired
    private HistoryService historyService;  */

    /**
     * 启动流程
     * 
     * @param wfId
     *            流程key;
     * @param bizId
     *            业务单据mid
     */
    @Override
    public void startProcesses(String wfId, String bizId, String addUser) {
	try {
	    // 1、部署流程文件
	    repositoryService.createDeployment().name(wfId)
		    .addClasspathResource("processes/"+ wfId +".bpmn").deploy();

	    // 设置流程启动用户以及第一个节点完成用户
	    Map<String, Object> variables = new HashMap<String, Object>();
	    variables.put("startUser", addUser);
	    // 获取当前用户的上级用户reviewUser
	    String reviewUser = activitiMapper.getFatherUser(addUser);
	    variables.put("reviewUser", reviewUser);
	    // 启动流程实例
	    ExecutionEntity pi = (ExecutionEntity) runtimeService.startProcessInstanceByKey(wfId, bizId, variables);
	    // 完成第一步，申请流程
	    String processId = pi.getId();
	    String taskId = taskService.createTaskQuery().processInstanceId(processId).singleResult().getId();
	    taskService.complete(taskId, variables);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.WorkFlowException);
	}
    }

    /**
     * 
     * 描述:任务审批 （通过/退回）
     * 
     * @param wfId
     *            流程key
     * @param mid
     *            业务id
     * @param user
     *            用户账号
     * @param result
     *            false OR true
     */
    @Override
    public void completeTask(String wfId, String mid, String user, Boolean result) {
	try {
	    // 获取用户代办事物列表
	    List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey(wfId)
		    .taskCandidateOrAssigned(user).list();
	    // 遍历用户代办事物列表，获取当前事物
	    String TaskId = "";
	    for (Task task : resultTask) {
		// 使用任务ID，获取实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例，查询
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
			.singleResult();
		// 使用流程实例对象获取BusinessKey
		String business_key = pi.getBusinessKey();
		if (business_key.equals(mid)) {
		    TaskId = task.getId();
		}
	    }
	    // 完成当前节点
	    if (TaskId != "") {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("pass", result);
		taskService.complete(TaskId, vars);
	    }
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.WorkFlowException);
	}
    }

    /**
     * 
     * 描述:更新业务单据状态 （通过/不通过）
     * 
     * @param tableName
     *            表名
     * @param statusName
     *            状态字段名
     * @param midName
     *            主表字段名
     * @param mid
     *            业务单据id
     * @param status
     *            业务单据状态
     */
    @Override
    public void updateProcessStatus(String tableName, String statusName,String midName, String mid, String status) {
	try {
	    HashMap<String, Object> map = new HashMap<String, Object>();

	    map.put("tableName", tableName);
	    map.put("statusName", statusName);
	    map.put("midName", midName);
	    map.put("mid", mid);
	    map.put("status", status);
	    // 更新单据状态
	    activitiMapper.updateProcessStatus(map);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}
