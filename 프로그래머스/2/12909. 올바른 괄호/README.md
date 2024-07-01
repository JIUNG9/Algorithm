# [level 2] 올바른 괄호 - 12909 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12909) 

### Approach

- " '(' 문자로 열렸으면 반드시 짝지어서 ')'" This meant the order is matter and should save the state at data structure. for checking the Character is matched will use the "Stack"
- When the Character is '(' push, otherwise Character is ')' check the Stack there is '('  or the Character is not matched return false, when iterated all of Character, and there is Character '(' in Stack. The Character is not totally matched


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
