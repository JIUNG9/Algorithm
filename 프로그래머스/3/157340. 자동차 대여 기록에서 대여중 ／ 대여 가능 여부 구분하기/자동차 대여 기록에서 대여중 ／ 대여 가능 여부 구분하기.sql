-- 코드를 입력하세요
-- 10월 16일에 대여 중이라는 것은 start_date가 10월 16일 보다 작거나 같고, end_date가 10월 16일보다 크거나 같은 것을 의미한다.
-- 도메인, 히스토리에는 같은 car_id가 여러 개 있을 수 있다. 즉 같은 아이디로 대여가 가능하는 차 목록이라도, 10월 16일에 해당 같은 차 아이디로 대여 기록이 있을 수 있다. 
with can_not_rent as(
    select car_id
    from car_rental_company_rental_history
    where start_date <= '2022-10-16' and end_date >= '2022-10-16'
)



select car_id, '대여중' as availability
from can_not_rent

union all

select distinct car_id , '대여 가능' as availability
from car_rental_company_rental_history
where car_id not in (select car_id from can_not_rent)
order by car_id desc

