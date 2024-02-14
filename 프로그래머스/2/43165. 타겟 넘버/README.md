# [level 2] 타겟 넘버 - 43165 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43165) 

### Approach

1. Need to check all of the cases -> decide to use the DFS
2. Need two dfs for considering the cases which is negative number


### DFS

1. Parameter => the number of iteration number, array, currentSum, targetNumber
2. Termination => when recursion is reached to length of input(hit: If current sum is equal to target add the answer++)
3. Iteration => increase the iteration number and add the current array index value,
 

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
