-- 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个
delete p1 
from person p1 join person p2
on p1.email = p2.email and p1.id > p2.id