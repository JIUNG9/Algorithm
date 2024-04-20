-- 코드를 작성해주세요
-- 년도 별 가장 큰 값의 Size_of_colony를 구하여 그 값과 size of Colony를 뺀 값을
-- 연도 별로 정렬
-- window function -> re-filter with current context

SELECT 
YEAR(DIFFERENTIATION_DATE) AS YEAR,
MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY AS YEAR_DEV,
ID
FROM ECOLI_DATA
ORDER BY YEAR, YEAR_DEV