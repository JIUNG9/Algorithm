-- 코드를 입력하세요
# select month(start_date) as month , car_id, count(car_id) as records
# from car_rental_company_rental_history
# where start_date >= '2022-08-01' and end_date <= '2022-10-31'
# group by 1,2 
# having records >= 5 and records > 0
# order by 1 asc, 2 desc

# with get_rental_at_least_5 as(

#     select car_id
#     from car_rental_company_rental_history
#     where start_date >= '2022-08-01' and start_date <= '2022-10-31'
#     group by car_id
#     having count(car_id) >= 5

# )

# select month(start_date) as month, car_id, count(*) as records
# from car_rental_company_rental_history
# where car_id in (select car_id from get_rental_at_least_5)
# group by 1,2
# order by 1,2 desc

select month(start_date)as MONTH,car_id as CAR_ID,count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(start_date) between 8 and 10  and
car_id in 
(
select car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(start_date) between 8 and 10  
group by car_id
having count(*) >4
)
group by car_id,month
order by month asc ,car_id desc