--
--
drop table essa.file_system_size;
--
--
create table essa.file_system_size (
  id int not null,
  task_id varchar(48) not null,
  rule_id varchar(48) not null,
  version int not null,
  created bigint not null,
  modified bigint not null,
  target varchar(256) not null,
  block_threshold int not null,
  inode_threshold int not null,
  active char(1) not null,
  note varchar(2048) not null,
  primary key(id)
);
