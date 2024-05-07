# [level 2] 디펜스 게임 - 142085 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/142085) 

### Approach
* The decision is matter when to use the God mode. So This problem is Greedy(can't be solved by brute force cuz of the input size)
* For using when the value is bigger than other values but not make use "n" as the negative value
* For handling above problem. Use the PrioirityQueue This assure the peek() value is the smallest value. so compare with current idx value and If current value Idx is bigger than queue.peek() value change. If n - peek() >= 0, else if n - currentValue >=0 procceed 


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
