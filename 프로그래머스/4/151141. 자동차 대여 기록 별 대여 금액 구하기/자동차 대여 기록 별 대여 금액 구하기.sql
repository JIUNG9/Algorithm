-- 코드를 입력하세요
-- company car에서 car_type이 트럭인 car_id만을 가지는 history_id를 얻고 해당 기간에 따른 할인률을 기간 별로 CAR_RENTAL_COMPANY_DISCOUNT_PLAN에서 얻어 history별로 할인을 적용하여(대여일수 * 100 - discountRate / 100) fee를 구한다.

SELECT 
    h.history_id, 
    CASE 
        -- For rentals of 90 days or more
        WHEN TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1 >= 90 THEN 
            ROUND(c.daily_fee * (TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1) * 
            (100 - (SELECT discount_rate 
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                    WHERE DURATION_TYPE = '90일 이상' 
                    AND car_type = '트럭')) / 100, 0)
        
        -- For rentals of 30 to 89 days
        WHEN TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1 >= 30 THEN 
            ROUND(c.daily_fee * (TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1) * 
            (100 - (SELECT discount_rate 
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                    WHERE DURATION_TYPE = '30일 이상' 
                    AND car_type = '트럭')) / 100, 0)
        
        -- For rentals of 7 to 29 days
        WHEN TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1 >= 7 THEN 
            ROUND(c.daily_fee * (TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1) * 
            (100 - (SELECT discount_rate 
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                    WHERE DURATION_TYPE = '7일 이상' 
                    AND car_type = '트럭')) / 100, 0)
        
        -- For rentals of less than 7 days (no discount)
        ELSE ROUND(c.daily_fee * (TO_DAYS(h.end_date) - TO_DAYS(h.start_date) + 1), 0)
    END AS fee
FROM 
    car_rental_company_car c
INNER JOIN 
    car_rental_company_rental_history h 
    ON c.car_id = h.car_id
WHERE 
    c.car_type = '트럭'
ORDER BY 
    fee DESC, h.history_id DESC;
