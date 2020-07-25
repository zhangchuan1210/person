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

import java.util.Map;

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


    public DbInfo getDbInfo(Integer key){
        DbInfo dbInfo=new DbInfo();
        Map<Integer,TbDbGroup> groupMap=dbGroupService.listByStartNo();
        Map<Integer, Map<String,TbDbDb>> dbMap=dbDbService.listDbByGroupId();
        Map<Integer, Map<Integer,TbDbTable>> tableMap=dbTableService.getTableByDbId();
        Integer tempkey=0;
        for(Integer groupKey:groupMap.keySet()){
            if(key>groupKey){
                tempkey=groupKey;
                continue;
            }
        }
        TbDbGroup dbGroup=groupMap.get(tempkey);
        Integer groupId=dbGroup.getGroupId();
        Map<String,TbDbDb> dbDbMap=dbMap.get(groupId);
        Integer hashValue=key%11;
        TbDbDb tbDbDb=null;
        for(String hashKey:dbDbMap.keySet()){
            if(hashKey.contains(hashValue.toString())){
                tbDbDb=dbDbMap.get(hashKey);
                break;
            }
        }
        Map<Integer,TbDbTable> dbTableMap=tableMap.get(tbDbDb.getDbId());
        Integer tempKey=0;
        for(Integer tableKey:dbTableMap.keySet()){
            if(key>tableKey){
                tempKey=tableKey;
                continue;
            }
        }
        TbDbTable table=dbTableMap.get(tempKey);
        dbInfo.setGroupId(tempkey);
        dbInfo.setDbId(tbDbDb.getDbId());
        dbInfo.setTbId(tempKey);
        return dbInfo;
    }





}
