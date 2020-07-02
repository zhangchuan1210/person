package com.teligen.ito.person.core.provider.bussiness.basicinfo.design;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.IPersonExtVo;

import java.util.List;
import java.util.Map;

public interface ComponentInterface {

   <U extends IPersonExtVo> void build(Class<U> cls, Map<String, PersonInfoVo> resultList, List basicInfos);

   <U extends IPersonExtVo> Page pagingQuery(Class<U> cls, Map<String, PersonInfoVo> resultList, PageQuery<PersonInfoVo> page, QueryWrapper queryWrapper);

   ComponentInterface getComponentInterface() ;

   void setComponentInterface(ComponentInterface componentInterface) ;

   PersonInfoVo addPerson(PersonInfoVo personInfoVo,String pid);


   Boolean updatePerson(PersonInfoVo personInfoVo);

   Boolean batchUpdate(List<PersonInfoVo> personInfoVos);

    Boolean deletePerson(PersonInfoVo personInfoVo);

   Boolean batchDeletePerson(List<PersonInfoVo> personInfoVo);
}
