package com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.impl;

import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbDb;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbGroup;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.entity.TbDbTable;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.IDbService;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbDbService;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbGroupService;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.manager.databasequery.service.TbDbTableService;
import com.teligen.ito.person.core.provider.bussiness.basicinfo.vo.DbInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbServiceImpl implements IDbService {
    @Autowired
    private TbDbDbService dbDbService;
    @Autowired
    private TbDbGroupService dbGroupService;
    @Autowired
    private TbDbTableService dbTableService;

    @Override
    public DbInfo selectDbTable(String id) {
        DbInfo dbInfo=new DbInfo();
        TbDbGroup dbGroup= dbGroupService.selectGroup(id);
        TbDbDb dbDb=dbDbService.selectDb(id);
        TbDbTable dbTable=dbTableService.setlectTable(id);
        dbInfo.setDbId(dbDb.getDbId());
        dbInfo.setGroupId(dbGroup.getGroupId());
        dbInfo.setGroupName(dbGroup.getGroupName());
        dbInfo.setTbId(dbTable.getTableId());
        dbInfo.setTbName(dbTable.getTableName());
        return dbInfo;
    }
}
