-- 코드를 입력하세요
SELECT CAR_ID ,
CASE WHEN 
SUM(CASE WHEN '2022-10-16' between start_date and end_date then 1
ELSE 0 END) = 1 THEN '대여중'
ELSE '대여 가능' END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC