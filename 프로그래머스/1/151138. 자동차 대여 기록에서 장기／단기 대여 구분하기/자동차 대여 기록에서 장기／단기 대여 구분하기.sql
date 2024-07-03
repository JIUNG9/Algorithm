-- 코드를 입력하세요
# select history_id, car_id, start_date, end_date,
# case 
# when datediff(end_date,start_date) >= 29 then '장기 대여'
# else '단기 대여'
# end as rent_type
# from car_rental_company_rental_history
# where start_date like "2022-09%"
# order by 1 desc

SELECT  HISTORY_ID
        ,CAR_ID
        ,DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE
        ,DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE
        ,CASE
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 30 THEN '장기 대여'
        ELSE '단기 대여' END AS RENT_TYPE
  FROM  CAR_RENTAL_COMPANY_RENTAL_HISTORY
 WHERE  YEAR(START_DATE) = 2022 AND MONTH(START_DATE) = 9
 ORDER
    BY  HISTORY_ID DESC