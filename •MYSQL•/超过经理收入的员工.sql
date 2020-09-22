-- Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
-- 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。
-- 在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
select e1.name as Employee
from Employee e1 left join Employee e2
on e1.managerid = e2.id
where e1.salary > e2.salary