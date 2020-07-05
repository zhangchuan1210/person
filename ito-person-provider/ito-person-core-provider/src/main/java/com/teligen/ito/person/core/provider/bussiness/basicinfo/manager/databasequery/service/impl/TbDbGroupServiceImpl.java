package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbGroup;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper.TbDbGroupMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbGroupService;
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
public class TbDbGroupServiceImpl extends ServiceImpl<TbDbGroupMapper, TbDbGroup> implements TbDbGroupService {

    @Override
    public TbDbGroup selectGroup(String id) {
        QueryWrapper<TbDbGroup> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().ge(TbDbGroup::getStartNo,id).lt(TbDbGroup::getEndNo,id);
        TbDbGroup group=this.getOne(queryWrapper);
        return group;
    }
}
