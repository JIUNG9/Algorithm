# [level 4] 그룹별 조건에 맞는 식당 목록 출력하기 - 131124 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131124) 

### Approach
- Domain: There are multiple rows by member_id at rest_review table
- Impl: Get rank
  1. Use the dense rank function
  2. Use the limit at order by caluse


``` sql
(Use dense rank)
with get_most_review as (
select member_id, dense_rank() over(order by count(review_id) desc)
from table
group by member_id
)

(Use limit )
with get_most_review as (
select member_id
from table
group by member_id
order by count(review_id) desc limit 1
)

```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
