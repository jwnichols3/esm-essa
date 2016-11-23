--
--
drop table essa.vpo;
--
--
create table essa.vpo (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  app_name varchar(256) not null,
  severity varchar(16) not null,
  frequency int not null,
  message varchar(2048) not null,
  source_host varchar(256) not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
