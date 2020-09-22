-- 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户
select c.name as customers
from customers c left join orders o
on o.customerid = c.id
where o.id is null