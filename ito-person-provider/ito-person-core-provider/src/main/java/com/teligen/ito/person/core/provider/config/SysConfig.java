package com.teligen.ito.person.core.provider.config;

import com.teligen.ito.person.core.provider.bussiness.basicinfo.design.CheckStrategy;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.design.ConvertStrategy;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.design.impl.PersonCheckStrategy;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.IPersonExtVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.PersonExtInfo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

@Configurable
public class SysConfig {
    @Bean
    @ConditionalOnMissingClass
    public CheckStrategy createCheckStrategy(){
        return new PersonCheckStrategy();
    }
    @Bean
    @ConditionalOnMissingClass
    public ConvertStrategy createConvertStrategy(){
        return null;
    }
    @Bean
    @ConditionalOnMissingClass
    public IPersonExtVo createPersonExtVo(){
        return new PersonExtInfo();
    }

}
