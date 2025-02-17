with get_count as (
    select e_child.id,  count(*) as child_count
    from ecoli_data e_child inner join ecoli_data e_parent on e_child.id = e_parent.parent_id
    group by e_child.id
)
select  e.id,
case 
when child_count is null then 0
else child_count
end as child_count
from get_count gc right join ecoli_data e on gc.id = e.id
order by e.id asc