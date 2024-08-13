# [level 2] 줄 서는 방법 - 12936 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12936) 
### Approach 
- when set the first person there are 3 cases, and next person is 2 cases, and the left person is only 1 case. so total 3 * 2 * 1. for getting the **sequential** number  “5”. divide by 2, and get the remainder with remainder divide by 1, and the left one is the last person

### Implementation
- “k” is started from the 1. so make this change to start from the 0. “k—”, and the problem is when two people are remained, divide by 1, and divide by 0 can’t make it. so just divide by the number from the n -1 and to 0. followed by this quote  “the left one is the last person”  so use the data-structure can remove → ArrayList , and not divide by 0 just by 1. when the second person number is decided → the remainder can be “0” , “1” with that result  divide by 1 will be as always ‘0’


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
