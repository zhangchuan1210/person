package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author zhangchuan
 * @since 2020-07-04
 */
public class TbDbGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer groupId;

    private String groupName;

    private Integer startNo;

    private Integer endNo;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getStartNo() {
        return startNo;
    }

    public void setStartNo(Integer startNo) {
        this.startNo = startNo;
    }

    public Integer getEndNo() {
        return endNo;
    }

    public void setEndNo(Integer endNo) {
        this.endNo = endNo;
    }

    @Override
    public String toString() {
        return "TbDbGroup{" +
        ", groupId=" + groupId +
        ", groupName=" + groupName +
        ", startNo=" + startNo +
        ", endNo=" + endNo +
        "}";
    }
}
