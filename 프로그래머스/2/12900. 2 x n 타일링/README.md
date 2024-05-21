# [level 2] 2 x n 타일링 - 12900 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12900) 

How to approach this problem as dynamic programming
- when use the combination of this problem there will be out of range exception when over the 30ish number with factorial operation. already over the int range. even there is the remainder operation. So this meant find the rule and make a strep for reaching the answer(bottom-up), so apply the distributive low with dynamic programming gurantee not exceed the range of int

``` java
init() dp[0] = 1; dp[1] = 2;
proceed() while(before n) dp[i] = (dp[i-2] + dp[i-1]) % (enough big number for not exceeding int range) 
```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
