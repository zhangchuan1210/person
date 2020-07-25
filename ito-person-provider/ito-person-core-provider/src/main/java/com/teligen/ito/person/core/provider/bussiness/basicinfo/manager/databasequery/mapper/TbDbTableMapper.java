package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
@Mapper
public interface TbDbTableMapper extends BaseMapper<TbDbTable> {
    List<TbDbTable> testJoin(@Param("ew") QueryWrapper<TbDbTable> queryWrapper);
}
