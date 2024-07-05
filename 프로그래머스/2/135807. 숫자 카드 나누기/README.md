# [level 2] 숫자 카드 나누기 - 135807 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/135807) 

### Approach
- get the common divisor from each of input array from biggest the value to smallest value from all of the common divisor elements, when one side of all array elements remaider value by common divisor is 0 otherwise another part of array elements remainder value by common divisor counter is equal with the number of array elements that common divisor is answer. when after iterating all of the common divisor, and there is no answer the answer is 0
- when considering all of the common divisor from the 1,000,000 (input) it won't be worked So get minimum value from the array and get common divisor from that will be worked
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
