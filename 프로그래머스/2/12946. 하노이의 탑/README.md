# [level 2] 하노이의 탑 - 12946 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12946) 

### Approach

- logical:
  1. Move the the number of n-1 from start to to(through mid)
  2. Move the n from start to to
  3. Move the first phase of the number of (n-1) from mid to to(through start)
 
### Implmentation
- DFS
  1. Permutation or not : the order is matter so not using the permutation way
  2. What should be in stack: The start, mid, to should be kept the statement, and should be changed also n as well
  3. End condition: when the 'n' is reached to 1 add the path in the answer list
  4. When should add the path info?: The bigger value is pushed into the stack. so when it's pop from the stack at then add the path in the answer list
 


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
