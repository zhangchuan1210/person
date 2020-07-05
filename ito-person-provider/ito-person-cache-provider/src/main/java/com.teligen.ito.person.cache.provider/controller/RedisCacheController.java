package com.teligen.ito.person.cache.provider.controller;

import com.teligen.ito.person.cache.provider.service.ICacheService;
import com.teligen.ito.person.common.model.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisCache")
@Api(tags="缓存服务")
public class RedisCacheController {
    @Autowired
    private ICacheService cacheService;

    @RequestMapping(value = "/cache",method = RequestMethod.GET)
    @ApiOperation(value = "",notes = "")
    public ResultVo cache(String key,String value){
        ResultVo<Boolean> resultVo=new ResultVo<>();
        boolean res=cacheService.put("",key,value);
        resultVo.success(res);
        return resultVo;
    }



}
