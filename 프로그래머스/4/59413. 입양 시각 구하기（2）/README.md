# [level 4] 입양 시각 구하기(2) - 59413 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59413) 

### Approach
- Get the count of which is adapted by an hour.
- When there isn't the time which range is 0 to 23 in the table they won't show the time from 0 to 23. which doesn't exist. So make a table which has the data from 0 to 23 by using recursive function
- When using the join with two table use the left join which means join with the time table which exists from 0 to 23. If use the inner join It will just show the exist time at original table. and then group by the animal_id for getting the count of adapted animal


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
