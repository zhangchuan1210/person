package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbDb;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbTable;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper.TbDbTableMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<Integer, Map<Integer,TbDbTable>> getTableByDbId(){
        Map<Integer,Map<Integer,TbDbTable>> result=new HashMap<>();
        List<TbDbTable> dbTableList=this.list();
        dbTableList.stream().forEach(t->{
            Integer dbId= t.getDbId();
            Integer startNo=t.getStartNo();
            Map<Integer,TbDbTable> res=result.get(dbId);

            if(StrUtil.isBlankIfStr(res)){
                res=new HashMap<>();
            }
            TbDbTable dbTable=res.get(startNo);
             if(StrUtil.isBlankIfStr(dbTable)){
                 res.put(startNo,t);
             }
            result.put(dbId,res);
        });
        return result;
    }



}
