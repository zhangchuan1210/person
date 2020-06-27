package com.teligen.ito.person.core.provider.bussiness.basicinfo.vo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PersonExtInfo implements IPersonExtVo {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private String birthday;


}
