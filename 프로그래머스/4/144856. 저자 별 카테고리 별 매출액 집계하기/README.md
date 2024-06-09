# [level 4] 저자 별 카테고리 별 매출액 집계하기 - 144856 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/144856) 

### Approach
- Get the total_sales by author and category.
- The difference between "sum(sales) * price" and sum(sales * price), See the select clause there are author_id, and author_name, category, and total_sales. author_name is concluded by the author_id and category and total_sales is the result by aggregate function result. so all select clause is related with the aggregate function. If use sum(sales) * price. price can be non-related by aggregate function. but it should be. so use the sum(sales * price)



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
