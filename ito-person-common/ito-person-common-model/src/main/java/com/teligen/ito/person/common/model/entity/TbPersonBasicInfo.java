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
public class TbPersonBasicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    protected String pid;

    /**
     * 姓名
     */
    protected String name;

    /**
     * 电话号码
     */
    protected String telephone;

    /**
     * 年龄
     */
    protected Integer age;

    /**
     * 性别
     */
    protected String sex;

    /**
     * 国籍
     */
    protected String nation;

    /**
     * 职业
     */
    protected String profession;

    /**
     * 数据来源
     */
    protected String infoSource;

    /**
     * 身份
     */
    protected String identify;

    /**
     * 所属政党/组织
     */
    protected String participatinGroup;

    /**
     * 学历
     */
    protected String educate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getParticipatinGroup() {
        return participatinGroup;
    }

    public void setParticipatinGroup(String participatinGroup) {
        this.participatinGroup = participatinGroup;
    }

    public String getEducate() {
        return educate;
    }

    public void setEducate(String educate) {
        this.educate = educate;
    }

    @Override
    public String toString() {
        return "TbPersonBasicInfo{" +
        ", id=" + id +
        ", pid=" + pid +
        ", name=" + name +
        ", telephone=" + telephone +
        ", age=" + age +
        ", sex=" + sex +
        ", nation=" + nation +
        ", profession=" + profession +
        ", infoSource=" + infoSource +
        ", identify=" + identify +
        ", participatinGroup=" + participatinGroup +
        ", educate=" + educate +
        "}";
    }
}
