-- 코드를 입력하세요
select fo.product_id, product_name, sum(amount) * price as total_sales
from food_order as fo join food_product as fp on fp.product_id = fo.product_id
where produce_date like "2022-05%"
group by fo.product_id
order by total_sales desc, product_id asc

