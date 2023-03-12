create table task
(
    id        integer primary key auto_increment,
    task_name varchar(500) not null,
    completed bit          not null default 0
);
