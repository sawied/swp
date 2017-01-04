> 
>###As a database administrator, you must execute the schema creation SQL first. create a database user, grant basic permission for database access.###
>*the below code segment as a sample for developer test.*

*************************************************************
`create user sawied identified by password;`

`grant create session to sawied;`

`create tablespace sawied datafile 'E:\oraclexe\app\oracle\oradata\XE\sawied.DBF' size 200M uniform;`

`--drop tablespace danan including contents;`

`alter user sawied quota unlimited on sawied;`

`select * from v$datafile;`