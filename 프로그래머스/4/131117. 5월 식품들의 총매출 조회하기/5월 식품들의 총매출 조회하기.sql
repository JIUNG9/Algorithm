-- 코드를 입력하세요
select fo.product_id, product_name,sum(amount) * price as total_sales
from food_order as fo inner join food_product as fp on fo.product_id = fp.product_id
where fo.produce_date like "2022-05%"
group by fo.product_id
order by 3 desc, 1