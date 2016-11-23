--
--
drop table essa.task;
--
--
create table essa.task (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  name varchar(256) not null,
  frequency int not null,
  match_all char(1) not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
