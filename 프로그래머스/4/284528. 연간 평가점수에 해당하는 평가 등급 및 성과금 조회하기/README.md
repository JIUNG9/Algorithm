# [level 4] 연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기 - 284528 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284528) 

### Approach
- get avg of score from the hr_grade which is group by the emp_no and select emp_no and avg of sum, with this data get user name from the employees table. and get Rank. and get bonus by Rank
  
``` sql
with get_Score as (select emp_no, avg(score) as score
from hr_grade
group by emp_no)

select emp_no, emp_name,
case when then as rank(use the case when then for getting rank),
case when then as bonus -> The bonus can get by the rank, but can't use the rank directly, so use the case when then clause by the score. and calculate the bonus)
order by emp_id




```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
