# [level 3] 업그레이드 할 수 없는 아이템 구하기 - 273712 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/273712) 

### Approach
1. The row which doesn't have the item_id from the equal table column name is parent_item_id. There is no matched same Id between two of column. can't upgrade item
2. So as solution can use the IN clause for getting can get upgraded items with window function


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
