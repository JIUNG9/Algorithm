# [level 3] 징검다리 건너기 - 64062 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/64062) 

### Approach
- Input size: input size is 2 billion. so over the O(N) time complexity won't be satisfied the condition of this problem.
- For handling the input size use the two pointer. which time complexity is O(log N)
- The value of the element is the pointer. so initial left value is 0 and right is the max value of the array
- if the number of sequentional value subtract from the mid value over the K size this means can't jump. can't go through. otherwise it can go
- when can go. increase the mid value so update the left. otherwise update the right for decreasing the mid value.


 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
