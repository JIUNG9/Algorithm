# [level 2] 땅따먹기 - 12913 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12913) 

### Approach
- consideration: The input size of row is about 100,000 -> can't use the dfs approach with this problem, approach with the down to top
- Impl: the current int[row][column] value will be previous row's max value which has not the same column index. so recurrence relation will be 'dp[i][j] = previous row's max value but column is not j+ land[i][j]

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
