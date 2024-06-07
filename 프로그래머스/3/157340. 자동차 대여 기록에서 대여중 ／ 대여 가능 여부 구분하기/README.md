# [level 3] 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기 - 157340 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/157340) 

### Approach
- There is the same car_id by different history_id even there is one borrowed history the data which is "2022-10-16" between start_date and end_date they should show "대여중"
- when use the group by can use the sum function. when the data matched with the above condition return 1, when the sum function is end by car_id If the sum is equal with car_id should show the "대여중", else "대여가능"



``` sql
select car_id, 
when(sum(case when "2022-10-16" between start_date and end_date then 1 else 0 end)) is 1 then '대여중'
else '대여가능' end as availability
from table
group by car_id

```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
