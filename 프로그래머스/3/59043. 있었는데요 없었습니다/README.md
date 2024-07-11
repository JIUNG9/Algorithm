# [level 3] 있었는데요 없었습니다 - 59043 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59043) 

### Domain
- The date time at the animals_in is the date about protection data from when, otherwise 
- The date time in animals_out is the date about when adapting the animal
 빠르다 -> 더 이전이다(past) -> 작다.
### Impl 
- join by the animal_id and filter the data which ai.datetime > ao.datetime, order by ai.datetime asc

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
