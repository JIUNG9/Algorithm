-- 코드를 입력하세요
select truncate(price,-4) as floor_price, count(*) as products
from product
group by floor_price
order by floor_price asc
