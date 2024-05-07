# [level 3] 입국심사 - 43238 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43238) 

### Approach
* The input size is the 10billion. So can't solve with O(n) so decide to use the Binary Search
* should consider what is the left and right. -> left is the min value so this can be min "n" and min time for handling the for one person "1", so left value is 1 and right is the max value which means max value of "n" and the max time for handling for one person 10billion -> max of n * 10 billion(won't exceed the range of long type)




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
