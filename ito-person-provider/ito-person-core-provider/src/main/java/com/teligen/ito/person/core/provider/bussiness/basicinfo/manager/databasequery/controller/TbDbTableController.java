package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.controller;


import com.teligen.ito.person.common.model.vo.ResultVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbTable;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbTableService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
@Controller
@RequestMapping("/tb-db-table")
@Api(tags="表服务")
public class TbDbTableController {
    @Autowired
    private TbDbTableService tableService;
    @RequestMapping(value = "/testJoin",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo<List<TbDbTable>> testJoin(){
        List<TbDbTable> res=tableService.testJoin();
        return null;
    }

}
