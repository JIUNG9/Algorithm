

with get_rental_at_least_5 as(

    select car_id
    from car_rental_company_rental_history
    where start_date >= '2022-08-01' and start_date <= '2022-10-31'
    group by car_id
    having count(history_id) >= 5

)

select month(start_date) as month, car_id, count(*) as records
from car_rental_company_rental_history
where car_id in (select car_id from get_rental_at_least_5) and month(start_date) between 8 and 10
group by 1,2
order by 1 asc,2 desc

    