package com.teligen.ito.person.core.provider.bussiness.basicinfo.design.impl;

import com.teligen.ito.person.common.model.vo.MatchInfoVo;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.design.CheckStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonCheckStrategy implements CheckStrategy {
    @Override
    public MatchInfoVo<PersonInfoVo> unique(PersonInfoVo infoVo, List<PersonInfoVo> sourceList) {
        return null;
    }

    @Override
    public MatchInfoVo<PersonInfoVo> unique(List<PersonInfoVo> infoVo, List<PersonInfoVo> sourceList) {
        return null;
    }
}
