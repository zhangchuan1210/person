package com.teligen.ito.person.core.provider.bussiness.basicinfo.vo;

public abstract class IPersonExtVo {
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    protected String personId;
}
