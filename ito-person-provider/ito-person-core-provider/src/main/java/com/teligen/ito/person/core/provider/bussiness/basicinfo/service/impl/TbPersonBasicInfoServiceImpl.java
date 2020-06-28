package com.teligen.ito.person.core.provider.bussiness.basicinfo.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teligen.ito.person.common.model.entity.TbPersonBasicInfo;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.decorator.ComponentInterface;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.mapper.TbPersonBasicInfoMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.service.TbPersonBasicInfoService;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.IPersonExtVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
 * @since 2020-06-25
 */
@Service
public class TbPersonBasicInfoServiceImpl extends ServiceImpl<TbPersonBasicInfoMapper, TbPersonBasicInfo> implements TbPersonBasicInfoService {
    private Log log= LogFactory.get();
    private ComponentInterface componentInterface;
    public ComponentInterface getComponentInterface() {
        return componentInterface;
    }
    public void setComponentInterface(ComponentInterface componentInterface) {
        this.componentInterface =componentInterface;
    }

    @Override
    public PersonInfoVo addPerson(PersonInfoVo personInfoVo,String pid) {
        TbPersonBasicInfo basicInfo=new TbPersonBasicInfo();
        if(null==pid){
            pid=IdUtil.fastSimpleUUID();
        }
        BeanUtils.copyProperties(personInfoVo,basicInfo);
        basicInfo.setPid(pid);
        boolean res=this.save(basicInfo);
        if(res && null!=this.getComponentInterface()){
           personInfoVo= this.getComponentInterface().addPerson(personInfoVo,pid);
           throw new RuntimeException();
        }

        return personInfoVo;
    }

    @Override
    public Boolean updatePerson(PersonInfoVo personInfoVo) {
        TbPersonBasicInfo basicInfo=new TbPersonBasicInfo();
        BeanUtils.copyProperties(personInfoVo,basicInfo);
        boolean res=this.updateById(basicInfo);
        if(res){
            res=this.getComponentInterface().updatePerson(personInfoVo);
        }
        return res;
    }

    @Override
    public Boolean batchUpdate(List<PersonInfoVo> personInfoVos) {
        List<TbPersonBasicInfo> basicInfos=new ArrayList<>();
        personInfoVos.parallelStream().forEach(t->{
            TbPersonBasicInfo basicInfo=new TbPersonBasicInfo();
             BeanUtils.copyProperties(t,basicInfo);
             basicInfos.add(basicInfo);
        });
        boolean res=this.updateBatchById(basicInfos);
        if(res && null!=this.getComponentInterface()){
            res=this.getComponentInterface().batchUpdate(personInfoVos);
        }
        return res;
    }

    @Override
    public Boolean deletePerson(PersonInfoVo personInfoVo) {
        boolean res=this.removeById(personInfoVo.getId());
        if(res && null==this.getComponentInterface()){
            res=this.getComponentInterface().deletePerson(personInfoVo);
        }
        return res;
    }

    @Override
    public Boolean batchDeletePerson(List<PersonInfoVo> personInfoVo) {
        List<Integer> ids=new ArrayList<>();
        ids=personInfoVo.parallelStream().map(PersonInfoVo::getId).collect(Collectors.toList());
        boolean res=this.removeByIds(ids);
        if(res && null!=this.getComponentInterface()){
            res=this.getComponentInterface().batchDeletePerson(personInfoVo);
        }
        return res;
    }


    @Override
    public <U extends IPersonExtVo> Page pagingQuery(Class<U> cls, Map<String, PersonInfoVo> resultList, PageQuery<PersonInfoVo> pageQuery, QueryWrapper queryWrapper){
        log.info("start paging query: ");
        List<TbPersonBasicInfo> basicInfos=null;
        Page resultPage=new Page();
        List<String> personInfoVoList= new ArrayList<>(resultList.keySet());
        if(personInfoVoList.size()==0){
            Page<TbPersonBasicInfo> queryPage=new Page<>(pageQuery.getPageNo(), pageQuery.getGetPageSize());
            resultPage=this.page(queryPage,queryWrapper);
            basicInfos=resultPage.getRecords();
            for(TbPersonBasicInfo t:(List<TbPersonBasicInfo>)basicInfos) {
                String pID=t.getPid();
                PersonInfoVo<U> personInfoVo1=new PersonInfoVo<U>();
                BeanUtils.copyProperties(t,personInfoVo1);
                resultList.put(pID,personInfoVo1);
            };
        }else{
            QueryWrapper<TbPersonBasicInfo> tempQuery=new QueryWrapper<>();
            tempQuery.in("pid",personInfoVoList);
            basicInfos=this.list(tempQuery);
            this.build(cls,resultList,basicInfos);
        }
        if(null!=this.getComponentInterface()){
        this.getComponentInterface().pagingQuery( cls,resultList,pageQuery,queryWrapper);
        }
        log.info("paging query end!!!");
        return resultPage;
    }
    @Override
    public <U extends IPersonExtVo> void build(Class<U> cls, Map<String, PersonInfoVo> resultList, List basicInfos) {
        Map<String,TbPersonBasicInfo> basicInfoMap=((List<TbPersonBasicInfo>)basicInfos).stream().collect(Collectors.toMap(TbPersonBasicInfo::getPid, Function.identity(), (key1, key2) -> key2));
        String pID=null;
        Map<String,PersonInfoVo> temp=new HashMap<>();
        PersonInfoVo personInfoVo=null;
        for(Map.Entry<String,PersonInfoVo> entity:resultList.entrySet()){
            pID=entity.getKey();
            personInfoVo=entity.getValue();
            TbPersonBasicInfo basicInfo=basicInfoMap.get(pID);
            BeanUtils.copyProperties(basicInfo,personInfoVo);
        }

    }

}
