-- 코드를 입력하세요
-- 도메인 : history에는 같은 차량 번호가 존재할 수 있다. 빌릴 수 있는 차량을 조회해도
-- 같은 차량 넘버로 11월 1일이나 11월 30일에 빌릴 수도 있다.

WITH can_not_borrow AS (
    SELECT car_id
    FROM car_rental_company_rental_history
    WHERE NOT (start_date > '2022-11-30' OR end_date < '2022-11-01')
)

select car_id, crcc.car_type, 30 * round(daily_fee / 100 * (100 - discount_rate),0)as fee 
from car_rental_company_car as crcc inner join car_rental_company_discount_plan as crcd on crcc.car_type = crcd.car_type
where (crcc.car_type like 'SUV' or crcc.car_type like '세단') and duration_type like "30일%" and car_id not in (select car_id from can_not_borrow)
group by car_id
having fee >= 500000 and fee < 2000000
order by 3 desc, 2 asc, 1 desc