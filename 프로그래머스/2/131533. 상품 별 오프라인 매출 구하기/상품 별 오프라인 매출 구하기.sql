-- 코드를 입력하세요
-- Domain: 
select product_code, sum(sales_amount) * price as sales
from product p inner join offline_sale os on p.product_id = os.product_id
group by os.product_id
order by 2 desc, 1 asc