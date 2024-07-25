# [level 3] 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기 - 151139 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/151139) 

### Domain
- The history table can have the multiple car_id

### Confusion thing
- "테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서" making the window function by following wih this clause the car id should be returned with where condition which code is "month(start_date) >= 8 and month(start_date) <= 10. and group by month and car_id from window function with history_table(inner join). But keep in mind about the tuples which is the car_id from the join table is not always indicated month(start_date) >= 8 and month(start_date) <= 10. This concept is just came from the domain
- 
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
