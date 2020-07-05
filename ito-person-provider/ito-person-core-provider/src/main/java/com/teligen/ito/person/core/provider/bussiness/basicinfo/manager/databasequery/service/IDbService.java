package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service;

import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.DbInfo;

public interface IDbService {

   DbInfo selectDbTable(String Id);


}
