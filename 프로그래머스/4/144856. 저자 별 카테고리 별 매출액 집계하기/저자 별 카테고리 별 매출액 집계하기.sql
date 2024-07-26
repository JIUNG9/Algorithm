-- Domain : There can be over a couple of books by same author, and there is same book_id in book_sales
-- Impl:
-- 북세일즈에서 book_id로 집계하여 총 sales를 구하고 해당 책의 가격을 곱하여 책 별, sales_price를 구한다.
-- 이후 위의 데이터에서 책 아이디를 통해 카테고리와 author_id로 집계하여 sales_price의 sum을 구한다. 이는 category별, author_id별 책의 세일즈 프라이스 총 합이다.

with get_sales_price_by_book as(

    select bs.book_id, sum(sales) * price as sales_price
    from book_sales as bs inner join book as b on bs.book_id = b.book_id
    where sales_date like "2022-01%"
    group by bs.book_id

)
select a.author_id, a.author_name, category, sum(sales_price) as total_sales
from get_sales_price_by_book as bs inner join book as b on bs.book_id = b.book_id inner join author as a on a.author_id = b.author_id
group by 1,3
order by 1 asc, 3 desc




