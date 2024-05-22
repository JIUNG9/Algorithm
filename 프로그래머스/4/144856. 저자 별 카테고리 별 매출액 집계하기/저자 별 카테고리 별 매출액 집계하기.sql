-- 코드를 입력하세요
with get_author_name_with_book as(
    select b.*, a.author_name
    from book as b inner join author as a on b.author_id = a.author_id
)

# select *,sum(sales)
# from book as b inner join book_sales as bs on b.book_id = bs.book_id
# where author_id =1 and category LIKE "인문"
# group by b.book_id

select author_id, author_name, category,  sum(sales*price) as total_sales
from book_sales as bs inner join get_author_name_with_book as ab on bs.book_id = ab.book_id
where sales_date like "2022-01%"
group by ab.author_id, b.category
order by ab.author_id asc, b.category desc