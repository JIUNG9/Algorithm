# [level 2] 피로도 - 87946 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87946) 

### Approach
- Iterating all of dungeons and visit the dungeon which is current stemina is bigger or equal with at least of requirement stamina, get the answer the max number of visited dungeon. when can't go dungeon anymore cuz of the current stemina is less than least of requirement stamina compare the answer which is represented the current max value of visited. If the number of current visited is bigger than answer update.


- implementation 1. Permutation -> iterating all of elements without keeping the order. 2. use the counter parameter in stack because need to check when can't visit current check dungeon should update the answer If the counter is bigger than answer and above all kept the statement If can enter the another dungeon(keep the numbe of counter)


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
