# with get_rent_over_5 as(
#     select car_id
#     from car_rental_company_rental_history
#     where start_date >= '2022-08-01' and end_date <= '2022-10-31'
#     group by car_id
#     having count(car_id) >= 5
# )
# -- 8, 9, 10 중에 car_id가 렌트한 흔적이 없다면 해당 car_id 포함하지 않는다, start_month가 3개가 아니라면 포함하지 않는다.
# select month(start_date) as month, car_id, count(*) as records
# from car_rental_company_rental_history h
# where h.car_id in (select * from get_rent_over_5)
# group by month(start_date)
# order by month, car_id desc

SELECT MONTH, CAR_ID, RECORDS
FROM (SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
      WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
      AND CAR_ID IN (SELECT CAR_ID
                 FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                 WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
                 GROUP BY 1
                 HAVING COUNT(*) >= 5)
      GROUP BY 1, 2) AS RENT
ORDER BY 1, 2 DESC;

