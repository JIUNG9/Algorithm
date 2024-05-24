# [level 2] 모음 사전 - 84512 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512) 

### Approach

- key point: the counter of which is pushed into stack should not be in stack(method parameter), should be heap statement
- when target is equal with currentStr make the answer as counter else when currentLen is under 5, proceed the dfs just concat the vowel at current iterating vowel as suffix.


```java
dfs(currentStr, targetStr)
if(currentStr.equals(targetStr) answer = currentCounter
        for(iterating all vowels)
                if(currentStr.length() < 5) dfs(currentStr + current vowel, target)

```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
