# [level 2] 모음 사전 - 84512 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512) 

### Approach
- DFS:
   1. What should be in stack -> the current String
   2. permutation or having the statement(just sequentional) -> not a permutation just sequentionally check the current String
      
- Start from empty String when current String is equal with the target String set the current counter as answer. If the current String is reached to the number of 5 stop appending the String as the suffix. just append the next of vowel value(remove the last one first). and add the counter, when append the new String as the suffix


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
