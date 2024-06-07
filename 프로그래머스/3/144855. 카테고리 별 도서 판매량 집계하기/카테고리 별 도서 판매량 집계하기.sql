-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from book_sales as bs inner join book as b on bs.book_id = b.book_id
where sales_date like "2022-01%"
group by category
order by 1 asc
