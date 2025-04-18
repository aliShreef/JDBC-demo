create table `jdbc-demo`.employee
(
    PK_ID     int auto_increment
        primary key,
    NAME      varchar(50)    not null comment 'Employee Name',
    HIRE_DATE date           null comment 'Hiring Date',
    Salary    decimal(10, 2) null
)
    comment 'Employee Table' charset = utf16;

