--
--
drop table essa.boot_sample;
--
--
create table essa.boot_sample(
  id int not null,
  time_stamp bigint not null,
  sample bigint not null,
  active char(1) not null,
  note varchar(256) not null,
  primary key(id)
);
