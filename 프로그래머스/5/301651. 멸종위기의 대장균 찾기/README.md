# [level 5] 멸종위기의 대장균 찾기 - 301651 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/301651) 

### Approach
- logical : The init data which parent id is null should be 1 generation. and get the generation with id by the data which is from the last result of generation and id matched ecoli_data parent_id until there is no generation anymore.
and get the data which has no parent_id. With that data group by the generation and get count of the each of generation which has no parent_id.


``` sql
with recursive cte as(
//init
select id, 1 as gen
from ecoli_data
where parent_id is null

union all
//recursive
select id, gen+1 as gen
from cte as c inner join ecoli_data as e c.id = ecoli_data.parent_id
)

, get_has_parent as(
select e.parent_id
from cte as c inner join ecoli_data as e on e.parent_id = c.id
)

select count(*), gen
from cte
where id not in (select parent_id as id from get_has_parent)
group by gen
order by gen



```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
