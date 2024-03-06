# [level 3] 네트워크 - 43162 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43162) 

### Consideration

1. Input size is under 200, so can approach to This can be solved with DFS.
2. If n1, n2 is connected with line. should consider nodes which are connected by n1, n2. so declare the visited array for checking already checked.
3. At last check the number of stand alone which is not connected anything without itself.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
