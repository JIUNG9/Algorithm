# [level 4] 입양 시각 구하기(2) - 59413 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59413) 

### Approach
- Order by the hour with ascending order. and count the number of animal_id


### Impl
#### Missed point
- Just order by the hour with ascending order. can't get the hour which is not existed at the table
- Declare the recursive function : when declaring the recursive function add the prefix which name is recursivce at the window function, and init the initial value, and use the union all or union if duplicated is allowed , then select the value of init value with appendix and append the from clause with the function name at last append the where clause
- Recursive function where clause : when where claus is satisfied the recursive function will be iterated. so hour < 23 is right choice
- count with asterisk -> when do the right join by hour table(recursive table) and do the count(*) will return the 1 even the data is not existed from the animal_outs because there is the row of by the hour, so count(animal_id) will be right choice in here

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
