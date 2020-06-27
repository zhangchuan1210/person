package com.teligen.ito.person.common.model.vo;

import com.teligen.ito.person.common.model.entity.TbPersonBasicInfo;
import com.teligen.ito.person.common.model.entity.TbPersonIdentificationNumber;

public class PersonInfoVo<T> extends TbPersonBasicInfo {
    protected T ext;

    public T getExt() {
        return ext;
    }

    public void setExt(T ext) {
        this.ext = ext;
    }

    public TbPersonIdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(TbPersonIdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    protected TbPersonIdentificationNumber identificationNumber;
   /* public PersonInfoVo(TbPersonIdentificationNumber number,T t){
        this.identificationNumber=number;
        this.ext=t;
    }*/

}
