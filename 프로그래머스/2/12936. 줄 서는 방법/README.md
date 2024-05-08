# [level 2] 줄 서는 방법 - 12936 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12936) 

### Approach
1. can't use the dfs. because 20! factorial is over the 1 billion
2. Find the rule of this problem. The rule is the value is k divided by (n-i-1)! , and next value is remainded by (n-i-1)! (i is the incremental value while loop)
3. But the problem is whene the next value is '0' 0 divided the value anything will be Arithemetic Exception. and indicated always 0. so use the List (which is 1 to n) data structure. when the value is '0' add the list.get(0) and remove list.remove(0) assure won't be occured the Arithemetic exception and there is another at 0 index value which is right before inserted in the answer array. 

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
