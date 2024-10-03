-- 코드를 입력하세요
-- 상품 코드 별 매출 내역

select product_code, sum(sales_amount) * price as sales
from offline_sale as os inner join product p on p.product_id = os.product_id
group by os.product_id
order by 2 desc, 1