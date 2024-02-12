# [level 2] JadenCase 문자열 만들기 - 12951 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12951) 

### Consideration


### Approach 
1.1 if the charAt(0) is the number do not change
1.2 else, change the charAt(0) to upper case
2. if charAt(i) is lowercase and i - 1 is equal to " ", change i to uppercase
3. if chartAt(i) is the uppercase and i - 1 is not equal to " " change i to lower case

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
