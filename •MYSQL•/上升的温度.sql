-- 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
select a.id from weather a join weather b 
on a.temperature > b.temperature and datediff(a.recorddate,b.recorddate) = 1
-- datediff是datea-dateb的天数差