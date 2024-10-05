-- 코드를 입력하세요
select a.author_id,author_name, category, sum(sales * price) as total_sales
from book_sales bs inner join book b on b.book_id = bs.book_id inner join author a on b.author_id = a.author_id
where sales_date like '2022-01%'
group by 1,3
order by author_id asc, category desc