# [level 4] 5월 식품들의 총매출 조회하기 - 131117 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131117) 

### Approach
- Domain: There are multiple rows by same product_id in  food_order, food_order has the food_product foreign key which name is the product_id
- Impl: Use the where clause for getting the only data which is "2022-05".
        For getting total_sales group by the product_id by food_order.product_id and multiply by the product price

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
