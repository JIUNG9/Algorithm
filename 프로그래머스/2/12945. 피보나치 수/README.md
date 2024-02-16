# [level 2] 피보나치 수 - 12945 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12945) 

### Consideration
1. can't use the recursion. => the input can be 100,000. If use the recursion The time complexity will be at least 100,000^2 for(fibo(n-1))
2. consider the stack over flow. the the max value of int. is 2^32. and stack over flow can be occured while proccedding for loop.
3. so at last I consider do modular operation. (a+b) % 1234567.


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
