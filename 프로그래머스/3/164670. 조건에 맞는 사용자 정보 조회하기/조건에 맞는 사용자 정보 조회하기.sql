-- 코드를 입력하세요
with over_post_3 as (
    select  writer_id
    from used_goods_board
    group by writer_id
    having count(*) >= 3
)

select distinct user_id, nickname, concat(city," ",street_address1," ",street_address2) as 전체주소,concat(LEFT(tlno,3),"-",substring(tlno,4,4),"-",right(tlno,4))as 전화번호
from used_goods_user as ugu inner join used_goods_board as ugb on ugu.user_id = ugb.writer_id
where writer_id IN (select writer_id from over_post_3)
order by user_id desc