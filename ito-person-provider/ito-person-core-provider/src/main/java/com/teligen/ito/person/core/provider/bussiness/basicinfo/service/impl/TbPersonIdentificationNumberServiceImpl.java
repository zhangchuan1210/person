package com.teligen.ito.person.core.provider.bussiness.basicinfo.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teligen.ito.person.common.model.entity.TbPersonBasicInfo;
import com.teligen.ito.person.common.model.entity.TbPersonIdentificationNumber;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.decorator.ComponentInterface;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.mapper.TbPersonIdentificationNumberMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.service.TbPersonIdentificationNumberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.IPersonExtVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class TbPersonIdentificationNumberServiceImpl extends ServiceImpl<TbPersonIdentificationNumberMapper, TbPersonIdentificationNumber> implements TbPersonIdentificationNumberService {
    private Log log= LogFactory.get();
    private ComponentInterface componentInterface;
    public ComponentInterface getComponentInterface() {
        return componentInterface;
    }

    public void setComponentInterface(ComponentInterface componentInterface) {
        this.componentInterface =componentInterface;
    }

    @Override
    public PersonInfoVo addPerson(PersonInfoVo personInfoVo, String pid) {
        TbPersonIdentificationNumber identificationNumber=new TbPersonIdentificationNumber();
        if(null==pid){
            pid= IdUtil.fastSimpleUUID();
        }
        BeanUtils.copyProperties(personInfoVo.getIdentificationNumber(),identificationNumber);
        identificationNumber.setbPid(pid);
        boolean res=this.save(identificationNumber);
        if(res && null!=this.getComponentInterface()){
            personInfoVo=this.getComponentInterface().addPerson(personInfoVo, pid);
        }
        return personInfoVo;
    }

    @Override
    public Boolean updatePerson(PersonInfoVo personInfoVo) {
        TbPersonIdentificationNumber identificationNumber=new TbPersonIdentificationNumber();
        BeanUtils.copyProperties(personInfoVo.getIdentificationNumber(),identificationNumber);
        boolean res=this.updateById(identificationNumber);
        if(res && null!=this.getComponentInterface()){
            res=this.getComponentInterface().updatePerson(personInfoVo);
        }
        return res;
    }

    @Override
    public Boolean batchUpdate(List<PersonInfoVo> personInfoVos) {
        List<TbPersonIdentificationNumber> identificationNumbers=new ArrayList<>();
        personInfoVos.parallelStream().forEach(t->{
            TbPersonIdentificationNumber identificationNumber=new TbPersonIdentificationNumber();
            BeanUtils.copyProperties(t,identificationNumber);
            identificationNumbers.add(identificationNumber);

        });
        boolean res=this.updateBatchById(identificationNumbers,1000);
        if(res && null==this.getComponentInterface()){
            this.getComponentInterface().batchUpdate(personInfoVos);
        }
        return res;
    }

    @Override
    public Boolean deletePerson(PersonInfoVo personInfoVo) {
        Integer id=personInfoVo.getIdentificationNumber().getId();
        boolean res=this.removeById(id);
        if(res && null!=this.getComponentInterface()){

            res=this.getComponentInterface().deletePerson(personInfoVo);
        }
        return res;
    }

    @Override
    public Boolean batchDeletePerson(List<PersonInfoVo> personInfoVo) {
        List<Integer> ids=new ArrayList<>();
        personInfoVo.parallelStream().forEach(t->{
            ids.add(t.getIdentificationNumber().getId());
        });
        boolean res=this.removeByIds(ids);
        if(res && null!=this.getComponentInterface()){
            res=this.getComponentInterface().batchDeletePerson(personInfoVo);
        }
        return res;
    }


    @Override
    public <U extends IPersonExtVo> void build(Class<U> cls, Map<String, PersonInfoVo> resultList, List basicInfos) {
        Map<String,TbPersonIdentificationNumber> basicInfoMap=((List<TbPersonIdentificationNumber>)basicInfos).stream().collect(Collectors.toMap(TbPersonIdentificationNumber::getbPid, Function.identity(), (key1, key2) -> key2));
        String pID=null;
        PersonInfoVo personInfoVo=null;
        for(Map.Entry<String,PersonInfoVo> entity:resultList.entrySet()){
            pID=entity.getKey();
            personInfoVo=entity.getValue();
            TbPersonIdentificationNumber basicInfo=basicInfoMap.get(pID);
            personInfoVo.setIdentificationNumber(new TbPersonIdentificationNumber());
            BeanUtils.copyProperties(basicInfo,personInfoVo.getIdentificationNumber());
        }
    }



    @Override
    public <U extends IPersonExtVo> Page pagingQuery( Class<U> cls, Map<String, PersonInfoVo> resultList, PageQuery<PersonInfoVo> pageQuery, QueryWrapper queryWrapper) {
        log.info("start paging query!!!");
        List<TbPersonIdentificationNumber> basicInfos=null;
        Page resultPage=new Page();
        List<String> personInfoVoList=new ArrayList<>(resultList.keySet());
        if(personInfoVoList.size()==0){
            Page<TbPersonIdentificationNumber> queryPage=new Page<>(pageQuery.getPageNo(), pageQuery.getGetPageSize());
            resultPage=this.page(queryPage,queryWrapper);
            basicInfos=resultPage.getRecords();
            for(TbPersonIdentificationNumber t:(List<TbPersonIdentificationNumber>)basicInfos) {
                String pID=t.getbPid();
                PersonInfoVo<U> personInfoVo1=new PersonInfoVo<U>();
                personInfoVo1.setIdentificationNumber(new TbPersonIdentificationNumber());
                BeanUtils.copyProperties(t,personInfoVo1.getIdentificationNumber());
                resultList.put(pID,personInfoVo1);
            };
        }else{
            QueryWrapper<TbPersonIdentificationNumber> identificationNumberQueryWrapper=new QueryWrapper<>();
            identificationNumberQueryWrapper.in("b_pid",personInfoVoList);
            basicInfos=this.list(identificationNumberQueryWrapper);
            this.build(cls,resultList,basicInfos);
        }

        if(null!=this.getComponentInterface()){

        this.getComponentInterface().pagingQuery( cls,resultList,pageQuery,queryWrapper);

        }
        log.info("paging query end!!!!");
        return resultPage;
    }
}
