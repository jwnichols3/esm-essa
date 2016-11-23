--
--
drop table essa.cma;
--
--
create table essa.cma (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  key2 varchar(32) not null,
  value2 varchar(2048) not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
