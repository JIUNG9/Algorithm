
-- 도메인 이해 -> book_sales에는 여러 개의 book_id가 존재할 수 있다.
with get_sales_by_book as(
    select book_id,sales_date, sum(sales) as sales
    from book_sales
    where sales_date like "2022-01%"
    group by book_id
)

select category, sum(sales) as total_sales
from book b inner join get_sales_by_book bs on b.book_id = bs.book_id
where sales_date like "2022-01%"
group by category
order by 1 asc