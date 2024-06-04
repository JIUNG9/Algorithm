-- 코드를 입력하세요
# select month(start_date) as month, car_id, count(car_id) as records
# from car_rental_company_rental_history as c
# where start_date between "2022-08-01" and "2022-10-31"
# group by car_id
# having count(car_id) >= 5
# order by 1 asc, 2 desc


SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(*) COUNT
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) BETWEEN 8 AND 10
AND CAR_ID IN (SELECT CAR_ID
               FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
               WHERE MONTH(START_DATE) BETWEEN 8 AND 10
               GROUP BY CAR_ID
               HAVING COUNT(*) > 4)
GROUP BY CAR_ID, MONTH(START_DATE)
ORDER BY MONTH ASC, CAR_ID DESC;