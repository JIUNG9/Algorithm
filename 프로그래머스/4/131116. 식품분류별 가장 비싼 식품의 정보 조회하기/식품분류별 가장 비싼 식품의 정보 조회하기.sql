with get_most_expensive as(
    select product_id, category, dense_rank() over(partition by category order by price desc) as rnk
    from food_product
)

# select *
# from get_most_expensive


select fp.category, price as max_price , product_name
from food_product as fp inner join get_most_expensive as gme on fp.product_id = gme.product_id
where (fp.category like "과자" or fp.category like "김치"  or fp.category like "식용유"  or fp.category like "국") and rnk = 1
order by 2 desc


