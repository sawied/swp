create user danan identified by password;
grant create session to danan;
create tablespace danan datafile 'E:\oraclexe\app\oracle\oradata\XE\DANAN.DBF' size 300M uniform;
--drop tablespace danan including contents;
alter user danan quota unlimited on danan;
alter user danan default TABLESPACE danan;
select * from v$datafile;