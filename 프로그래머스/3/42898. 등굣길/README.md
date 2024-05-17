# [level 3] 등굣길 - 42898 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42898) 

### Approach
- Set the padding (
  1. Set the padding makes doesn't have to move puddle location)
  2. Set the padding makes doesn't have to init for dynamic programming let's say there is puddle at first width and length should be init as 0 before puddle is met otherwise set the puddle location -1 and after then should be 0. but when set the padding at first width and first length gurantee when puddle is met the rear value of puddle will be -1. and this will be applied with optimization approach
 

``` java

  for (int i = 1; i < yLen; i++) {
      for (int j = 1; j < xLen; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        if (dp[i][j] == -1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%1000000007;
        }
      }
    }

```
- explain: when there is the start position just pass(for start weight as 0), and apply the optimization approach





> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
