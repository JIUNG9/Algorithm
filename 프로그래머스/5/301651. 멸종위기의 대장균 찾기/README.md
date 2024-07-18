# [level 5] 멸종위기의 대장균 찾기 - 301651 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/301651) 

### Approach
-Logical: Get the parent_id and genration through joining with parent's id and child's parent_id, through the data which have genration and parent's id, get the parent_id and counter which the number of parent doesn't have the child by the generation.

- Impl: 
and use the not null keyword at where clause. because when there is the null value there is no way to be sure that the null value is not the value should be tested


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
