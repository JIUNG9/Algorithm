# [level 2] 올바른 괄호 - 12909 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12909) 

### Consideration
1. If the length of input is odd -> return false
2. This algorithm should have the statement else can't solve because the case of like this "(())()". Can't compare one to one from end to end. with n times of loop


### Approach
1. Use the stack for having statement.
2. Save the all elements from rear into Stack A
3. For start if Stack B is empty. push from Stack A
4. iterate. while a is not Empty. peek from B. and If the elemnts is '(' which is peeked from Stack B and the element is ')' from A. Pop both of elements from two Stack A and B else push element into Stack B from Stack A
5.1 If A stack is empty and B is not return false
5.2 If A stack is empty and B is empty return true



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
