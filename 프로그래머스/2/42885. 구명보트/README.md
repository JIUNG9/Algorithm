# [level 2] 구명보트 - 42885 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42885) 

### Approach
- After sort the array. Why don't have to find min idx value from the start idx right before the sum is over the limit. because even matched with those of things. the sum with second of heaviest weight or less and the smallest weight as always smaller than the (smallest weight + heaviest weight). so just use the two pointer is the right approach but when the two pointer is equal, just add the one boat and return the number of boat.


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
