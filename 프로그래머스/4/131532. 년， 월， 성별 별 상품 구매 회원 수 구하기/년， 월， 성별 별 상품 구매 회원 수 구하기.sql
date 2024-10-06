-- 코드를 입력하세요
-- 도메인: 유저는 같은 년, 월에 여러 번 상품을 구매할 수 있어 년, 월, 성별로 집계하여도 여러 개의 row가 나올 수 있다. 

select year(sales_date) as year, month(sales_date) as month, gender, count(distinct os.user_id) as users
from user_info u inner join online_sale os on u.user_id = os.user_id
group by 1,2,3
having gender is not null
order by year, month, gender