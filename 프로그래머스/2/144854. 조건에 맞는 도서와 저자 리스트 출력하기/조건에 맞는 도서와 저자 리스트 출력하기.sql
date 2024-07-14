-- 코드를 입력하세요
select book_id, author_name, date_format(published_date,"%Y-%m-%d") as published_date
from book as b inner join author as a on b.author_id = a.author_id
where category like "경제"
order by 3 asc