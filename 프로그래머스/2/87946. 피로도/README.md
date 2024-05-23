# [level 2] 피로도 - 87946 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87946) 

### Approach
- The input size is less than 8. so This is brute force search can be possible to approach
- logically, when current stamina is bigger or equal with requirement of entering dungeons, and not visited before. visit. and when visit, count the the number of visited any of dungeons

``` java

public void dfs(boolean[] visited, int counter, int[][] d, currentStamina)
for(i; i < len; i++)
        if(!visited[i] && currentStamina >= requirementOfStamina)
                visited[i] = true;
                dfs(visited, counter+1, d, currentStamina - usedStamina)
                visited[i] = false

```
  

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
