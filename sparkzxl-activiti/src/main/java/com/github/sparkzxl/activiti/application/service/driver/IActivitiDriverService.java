package com.github.sparkzxl.activiti.application.service.driver;

import com.github.sparkzxl.activiti.interfaces.dto.driver.DriveProcessDTO;
import com.github.sparkzxl.activiti.interfaces.dto.process.ProcessNextTaskDTO;
import com.github.sparkzxl.activiti.interfaces.dto.process.UserNextTask;

import java.util.List;

/**
 * description: 流程驱动 服务类
 *
 * @author: zhouxinlei
 * @date: 2020-07-17 16:26:54
 */
public interface IActivitiDriverService {

    /**
     * activiti流程驱动接口
     *
     * @param driveProcessDTO
     * @return boolean
     */
    boolean driveProcess(DriveProcessDTO driveProcessDTO);

    /**
     * 获取下一步任务详情
     *
     * @param processNextTaskDTO 查询下一步入参
     * @return List<UserNextTask>
     */
    List<UserNextTask> getNextUserTask(ProcessNextTaskDTO processNextTaskDTO);
}
