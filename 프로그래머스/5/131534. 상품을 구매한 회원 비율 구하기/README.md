# [level 5] 상품을 구매한 회원 비율 구하기 - 131534 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131534) 

### Approach
- Get the users which sign up at 2021 by using window function and get count also by using window function. can't bind with the first window and second. because the cnt and user_info columns are non-related.
- In online sale domain there can be the rows which has the same user_id so when do the count the number of user number which signing up at 2021 use the distinct keyword.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
