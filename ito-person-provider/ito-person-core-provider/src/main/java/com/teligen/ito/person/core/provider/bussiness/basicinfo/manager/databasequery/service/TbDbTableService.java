package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service;

import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
public interface TbDbTableService extends IService<TbDbTable> {

    TbDbTable setlectTable(String id);
}
