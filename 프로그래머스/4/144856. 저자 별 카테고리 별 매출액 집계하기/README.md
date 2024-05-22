# [level 4] 저자 별 카테고리 별 매출액 집계하기 - 144856 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/144856) 

The mis-concept about aggregate function

``` sql
sum(price * sales)
group by author_id, category
```

``` sql
sum(sales) * price
group by author_id, category
```
Those sql block difference is aggreagted sum of sales multiply the price about each row. let's say there are two of rows which has the same authro_id and category. and each of row has 10, 5 sales. and the result will be -> 15 * price, 15 * price. there will be two of rows about sum(sales) * price. 
The thing is the aggregate function is not related with related row. so sum(sales * price) will be the result by author_id and category


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
