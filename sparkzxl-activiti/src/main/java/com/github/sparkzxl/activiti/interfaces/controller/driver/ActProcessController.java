package com.github.sparkzxl.activiti.interfaces.controller.driver;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.activiti.application.service.act.IProcessHistoryService;
import com.github.sparkzxl.activiti.application.service.process.IProcessTaskStatusService;
import com.github.sparkzxl.activiti.infrastructure.entity.ProcessHistory;
import com.github.sparkzxl.activiti.infrastructure.entity.ProcessInstance;
import com.github.sparkzxl.activiti.interfaces.dto.act.InstancePageDTO;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.web.annotation.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * description: 流程实例管理
 *
 * @author: zhouxinlei
 * @date: 2020-07-21 14:53:25
 */
@RestController
@ResponseResult
@WebLog
@RequestMapping("/act/process")
@Api(tags = "流程实例管理")
public class ActProcessController {

    private final IProcessHistoryService processHistoryService;
    private final IProcessTaskStatusService processTaskStatusService;

    public ActProcessController(IProcessHistoryService processHistoryService,
                                IProcessTaskStatusService processTaskStatusService) {
        this.processHistoryService = processHistoryService;
        this.processTaskStatusService = processTaskStatusService;
    }

    @ApiOperation("分页查询流程列表")
    @GetMapping("/instances")
    public PageInfo<ProcessInstance> getProcessInstanceList(InstancePageDTO instancePageDTO) {
        return processTaskStatusService.getProcessInstanceList(instancePageDTO);
    }

    @ApiOperation("获取流程历史")
    @GetMapping("/histories/{processInstanceId}")
    @ResponseResult
    public List<ProcessHistory> getProcessHistory(@ApiParam("流程实例id") @PathVariable String processInstanceId) throws ExecutionException, InterruptedException {
        return processHistoryService.getProcessHistory(processInstanceId);
    }

}
