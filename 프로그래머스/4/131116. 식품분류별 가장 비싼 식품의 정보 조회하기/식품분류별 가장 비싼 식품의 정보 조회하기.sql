-- 코드를 입력하세요

with get_max_price_with_id as (
    select product_id, dense_rank() over(partition by category order by price desc) as rnk
    from food_product
)


# select *
# from get_max_price_with_id




select category, price as max_price, product_name
from food_product as fp inner join get_max_price_with_id as max_price on max_price.product_id = fp.product_id
where (category like "과자" or category like "국" or category like "김치" or category like "식용유") and rnk = 1
order by 2 desc