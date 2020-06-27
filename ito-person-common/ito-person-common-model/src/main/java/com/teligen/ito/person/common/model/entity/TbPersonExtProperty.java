package com.teligen.ito.person.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangchuan
 * @since 2020-06-25
 */
public class TbPersonExtProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    /**
     * 扩展字段名
     */
    protected String pName;

    /**
     * 扩展字段所属区域
     */
    protected String pAreacode;

    /**
     * 扩展字段所属系统
     */
    protected String pSystemcode;

    /**
     * 扩展字段类型
     */
    protected String pType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAreacode() {
        return pAreacode;
    }

    public void setpAreacode(String pAreacode) {
        this.pAreacode = pAreacode;
    }

    public String getpSystemcode() {
        return pSystemcode;
    }

    public void setpSystemcode(String pSystemcode) {
        this.pSystemcode = pSystemcode;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    @Override
    public String toString() {
        return "TbPersonExtProperty{" +
        ", id=" + id +
        ", pName=" + pName +
        ", pAreacode=" + pAreacode +
        ", pSystemcode=" + pSystemcode +
        ", pType=" + pType +
        "}";
    }
}
