-- 코드를 입력하세요
-- Impl: 식품을 grouping 하여, 가장 비싼 가격의 분류 가격, 이름의 순위를 얻어(dense rank),<> 식품 분류의 1등 상품의 국, 과자, 김치, 식용유만을 출력하고, 가격을 기준으로 DESC한다.

with get_rnk as (

    select category, price, product_name, dense_rank() over(partition by category order by price desc) as rnk 
    from food_product fp
    where fp.category like '과자' or fp.category like '국' or fp.category like '김치' or fp.category like '식용유'

)



select fp.category, fp.price as max_price, fp.product_name
from food_product as fp inner join get_rnk as gr on fp.product_name = gr.product_name
where rnk = 1
order by 2 desc