# [level 2] 물고기 종류 별 잡은 수 구하기 - 293257 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/293257) 

### Approach
-"FISH_NAME_INFO" table is linked with the fish_name. so group by fish_name will be worked instead of using fish_type. when using the fish_type as the aggregate function, can't select count(id), fish_name because fish_name is not aggregated by the fish_type

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
