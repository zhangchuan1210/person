package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbDb;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper.TbDbDbMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbDbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TbDbDbServiceImpl extends ServiceImpl<TbDbDbMapper, TbDbDb> implements TbDbDbService {

    @Override
    public TbDbDb selectDb(String id) {
        QueryWrapper<TbDbDb> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().like(TbDbDb::getHashValue,id);
        TbDbDb db=this.getOne(queryWrapper);
        return db;
    }
    @Override
    public Map<Integer, Map<String,TbDbDb>> listDbByGroupId(){
        Map<Integer, Map<String,TbDbDb>> result=new HashMap<>();
        List<TbDbDb> res=this.list();
        res.stream().forEach(t->{
            Integer groupId=t.getGroupId();
            String hashValue=t.getHashValue();
            Map<String,TbDbDb> temp=result.get(groupId);
            if(StrUtil.isEmptyIfStr(temp)){
                temp=new HashMap<>();
            }

            TbDbDb dbTemp=temp.get(hashValue);
            if(StrUtil.isBlankIfStr(dbTemp)){
                temp.put(hashValue,t);
            }
            result.put(groupId,temp);

        });
        return result;

    }


}
