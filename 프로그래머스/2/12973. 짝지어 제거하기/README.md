# [level 2] 짝지어 제거하기 - 12973 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12973) 

### Consideration
1. Fail Condition
- when StackB which is pushed with not sequentionally matched from stackA and Two sequentional charater are not matched. 
- when stackB  with previous one has the left element(this mean the left element does not have the matched pair)

### Approach
1. can't use the n^2 because input size is 1,000,000  so use the stack
2. Make the two stacks. for saving all elements into A and save not sequentially matched element into B
3. Check the stackB All left elements has the pair. if not return 0 else return 1


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
