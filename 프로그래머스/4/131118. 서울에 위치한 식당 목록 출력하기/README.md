# [level 4] 서울에 위치한 식당 목록 출력하기 - 131118 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131118) 

### Approach
- 3월의 데이터를 합쳐서 -> This meant not using the aggregate function(grouop by)
- There is null user_id at the result from the off_line table. so by using just join can't show the user_id as null only for the data from the off_line.
- considering above two condition. use the union keyword. filter the data from one table and another one and union.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
