with get_c_shop_or_python_dev as(
    select id, email, first_name, last_name
    from developers
)

select id,email,first_name,last_name
from developers
where skill_code & (select code from skillcodes where name like "C#") or skill_code & (select code from skillcodes where name like "Python")
order by id asc