package com.teligen.ito.person.core.provider.bussiness.basicinfo.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teligen.ito.person.common.model.entity.TbPersonExtInfo;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.decorator.ComponentInterface;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.mapper.TbPersonExtInfoMapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.service.TbPersonExtInfoService;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.IPersonExtVo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class TbPersonExtInfoServiceImpl extends ServiceImpl<TbPersonExtInfoMapper, TbPersonExtInfo> implements TbPersonExtInfoService {

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
        if(null==pid){
            pid= IdUtil.fastSimpleUUID();
        }
        List<TbPersonExtInfo> extInfos=this.divideExtInfo(personInfoVo, pid);
        boolean res=this.saveBatch(extInfos);
        if(res && null!=this.getComponentInterface()){
            personInfoVo=this.getComponentInterface().addPerson(personInfoVo, pid);
        }
        return personInfoVo;
    }

    @Override
    public Boolean updatePerson(PersonInfoVo personInfoVo) {
        List<TbPersonExtInfo> extInfoList=this.divideExtInfo(personInfoVo,personInfoVo.getPid());
        boolean res=this.updateBatchById(extInfoList);
        if(res && null!=this.getComponentInterface()){
            res=this.getComponentInterface().updatePerson(personInfoVo);
        }
        return res;
    }

    @Override
    public Boolean batchUpdate(List<PersonInfoVo> personInfoVos) {
        List<TbPersonExtInfo> extInfos=new ArrayList<>();
        personInfoVos.parallelStream().forEach(t->{
            List<TbPersonExtInfo> subList=this.divideExtInfo(t,t.getPid());
            extInfos.addAll(subList);
        });
        boolean res=this.updateBatchById(extInfos,1000);
        if(res && null==this.getComponentInterface()){
           res= this.getComponentInterface().batchUpdate(personInfoVos);
        }
        return res;
    }

    @Override
    public Boolean deletePerson(PersonInfoVo personInfoVo) {

        String b_pid=personInfoVo.getPid();
        QueryWrapper<TbPersonExtInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("b_pid",b_pid);
        boolean res=this.remove(queryWrapper);
        if(res && null==this.getComponentInterface()){
            res=this.getComponentInterface().deletePerson(personInfoVo);
        }
        return res;
    }

    @Override
    public Boolean batchDeletePerson(List<PersonInfoVo> personInfoVo) {
        List<String> pids=new ArrayList<>();
        pids=personInfoVo.parallelStream().map(PersonInfoVo::getPid).collect(Collectors.toList());
        QueryWrapper<TbPersonExtInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("b_pid",pids);
        boolean res=this.remove(queryWrapper);
        if(res && null==this.getComponentInterface()){
            res=this.getComponentInterface().batchDeletePerson(personInfoVo);
        }
        return res;

    }

    @Override
    public <U extends IPersonExtVo> void  build(Class<U > cls, Map<String, PersonInfoVo> resultList, List basicInfos) {
       // Map<String,TbPersonExtInfo> basicInfoMap=((List<TbPersonExtInfo>)basicInfos).stream().collect(Collectors.toMap(TbPersonExtInfo::getbPid, Function.identity(), (key1, key2) -> key2));
        String pID=null;
        PersonInfoVo personInfoVo=null;
        List<TbPersonExtInfo> res=new ArrayList<>();
        List<PersonInfoVo<U>> temp= new ArrayList(resultList.values()) ;
        Map<String,U> extMap=this.buildExtInfo(cls,basicInfos);
        for(Map.Entry<String,PersonInfoVo> entity:resultList.entrySet()){
            pID=entity.getKey();
            personInfoVo=entity.getValue();
            U temp123=extMap.get(pID);
            personInfoVo.setExt(temp123);
        }


    }



    @Override
    public <U extends IPersonExtVo> Page pagingQuery(Class<U> cls, Map<String, PersonInfoVo> resultList, PageQuery<PersonInfoVo> pageQuery, QueryWrapper queryWrapper) {
        log.info("start paging query!!!!");
        List<TbPersonExtInfo> basicInfos=null;
        Page resultPage=new Page();
        List<String> personInfoVoList=new ArrayList<>(resultList.keySet());
        if(personInfoVoList.size()==0){
            Page<TbPersonExtInfo> queryPage=new Page<>(pageQuery.getPageNo(), pageQuery.getGetPageSize());
            resultPage=this.page(queryPage,queryWrapper);
            basicInfos=resultPage.getRecords();
            Map<String,U> extMap=this.buildExtInfo(cls,basicInfos);
            for(Map.Entry<String,U> entry:extMap.entrySet()){
                PersonInfoVo personInfoVo=new PersonInfoVo();
                String key=entry.getKey();
                U u=entry.getValue();
                personInfoVo.setExt(u);
                resultList.put(key,personInfoVo);
            }
        }else{
            QueryWrapper<TbPersonExtInfo> extInfoQueryWrapper=new QueryWrapper<>();
            extInfoQueryWrapper.in("b_pid",personInfoVoList);
            basicInfos=this.list(extInfoQueryWrapper);
            this.build(cls,resultList,basicInfos);
        }

        if(null!=this.getComponentInterface()){
            this.getComponentInterface().pagingQuery(cls,resultList,pageQuery,queryWrapper);
        }
        log.info("paging query end!!!!");
        return resultPage;
    }

    private List<TbPersonExtInfo> divideExtInfo(PersonInfoVo personInfoVo, String pId)  {
        List<TbPersonExtInfo> result=new ArrayList<>();
        Field[] fields=personInfoVo.getExt().getClass().getDeclaredFields();
        try{
            for(int i=0,j=fields.length;i<j;++i){
                TbPersonExtInfo personExtInfo=new TbPersonExtInfo();
                String name=fields[i].getName();
                String firstLetter=name.substring(0,1).toUpperCase();
                String getter="get"+firstLetter+name.substring(1);
                Method method=personInfoVo.getExt().getClass().getMethod(getter,new Class[]{});
                Object value=method.invoke(personInfoVo.getExt(),new Object[]{});
                personExtInfo.setbPid(pId);
                personExtInfo.setExtId(name);
                personExtInfo.setExtValue(value.toString());
                result.add(personExtInfo);
            }

        }catch(Exception e){
            e.printStackTrace();
            log.error(e);
        }

        return result;

    }

    private <U> Map<String, U> buildExtInfo(Class<U> cla, List<TbPersonExtInfo> extInfos) {
       Map<String,U> extInfoMap=new HashMap<>();
       extInfos.stream().forEach(t->{
           String pid=t.getbPid();
           Object value=t.getExtValue();
           String name=t.getExtId();
           U u=extInfoMap.get(pid);
           if(null==u){
               try {
                   u=cla.newInstance();
               } catch (InstantiationException e) {
                   e.printStackTrace();
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }
           String firstLetter=name.substring(0,1).toUpperCase();
           String setter="set"+firstLetter+name.substring(1);
           try {
               Class typeClass= cla.getDeclaredField(name).getType();
               Method method=cla.getMethod(setter,new Class[]{typeClass});
               method.invoke(u,value);
           } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
               e.printStackTrace();
           }
           extInfoMap.put(pid,u);
       });
       return extInfoMap;
    }







}
