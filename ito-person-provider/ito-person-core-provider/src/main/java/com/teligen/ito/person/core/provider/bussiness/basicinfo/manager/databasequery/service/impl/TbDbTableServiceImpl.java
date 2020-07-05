package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbTable;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper.TbDbTableMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbTableService;
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
public class TbDbTableServiceImpl extends ServiceImpl<TbDbTableMapper, TbDbTable> implements TbDbTableService {

    @Override
    public TbDbTable setlectTable(String id) {
        QueryWrapper<TbDbTable> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().ge(TbDbTable::getEndNo,id).lt(TbDbTable::getStartNo,id);
        TbDbTable table=this.getOne(queryWrapper);
        return table;
    }
}
