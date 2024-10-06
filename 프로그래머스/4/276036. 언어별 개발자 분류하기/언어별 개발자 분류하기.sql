with get_front_dev as(
    select id
    from skillcodes s inner join developers d on s.code & d.skill_code
    where category like 'Front%'
)
,
c_shop_dev as(
    select id
    from skillcodes s inner join developers d on s.code & d.skill_code
    where s.name like 'C#'
)
,get_python_dev as(
    select id
    from skillcodes s inner join developers d on s.code & d.skill_code
    where name like 'Python'
)

select 
case
when id in (select * from get_python_dev) and id in (select * from get_front_dev) then 'A'
when id in  (select * from c_shop_dev) then 'B'
when id in (select * from get_front_dev) then 'C'
end as grade, id, email
from developers d
having grade is not null
order by grade, id