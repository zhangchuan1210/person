package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service;

import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbDb;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
public interface TbDbDbService extends IService<TbDbDb> {

    TbDbDb selectDb(String id);

    Map<Integer, Map<String,TbDbDb>> listDbByGroupId();
}
