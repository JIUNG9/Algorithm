-- 코드를 입력하세요
with get_rent_bigger_4 as (
    select car_id
    from car_rental_company_rental_history
    where month(start_date) between "8" and "10"
    group by car_id
    having count(car_id) >= 5
)



select month(start_date) as month, car_id, count(history_id) as records
from car_rental_company_rental_history
where car_id in (select car_id from get_rent_bigger_4) and (month(start_date) between "8" and "10")
group by month, car_id
having count(history_id) > 0
order by 1 asc, 2 desc