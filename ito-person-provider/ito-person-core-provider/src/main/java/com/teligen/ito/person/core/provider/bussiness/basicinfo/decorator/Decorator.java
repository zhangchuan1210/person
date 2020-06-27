package com.teligen.ito.person.core.provider.bussiness.basicinfo.decorator;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.common.util.SpringUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

public class Decorator<T extends ComponentInterface>  {
    private T t;


}
