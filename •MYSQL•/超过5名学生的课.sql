-- 请列出所有超过或等于5名学生的课
select class from courses
group by class
having count(distinct student) >= 5