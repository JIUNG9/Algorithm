# [level 4] 그룹별 조건에 맞는 식당 목록 출력하기 - 131124 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131124) 

### Approach
- when use the aggregate funciton. select un-related column doesn't come out wanted result
- Get the number of review_id which is from the member_id

``` sql
select member_id, dense_rank() over(order by count(review_id) desc) 
from table
group by member_id

```




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
