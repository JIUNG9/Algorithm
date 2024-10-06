-- 도메인 이해: history에는 동일한 car_id가 존재한다. window clause로 데이터를 filter해도 본문 select에서 또한 날짜를 filter 해줘야한다.
-- 대여 회수가 대여 시작일 기준 2022년 8월부터 10월까지 대여 횟수가 5회 이상인 자동차를 기준으로 해당 월별, 자동차 ID별 대여횟수를 출력하고, 특정 월의 총 대여 횟수가 0인 경우 결과에서 제외 정렬 기준은 월 오름차순, 차 id로 내림차순
with filter_data as(
    select car_id
    from car_rental_company_rental_history h
    where start_date between '2022-08-01' and '2022-10-31'
    group by car_id
    having count(*) >=5
)



select month(start_date) as month, h.car_id, count(history_id) as records
from filter_data f inner join car_rental_company_rental_history h on h.car_id = f.car_id
where start_date between '2022-08-01' and '2022-10-31'
group by month, car_id

having count(history_id) != 0
order by month asc, car_id desc
