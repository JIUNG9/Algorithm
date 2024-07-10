# [level 2] 모음 사전 - 84512 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512) 

### Approach
- add the vowel with alphabetical order and when current String is reached to the length of 5, add the sequentional vowel String just right after added as suffix. when current String is equal with target return the current Counter
- Implementation: DFS 1. keep the order.(Not Permutation), 2. do not use the counter as the dfs parameter, It will be just increnmented by sequentional
  

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
