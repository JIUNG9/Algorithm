# [level 2] 숫자 변환하기 - 154538 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/154538) 

### Approach
1. Top-down (DFS)
2. Down-top (BFS)

### Big O analysis
- DFS : when x is '1' and y is '100,000', n = 1. the depth of (+) operation is O(100,000) and * 2 operation will be log(100,000) also * 3 operation log(100,000) so 14 * 100,000 for fisrt DFS and when first DFS is pop from the stack when next *2 operation is pushed into stack also 99,998 times of + operation will be occured, so O(99,998) * 14, and next one is O(99,996) * 14. and consecutive operation will be SUM(O(100,000 - 2*50,000) * 14) this is only applied second DFS operation If apply the third DFS which multiply 3. need more times

- BFS : Down-Top approach
  * This will gurantee the shortest path to be from y to x

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
