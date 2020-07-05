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
public class TbDbDb implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer groupId;

    private Integer dbId;

    private String dbName;

    private String hashValue;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    @Override
    public String toString() {
        return "TbDbDb{" +
        ", groupId=" + groupId +
        ", dbId=" + dbId +
        ", dbName=" + dbName +
        ", hashValue=" + hashValue +
        "}";
    }
}
