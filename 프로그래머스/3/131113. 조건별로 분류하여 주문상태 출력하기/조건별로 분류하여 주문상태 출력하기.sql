-- 코드를 입력하세요
select order_id, product_id, date_format(out_date,"%Y-%m-%d"), 
case when OUT_DATE <= "2022-05-01" then "출고완료"
when OUT_DATE > "2022-05-01" then "출고대기"
when OUT_DATE IS NULL  then '출고미정' end as 출고여부
from food_order
order by order_id
