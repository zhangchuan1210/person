分库分表sql-----便于扩容,和水平迁移
create table tb_db_group(

   group_id int,
   group_name varchar(40),
   start_no int,
   end_no int
)

create table tb_db_db(

  group_id int,
  db_id int ,
  db_name varchar(100),
  hash_value varchar(100)
)

create table tb_db_table(
   table_id int,
   db_id int,
   table_name varchar(30),
   start_no int,
   end_no int

)

insert into tb_db_group(group_id ,
                            group_name ,
                            start_no ,
                            end_no) values(1,'group01',0,40000000),(2,'group02',40000000,80000000);

insert into tb_db_db(
                         db_id ,
                         db_name ,
                         group_id ,
                         hash_value )values(1,'g01_db_0',1,'0,1,2,3'),(2,'g01_db_1',1,'4,5,6'),(3,'g01_db_2',1,'7,8,9'),
                         (4,'g02_db_0',2,'0,1,2'),(5,'g02_db_1',2,'3,4,5'),(6,'g02_db_2',2,'6,7,8');

insert into tb_db_table(table_id ,
                            table_name ,
                            db_id ,
                            start_no ,
                            end_no) values(1,'table0',1,0,10000000),(2,'table1',1,10000000,20000000),(3,'table2',1,20000000,30000000),(4,'table3',1,30000000,40000000),
                            (5,'table4',2,0,10000000),(6,'table5',2,10000000,25000000),(7,'table6',2,25000000,40000000),
(8,'table7',3,0,10000000),(9,'table8',3,10000000,25000000),(10,'table9',3,25000000,40000000);