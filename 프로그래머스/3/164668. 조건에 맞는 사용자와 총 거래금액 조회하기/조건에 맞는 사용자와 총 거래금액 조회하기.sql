-- 코드를 입력하세요
select user_id, nickname, sum(price) as total_sales
from used_goods_board as ugb inner join used_goods_user as ugu on ugu.user_id = ugb.writer_id
where status like "DONE"
group by user_id
having sum(price) >= 700000
order by 3 asc