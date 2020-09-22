-- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary）
select max(salary) secondhighestsalary
from employee
where salary != (select max(salary) from employee)