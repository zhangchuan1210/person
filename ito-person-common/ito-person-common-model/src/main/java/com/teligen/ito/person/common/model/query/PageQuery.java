package com.teligen.ito.person.common.model.query;

public class PageQuery<T> {
    private int pageNo;
    private int getPageSize;
    private T condition;
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getGetPageSize() {
        return getPageSize;
    }

    public void setGetPageSize(int getPageSize) {
        this.getPageSize = getPageSize;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }




}
