package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbDb;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper.TbDbDbMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbDbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
@Service
public class TbDbDbServiceImpl extends ServiceImpl<TbDbDbMapper, TbDbDb> implements TbDbDbService {

    @Override
    public TbDbDb selectDb(String id) {
        QueryWrapper<TbDbDb> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().like(TbDbDb::getHashValue,id);
        TbDbDb db=this.getOne(queryWrapper);
        return db;
    }
}
