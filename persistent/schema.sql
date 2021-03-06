drop table danan.Address cascade constraints;
drop table danan.auditLogDetail cascade constraints;
drop table danan.User_Address cascade constraints;
drop table danan.UserAuditLog cascade constraints;
drop table danan.Users cascade constraints;
drop sequence danan.hibernate_sequence;
create sequence danan.hibernate_sequence start with 1 increment by 1;
create table danan.Address (id number(19,0) not null, address varchar2(255 char), primary key (id));
create table danan.auditLogDetail (id number(19,0) not null, action varchar2(80 char), description varchar2(300 char), auditLogId number(19,0) not null, primary key (id));
create table danan.User_Address (users_id number(19,0) not null, address_id number(19,0) not null);
create table danan.UserAuditLog (id number(19,0) not null, code number(5,0), endtimestamp timestamp, message varchar2(255 char), starttimestamp timestamp, userId number(19,0) not null, primary key (id));
create table danan.Users (id number(19,0) not null, name varchar2(255 char), primary key (id));
alter table danan.auditLogDetail add constraint FK1nvhoc0ij5m82at9uxtr5jnyo foreign key (auditLogId) references danan.UserAuditLog;
alter table danan.User_Address add constraint FKd574ky3oktgq00y548drejxh8 foreign key (address_id) references danan.Address;
alter table danan.User_Address add constraint FK396n6eyombb4sb0yrgusq5aqg foreign key (users_id) references danan.Users;
alter table danan.UserAuditLog add constraint FKtdevyicwx98g69dt49rvp4s3e foreign key (userId) references danan.Users;
drop table danan.Address cascade constraints;
drop table danan.auditLogDetail cascade constraints;
drop table danan.User_Address cascade constraints;
drop table danan.UserAuditLog cascade constraints;
drop table danan.Users cascade constraints;
drop sequence danan.hibernate_sequence;
create sequence danan.hibernate_sequence start with 1 increment by 1;
create table danan.Address (id number(19,0) not null, address varchar2(255 char), primary key (id));
create table danan.auditLogDetail (id number(19,0) not null, action varchar2(80 char), description varchar2(300 char), auditLogId number(19,0) not null, primary key (id));
create table danan.User_Address (users_id number(19,0) not null, address_id number(19,0) not null);
create table danan.UserAuditLog (id number(19,0) not null, code number(5,0), endtimestamp timestamp, message varchar2(255 char), starttimestamp timestamp, userId number(19,0) not null, primary key (id));
create table danan.Users (id number(19,0) not null, name varchar2(255 char), primary key (id));
alter table danan.auditLogDetail add constraint FK1nvhoc0ij5m82at9uxtr5jnyo foreign key (auditLogId) references danan.UserAuditLog;
alter table danan.User_Address add constraint FKd574ky3oktgq00y548drejxh8 foreign key (address_id) references danan.Address;
alter table danan.User_Address add constraint FK396n6eyombb4sb0yrgusq5aqg foreign key (users_id) references danan.Users;
alter table danan.UserAuditLog add constraint FKtdevyicwx98g69dt49rvp4s3e foreign key (userId) references danan.Users;
drop table danan.Address cascade constraints;
drop table danan.auditLogDetail cascade constraints;
drop table danan.User_Address cascade constraints;
drop table danan.UserAuditLog cascade constraints;
drop table danan.Users cascade constraints;
drop sequence danan.hibernate_sequence;
create sequence danan.hibernate_sequence start with 1 increment by 1;
create table danan.Address (id number(19,0) not null, address varchar2(255 char), primary key (id));
create table danan.auditLogDetail (id number(19,0) not null, action varchar2(80 char), description varchar2(300 char), auditLogId number(19,0) not null, primary key (id));
create table danan.User_Address (users_id number(19,0) not null, address_id number(19,0) not null);
create table danan.UserAuditLog (id number(19,0) not null, code number(5,0), endtimestamp timestamp, message varchar2(255 char), starttimestamp timestamp, userId number(19,0) not null, primary key (id));
create table danan.Users (id number(19,0) not null, name varchar2(255 char), primary key (id));
alter table danan.auditLogDetail add constraint FK1nvhoc0ij5m82at9uxtr5jnyo foreign key (auditLogId) references danan.UserAuditLog;
alter table danan.User_Address add constraint FKd574ky3oktgq00y548drejxh8 foreign key (address_id) references danan.Address;
alter table danan.User_Address add constraint FK396n6eyombb4sb0yrgusq5aqg foreign key (users_id) references danan.Users;
alter table danan.UserAuditLog add constraint FKtdevyicwx98g69dt49rvp4s3e foreign key (userId) references danan.Users;
