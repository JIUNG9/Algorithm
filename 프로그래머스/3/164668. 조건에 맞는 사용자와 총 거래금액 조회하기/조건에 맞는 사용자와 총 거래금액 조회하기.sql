-- 코드를 입력하세요
-- 테이블에서 DONE인 상태의 상품의 가격의 총합이 70만원 이상인 사람의 회원ID, 닉네임, 총거래금액 조회
select user_id, nickname,  sum(price) as total_sales
from used_goods_user u inner join used_goods_board b on b.writer_id = u.user_id
where status like "DONE"
group by user_id
having total_sales >= 700000
order by total_sales asc