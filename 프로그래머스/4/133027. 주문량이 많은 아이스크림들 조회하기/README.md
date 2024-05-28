# [level 4] 주문량이 많은 아이스크림들 조회하기 - 133027 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133027) 

### Approach
- The first_half table pk is the flavor so doesn't have to duplicate of the flavor, otherwise july table pk is shipement_id there can be duplicate flavor so group by the flavor for getting total_order in july
- so now the each table has no duplicate flavor. inner join by flavor with each other will show the same flavor.
- get the result by (july table total orders by flavor + first half table total orders by flavor) desc limit 3 will be result

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
