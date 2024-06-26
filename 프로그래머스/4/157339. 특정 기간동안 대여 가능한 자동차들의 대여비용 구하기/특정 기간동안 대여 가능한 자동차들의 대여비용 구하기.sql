-- 코드를 입력하세요
with get_specific_type as (
    select car_id, car_type, daily_fee
    from  car_rental_company_car
    where car_type like "세단" OR car_type like "SUV"
)
, filter_date as (
    select car_id
    from car_rental_company_rental_history
    where END_DATE > '2022-11-01'
)

 

select a.car_id, a.car_type, round(daily_fee * (1-(discount_rate* 0.01)),0) * 30 as fee
from get_specific_type as a inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as b on a.car_type = b.car_type
where duration_type like "30%" AND car_id NOT IN(select car_id from filter_date)
having fee >= 500000 AND fee < 2000000
order by fee desc, a.car_type asc, a.car_id desc