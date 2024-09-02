# [level 2] 게임 맵 최단거리 - 1844 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1844) 

### Approach

- The place which the user go is not the 0(wall), not exceed the map and not visited before. visit that location and then make that place as visited when the user get the last position(map end position) return the number of step from the start. If the user can't reach to end of map return the -1


### Impl
- Use the Queue for handling shortest path.
- When input the first step input the first counter which means '1' and input 0,0 ( start position ) absoultely make start position as visited

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
