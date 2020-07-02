package com.teligen.ito.person.core.provider.bussiness.basicinfo.design;

import com.teligen.ito.person.common.model.vo.MatchInfoVo;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;

import java.util.List;

public interface CheckStrategy {
    MatchInfoVo<PersonInfoVo> unique(PersonInfoVo infoVo, List<PersonInfoVo> sourceList);

    MatchInfoVo<PersonInfoVo> unique(List<PersonInfoVo> infoVo, List<PersonInfoVo> sourceList);

}
