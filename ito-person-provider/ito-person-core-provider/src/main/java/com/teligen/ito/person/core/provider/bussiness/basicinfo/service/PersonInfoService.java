package com.teligen.ito.person.core.provider.bussiness.basicinfo.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;


import java.util.List;

public interface PersonInfoService {
    PersonInfoVo add(PersonInfoVo personInfoVo);
    Boolean batchAdd(List<PersonInfoVo> personInfoVo);
    Page<PersonInfoVo> pagingQuery(PageQuery<PersonInfoVo> pageQuery);
}
