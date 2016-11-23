--
--
drop table essa.boot_time_sample;
--
--
create table essa.boot_time_sample(
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  rule_row_id int not null,
  time_stamp bigint not null,
  boot_time bigint not null,
  matched char(1) not null,
  suppress char(1) not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);