-- 코드를 입력하세요
# with get_rented_at_10_16 as (
#     select history_id, "대여중" as availability 
#     from car_rental_company_rental_history
#     where start_date <= "2022-10-16" and end_date >= "2022-10-16"

# )

# select distinct crc.car_id,
# case 
# when gr.availability like "대여중" then "대여중"
# else "대여 가능"
# end as availability
# from car_rental_company_rental_history as crc left join get_rented_at_10_16 as gr on gr.history_id = crc.history_id
# order by car_id desc

select car_id, 
    case when max(availability) = '1' then '대여중' 
    else '대여 가능' end as availability 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as A 
    left join (select history_id, '1' as availability from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date <= '2022-10-16' and end_date >= '2022-10-16') as B 
    on A.history_id = B.history_id 
group by car_id 
order by car_id desc