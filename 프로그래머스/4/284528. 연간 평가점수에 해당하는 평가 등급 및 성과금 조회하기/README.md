# [level 4] 연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기 - 284528 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284528) 

### Approach
- No need the department table, as followed the domain, there is HALF_YEAR column at HR_GRADE so when judging the grade should consider first and second HALF_YEAR, grouping by the emp_no and get the avg by AVG function
- use the case when then clause for getting the bonus by the grade 

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
