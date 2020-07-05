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
public class TbDbTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer tableId;

    private Integer dbId;

    private String tableName;

    private Integer startNo;

    private Integer endNo;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
        return "TbDbTable{" +
        ", tableId=" + tableId +
        ", dbId=" + dbId +
        ", tableName=" + tableName +
        ", startNo=" + startNo +
        ", endNo=" + endNo +
        "}";
    }
}
