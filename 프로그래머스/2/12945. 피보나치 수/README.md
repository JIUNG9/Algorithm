# [level 2] 피보나치 수 - 12945 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12945) 

### Approach

- Using recursive function for getting fibonacci number is inefficient. the memoization can be used as the approach(bottom up)
- The input of n is 2 <= n < 100,000 so the recurrence relation is applied. dp[i] = dp[i-2] + dp[i-1]


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
