# [level 2] 땅따먹기 - 12913 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12913) 

## Approach
* Input size is 100,000 but should check all elements by step by step
* bottom-up. -> Use the DP
* dp[i][j] = dp[i-1][j] + max(max means the max vlaue in current width with excluding the j idx)



 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
