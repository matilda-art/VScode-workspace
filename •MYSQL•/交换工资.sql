-- 给定一个 salary 表，如下所示，有 m = 男性 和 f = 女性 的值。
-- 交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求只使用一个更新（Update）语句，并且没有中间的临时表。
update salary set sex = if(sex = 'm','f','m')
-- sql中if(s1,s2,s3)的意思是：如果s1为true，则返回s2；如果s1为false，则返回s3