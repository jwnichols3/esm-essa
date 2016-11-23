--
--
drop table essa.alarm_inhibit;
--
--
create table essa.alarm_inhibit (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  start_time varchar(8) not null,
  stop_time varchar(8) not null,
  day varchar(16) not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
