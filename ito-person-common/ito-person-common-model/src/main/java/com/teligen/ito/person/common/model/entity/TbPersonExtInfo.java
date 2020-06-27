package com.teligen.ito.person.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangchuan
 * @since 2020-06-25
 */
@TableName("TB_PERSON_EXT_INFO")
public class TbPersonExtInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    /**
     * 扩展属性表id
     */
    protected String extId;

    /**
     * 基本信息表pid
     */
    protected String bPid;

    /**
     * 扩展属性值
     */
    protected String extValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getbPid() {
        return bPid;
    }

    public void setbPid(String bPid) {
        this.bPid = bPid;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }

    @Override
    public String toString() {
        return "TbPersonExtInfo{" +
        ", id=" + id +
        ", extId=" + extId +
        ", bPid=" + bPid +
        ", extValue=" + extValue +
        "}";
    }
}
