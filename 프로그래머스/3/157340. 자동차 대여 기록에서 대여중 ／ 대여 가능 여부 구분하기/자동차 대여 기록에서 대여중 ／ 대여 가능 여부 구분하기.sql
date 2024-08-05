WITH rented AS (
    SELECT DISTINCT car_id
    FROM car_rental_company_rental_history
    WHERE '2022-10-16' BETWEEN start_date AND end_date
        OR end_date = '2022-10-16'
)

SELECT car_id, '대여중' AS AVAILABILITY
FROM rented

UNION

SELECT DISTINCT car_id, '대여 가능' AS AVAILABILITY
FROM car_rental_company_rental_history
WHERE car_id NOT IN (SELECT car_id FROM rented)

ORDER BY car_id DESC;
