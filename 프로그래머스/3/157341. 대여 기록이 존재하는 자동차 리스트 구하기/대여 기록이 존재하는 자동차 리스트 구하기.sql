-- 코드를 입력하세요

with rent_during_10 as (
    select distinct car_id
    from car_rental_company_rental_history
    where start_date >= "2022-10-01"
)


select distinct crcc.car_id
from car_rental_company_car as crcc inner join car_rental_company_rental_history as crcrh on crcc.car_id = crcrh.car_id
where crcc.car_id IN(select car_id from rent_during_10) AND crcc.car_type like "세단"
order by crcc.car_id desc