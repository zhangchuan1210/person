package com.teligen.ito.person.core.provider.bussiness.basicinfo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teligen.ito.person.common.model.query.PageQuery;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.PersonExtInfo;
import com.teligen.ito.person.common.model.vo.PersonInfoVo;
import com.teligen.ito.person.common.model.vo.ResultVo;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.service.PersonInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("personinfo")
@Api(tags = "人员信息服务类")
public class PersonInfoController {
  @Autowired
  private PersonInfoService personInfoService;
  @RequestMapping(value="/add",method = RequestMethod.POST)
  @ApiOperation(value = "插入人员信息",notes = "插入人员信息")
  @ResponseBody
  public ResultVo<PersonInfoVo<PersonExtInfo>> add(@RequestBody PersonInfoVo<PersonExtInfo> personInfoVo, HttpServletRequest request){
      ResultVo<PersonInfoVo<PersonExtInfo>> resultVo=new ResultVo();
      PersonInfoVo<PersonExtInfo> res=personInfoVo;
      try{
          res=personInfoService.add(personInfoVo);
        return resultVo.success(res);
      }catch (Exception e){
        e.printStackTrace();
        return resultVo.fail(res);
      }

  }
    @RequestMapping(value="/batchAdd",method = RequestMethod.POST)
    @ApiOperation(value = "批量插入人员信息",notes = "批量插入人员信息")
    @ResponseBody
  public ResultVo<Boolean> batchAdd(@RequestBody List<PersonInfoVo> personInfoVo, HttpServletRequest request){
      ResultVo<Boolean > resultVo=new ResultVo<>();
      Boolean res=false;
      try{
          res=personInfoService.batchAdd(personInfoVo);
          return resultVo.success(res);
      }catch (Exception e){
          e.printStackTrace();
          return resultVo.fail(res);

      }


  }

  @RequestMapping(value="/delete",method = RequestMethod.POST)
  @ApiOperation(value = "删除基本信息",notes="删除基本信息")
  @ResponseBody
  public ResultVo<PersonInfoVo> delete(@RequestBody PersonInfoVo personInfoVo,HttpServletRequest request){
       ResultVo<PersonInfoVo> resultVo=new ResultVo<>();
       PersonInfoVo res=personInfoVo;
       try{
           return resultVo.success(res);

       }catch(Exception e){

           e.printStackTrace();
           return resultVo.fail(res);
       }
  }


    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新基本信息",notes="更新基本信息")
    @ResponseBody
    public ResultVo update(@RequestBody PersonInfoVo personInfoVo,HttpServletRequest request){
        ResultVo<PersonInfoVo> resultVo=new ResultVo<>();
        PersonInfoVo res=personInfoVo;
        try{
            return resultVo.success(res);

        }catch(Exception e){

            e.printStackTrace();
            return resultVo.fail(res);
        }
    }

    @RequestMapping(value="/pagingQuery",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询",notes="分页查询")
    @ResponseBody
    public ResultVo<Page<PersonInfoVo>> pagingQuery(@RequestBody PageQuery<PersonInfoVo> pageQuery, HttpServletRequest request){
        ResultVo<Page<PersonInfoVo>> resultVo=new ResultVo<>();
        Page<PersonInfoVo> res=new Page<>();
        try{
            res=personInfoService.pagingQuery(pageQuery);
            return resultVo.success(res);
        }catch(Exception e){
            e.printStackTrace();
            return resultVo.fail(res);
        }
    }




}
