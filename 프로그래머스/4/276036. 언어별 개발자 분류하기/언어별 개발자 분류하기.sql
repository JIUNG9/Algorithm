with p as(

    select code
    from skillcodes
    where name like 'Python'
    
)
, f as(
    select sum(code) as code
    from skillcodes
    where category like "Front End"
    group by category

)

, cshop as (
    select code
    from skillcodes
    where name like 'C#'
)


select 
case
when skill_code & f.code AND skill_code & p.code then 'A'
when skill_code & cshop.code then 'B'
when skill_code & f.code then 'C'
end as grade ,id , email
from developers , f , p, cshop 
having grade is not null
order by  1 asc , 2 asc 
