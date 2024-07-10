-- 코드를 입력하세요
select product_code , price * sum(sales_amount) as sales
from product as p inner join offline_sale as os on p.product_id = os.product_id
group by os.product_id
order by 2 desc,1 asc

