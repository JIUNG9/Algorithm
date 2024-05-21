# [level 3] 물고기 종류 별 대어 찾기 - 293261 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/293261) 



### Missed point

1. Why I can't use the id keyword at select clause When I use the group by keyword  by fish_type
``` sql
with get_max as (
    select id,fish_type, max(length) as length
    from fish_info
    group by fish_type

)

- explanation: max() keyword is the result of the fish_type otherwise the id from the fish_info is not related at all by fish max of length. so I couldn't use the id keyword at select clause

2. The difference between two of things, why two of things make diffrenet result. 
where fi.length IN (select length from get_max) vs where (fi.length, fish_type) IN (select fish_type, length from get_max)

Logically only where clause with length can't get the type of fish. If length is equal with another fish_type. The select clause can't recognize the result.
```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
