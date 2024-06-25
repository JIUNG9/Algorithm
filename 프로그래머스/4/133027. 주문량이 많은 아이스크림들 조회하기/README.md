# [level 4] 주문량이 많은 아이스크림들 조회하기 - 133027 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133027) 

### Approach
- the problem of using join clause with with clause which is aggregated by flavor for each table, The flavor can be exist which is not the joined point. So can't use the join
- alternatively can use the union clause. union the table which is the aggregated and aggregate by the flavor once makes get all result

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
