/**
 * 
 */
package com.skyworth.util;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.skyworth.service.ActivitiService;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: MyServiceTask.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月4日 下午4:01:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月4日     Administrator           v1.0.0               修改原因
*/
@Component
public class MyServiceTask implements JavaDelegate{
    
    // 变量
    private Expression tableName;
    private Expression statusName;
    private Expression midName;
    private Expression status;
    
    @Override
    public void execute(DelegateExecution execution){
	String vTbale = (String) tableName.getValue(execution);   
	String vStatusName = (String) statusName.getValue(execution);   
	String vmidName = (String) midName.getValue(execution);   
	String vMid = execution.getProcessInstanceBusinessKey();  
	String vStatus = (String) status.getValue(execution);
	
	ActivitiService activitiService = (ActivitiService)SpringBeanUtil.getBean(ActivitiService.class);
	activitiService.updateProcessStatus(vTbale, vStatusName,vmidName, vMid,vStatus);
    }
}
