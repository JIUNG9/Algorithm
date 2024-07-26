-- 코드를 입력하세요
with get_product_id_max_price as (
    select product_id, dense_rank() over(partition by category order by price desc) as rnk
    from food_product
)

select category, price as max_price, product_name
from get_product_id_max_price as gpmp inner join food_product fp on fp.product_id = gpmp.product_id
where (category like '국' or category like '식용유' or category like '김치' or category like '과자') and rnk = 1
order by 2 desc