package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service;

import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbGroup;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
public interface TbDbGroupService extends IService<TbDbGroup> {

    TbDbGroup selectGroup(String id);
}
