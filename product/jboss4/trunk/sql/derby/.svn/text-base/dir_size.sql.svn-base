--
--
drop table essa.directory_size;
--
--
create table essa.directory_size (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  target varchar(256) not null,
  threshold_type varchar(32) not null,
  min_range int not null,
  max_range int not null,
  recursive char(1) not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
