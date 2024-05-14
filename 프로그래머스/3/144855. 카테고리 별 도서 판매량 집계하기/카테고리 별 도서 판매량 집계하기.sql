-- 코드를 입력하세요

WITH AT_JAN_SALES AS (
    SELECT BOOK_ID, SALES
   FROM BOOK_SALES
    WHERE SALES_DATE LIKE "2022-01%"

)

SELECT  B.CATEGORY, SUM(SALES) TOTAL_SALES
FROM BOOK AS B  JOIN AT_JAN_SALES AS S ON B.BOOK_ID = S.BOOK_ID
GROUP BY CATEGORY
ORDER BY 1