# [level 4] 식품분류별 가장 비싼 식품의 정보 조회하기 - 131116 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131116) 

### Approach
- Get the most expensive by the category this meant use the dense_rank function. Use the "select category and dense_rank over(partition by category order by price desc)" the category is related with
  dense_rank function. and append the product_id at select clause is also ok. because "product_id" is dependent on the "category"


``` sql

with get_most_expensive_by_cat as (

        select product_id, category, dense_rank() over(partition by category order by price desc)
        from product

)

        --- use the inner join by product_id and where clause rnk = 1 and the other condition

```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
