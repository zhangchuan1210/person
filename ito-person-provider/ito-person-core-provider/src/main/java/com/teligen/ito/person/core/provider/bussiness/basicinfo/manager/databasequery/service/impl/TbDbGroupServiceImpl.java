package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbGroup;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper.TbDbGroupMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    @Override
    public Map<Integer,TbDbGroup> listByStartNo(){
        List<TbDbGroup> dbGroupList=this.list();
        Map<Integer,TbDbGroup> dbGroupMap=dbGroupList.stream().collect(Collectors.toMap(TbDbGroup::getStartNo, Function.identity(),(key1, key2)->key2));
        return dbGroupMap;

    }

}
