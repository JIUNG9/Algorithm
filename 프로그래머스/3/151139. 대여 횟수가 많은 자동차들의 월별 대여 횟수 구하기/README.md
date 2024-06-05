# [level 3] 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기 - 151139 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/151139) 

### Approach
- logical:  "테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수, 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요."
- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 -> where start_date between 2022-08 and 2022-10
- 총 대여 횟수가 5회 이상 -> group by car_id having count(car_id) >= 5
- 자동차들에 대해서 -> declare the window function by following two above conditions
- 해당 기간 동안 ->  where start_date between 2022-08 and 2022-10
- 월별 자동차 ID 별 총 대여 횟수 -> group by month, car_id
- 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요 -> having count(car_id) > 0 : Using having clause with above window function can not satisfy first condition which the total sum of rental between Aug to Oct.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
