-- 코드를 입력하세요
-- concat(tlno.substring(0,3) ,'-' tlno.substring(3,7), '-',tlno.substring(8,11)) as 전화번호
select user_id, nickname,concat(city, ' ' ,street_address1, ' ', street_address2) as 전체주소, concat(substring(tlno,1,3) , '-' , substring(tlno,4,4) , '-' , substring(tlno,8,4)) as 전화번호
from used_goods_board b inner join used_goods_user ug on b.writer_id = ug.user_id
group by b.writer_id
having count(*) >=3
order by 1 desc