-- 코드를 입력하세요
-- Domain: There are multiple rows by same product_id in  food_order, food_order has the food_product foreign key which name is the product_id
-- Impl: 
-- 1.Use the where clause for getting the only data which is "2022-05"
-- 2. For getting total_sales group by the product_id by food_order.product_id and multiply by the product price



select fo.product_id, product_name, sum(amount) * price as total_sales
from food_order as fo inner join food_product as fp on fo.product_id = fp.product_id
where produce_date like "2022-05%"
group by fo.product_id
order by total_sales desc, 1 asc