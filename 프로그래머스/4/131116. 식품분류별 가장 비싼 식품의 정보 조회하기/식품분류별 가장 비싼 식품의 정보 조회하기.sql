-- 코드를 입력하세요
with get_most_expensive as(
    select product_id, category, dense_rank() over(partition by category order by price desc) as rnk
    from food_product fp
)

# select *
# from get_most_expensive

select category,price as max_price, product_name
from food_product fp
where fp.product_id in (select product_id from get_most_expensive where rnk = 1) and (category like '국' or category like '과자' or category like '김치' or category like '식용유')
order by max_price desc
