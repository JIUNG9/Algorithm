# [level 4] 년, 월, 성별 별 상품 구매 회원 수 구하기 - 131532 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131532) 

### Approach

- Understand the domain: The order_sales has the multiple user_id. so join with user_id has the multiple duplicated row.
- when Gender is not null, Get the data from the user_id by two of tables(by using join clause) and the data which needs "THE NUMBER OF USER WHICH BUY AT YEAR,MONTH, GENDER". So do not count the same user_id by year, month, gender. Right clause for getting the number of user_id by year, month, gender count(distinct(user_id))

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
