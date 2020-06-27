package com.teligen.ito.person.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class TbPersonIdentificationNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    /**
     * 人员基本表Pid
     */
    protected String bPid;

    /**
     * 身份证号
     */
    @TableField("ID_number")
    protected String idNumber;

    /**
     * 护照
     */
    protected String passort;

    /**
     * 港澳通行证
     */
    protected String hkmpass;

    /**
     * 军官证
     */
    protected String military;

    /**
     * 工作证
     */
    protected String employeeCard;

    /**
     * 驾驶证
     */
    protected String license;

    /**
     * 学生证
     */
    protected String studentCard;

    /**
     * 社保号
     */
    protected String socialCara;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbPid() {
        return bPid;
    }

    public void setbPid(String bPid) {
        this.bPid = bPid;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassort() {
        return passort;
    }

    public void setPassort(String passort) {
        this.passort = passort;
    }

    public String getHkmpass() {
        return hkmpass;
    }

    public void setHkmpass(String hkmpass) {
        this.hkmpass = hkmpass;
    }

    public String getMilitary() {
        return military;
    }

    public void setMilitary(String military) {
        this.military = military;
    }

    public String getEmployeeCard() {
        return employeeCard;
    }

    public void setEmployeeCard(String employeeCard) {
        this.employeeCard = employeeCard;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(String studentCard) {
        this.studentCard = studentCard;
    }

    public String getSocialCara() {
        return socialCara;
    }

    public void setSocialCara(String socialCara) {
        this.socialCara = socialCara;
    }

    @Override
    public String toString() {
        return "TbPersonIdentificationNumber{" +
        ", id=" + id +
        ", bPid=" + bPid +
        ", idNumber=" + idNumber +
        ", passort=" + passort +
        ", hkmpass=" + hkmpass +
        ", military=" + military +
        ", employeeCard=" + employeeCard +
        ", license=" + license +
        ", studentCard=" + studentCard +
        ", socialCara=" + socialCara +
        "}";
    }
}
