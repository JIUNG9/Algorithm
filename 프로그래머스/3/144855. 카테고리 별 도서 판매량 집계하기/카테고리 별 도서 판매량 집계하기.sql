-- 코드를 입력하세요
select category, sum(sales) as total_sales
from book as b inner join book_sales as bs on b.book_id = bs.book_id
where sales_date like "2022-01%"
group by category
order by 1 asc