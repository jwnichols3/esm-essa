--
--
drop table essa.boot_time;
--
--
create table essa.boot_time (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
