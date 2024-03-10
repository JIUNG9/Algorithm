# [level 2] 모음 사전 - 84512 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512) 

``` java
 public void dfs(String target, String current, int len, char[] vowels) {
    if (target.equals(current)) {
      answer = list.size();
    }

    if (current.length() != len) {
      for (int i = 0; i < 5; i++) {
        list.add(current + vowels[i]);
        dfs(target, current + vowels[i], len, vowels);
      }

    }
```
### Approach
The input String length is under 5 so can Brute Force Search can be used.
otherwise using the contuer at the parameter, also stacked into stack area.
For instance If I use the counter variable with dfs "AAAAU" is counter 9 and when "AAAA" is out from the stack
the counter is 4. But it should be 10.

For this Using the List. List is in the heap area. so can handle this problem

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
