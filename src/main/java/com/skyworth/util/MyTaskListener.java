/**
 * 
 */
package com.skyworth.util;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MyTaskListener.java
 * @Description: 审核节点监听，获取上级用户
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月3日 下午2:30:55
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月3日
 *        Administrator v1.0.0 修改原因
 */
public class MyTaskListener implements TaskListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void notify(DelegateTask task) {
    }
}
