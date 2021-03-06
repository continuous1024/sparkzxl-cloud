package com.github.sparkzxl.activiti.application.service.act;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.activiti.infrastructure.entity.ActReModel;
import com.github.sparkzxl.activiti.interfaces.dto.act.ModelPageDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;

/**
 * description: 模型 服务类
 *
 * @author: zhouxinlei
 * @date: 2020-07-25 11:14:40
 */
public interface IActReModelService extends SuperCacheService<ActReModel> {


    /**
     * 分页查询模型列表
     *
     * @param modelPageDTO 模型分页参数
     * @return PageInfo<ActReModel>
     */
    PageInfo<ActReModel> actReModelList(ModelPageDTO modelPageDTO);
}
