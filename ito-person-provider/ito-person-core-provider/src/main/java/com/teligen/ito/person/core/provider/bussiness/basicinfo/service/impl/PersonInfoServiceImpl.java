package com.teligen.ito.person.core.provider.bussiness.basicinfo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teligen.ito.person.common.model.entity.TbPersonBasicInfo;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.IPersonExtVo;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private TbPersonBasicInfoService personBasicInfoService;
    @Resource
    private TbPersonExtInfoService personExtInfoService;
    @Autowired
    private TbPersonExtPropertyService personExtProperService;
    @Autowired
    private TbPersonIdentificationNumberService personIdentificationNumberService;
    @Autowired
    private IPersonExtVo personExtVo;

    private Log log=LogFactory.getLog(this.getClass());

    @Override
    @Transactional
    public PersonInfoVo add(PersonInfoVo personInfoVo) {
        personIdentificationNumberService.setComponentInterface(personExtInfoService);
        personBasicInfoService.setComponentInterface(personIdentificationNumberService);
        personBasicInfoService.addPerson(personInfoVo,null);
        return personInfoVo;
    }

    @Override
    @Transactional
    public Boolean batchAdd(List<PersonInfoVo> personInfoVo) {
        return null;
    }

    public Page<PersonInfoVo>  pagingQuery(PageQuery<PersonInfoVo> pageQuery) {
        QueryWrapper<TbPersonBasicInfo> queryWrapper=new QueryWrapper();
        HashMap<String,PersonInfoVo> map=new HashMap<>();
        personIdentificationNumberService.setComponentInterface(personBasicInfoService);
        personExtInfoService.setComponentInterface(personIdentificationNumberService);
        Page<PersonInfoVo> page=personExtInfoService.pagingQuery( personExtVo.getClass(),map,pageQuery,queryWrapper);
        Page<PersonInfoVo> result=new Page<>(page.getCurrent(),page.getSize());
        result.setRecords(new ArrayList<>(map.values()));
        return result;

    }

    @Override
    @Transactional
    public Boolean updatePerson(PersonInfoVo personInfoVo) {
        personIdentificationNumberService.setComponentInterface(personExtInfoService);
        personBasicInfoService.setComponentInterface(personIdentificationNumberService);
        Boolean res=personBasicInfoService.updatePerson(personInfoVo);

        return res;
    }

    @Override
    @Transactional
    public Boolean batchUpdate(List<PersonInfoVo> personInfoVos) {
        personIdentificationNumberService.setComponentInterface(personExtInfoService);
        personBasicInfoService.setComponentInterface(personIdentificationNumberService);
        Boolean res=personBasicInfoService.batchUpdate(personInfoVos);

        return res;

    }

    @Override
    @Transactional
    public Boolean deletePerson(PersonInfoVo personInfoVo) {
        personIdentificationNumberService.setComponentInterface(personExtInfoService);
        personBasicInfoService.setComponentInterface(personIdentificationNumberService);
        Boolean res=personBasicInfoService.deletePerson(personInfoVo);

        return res;
    }

    @Override
    @Transactional
    public Boolean batchDeletePerson(List<PersonInfoVo> personInfoVo) {
        personIdentificationNumberService.setComponentInterface(personExtInfoService);
        personBasicInfoService.setComponentInterface(personIdentificationNumberService);
        Boolean res=personBasicInfoService.batchDeletePerson(personInfoVo);

        return res;
    }


}
