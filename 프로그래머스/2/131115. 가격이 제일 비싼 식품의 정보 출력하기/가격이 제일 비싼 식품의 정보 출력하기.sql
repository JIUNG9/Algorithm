-- 코드를 입력하세요
with get_rnk as (
    SELECT PRODUCT_ID, dense_rank() over(order by price desc) as rnk
    from food_product
)

select fp.product_id, product_name, product_cd, category,price
from get_rnk as gr inner join food_product fp on gr.product_id = fp.product_id
where rnk = 1

# select *
# from get_rnk