create user danan identified by danan;
grant create session to danan;
create tablespace danan datafile 'C:\oraclexe\app\oracle\oradata\XE\DANAN.DBF' size 100M uniform;
--drop tablespace danan including contents;
alter user danan quota unlimited on danan;
select * from v$datafile;