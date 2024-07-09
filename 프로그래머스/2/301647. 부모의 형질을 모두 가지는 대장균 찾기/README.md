# [level 2] 부모의 형질을 모두 가지는 대장균 찾기 - 301647 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/301647) 

### Approach
- Logical: get the child.id, child genotype and parent getnotype from child parent_id and parent_id get the rows and filter the data which child contains all of the parent genotype

 - implementation

``` sql

select child.id, child genotype, parent.genotype
from child.parent_id = parent_id
where child.genotype & parent.genotype = parent.genotype

```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
