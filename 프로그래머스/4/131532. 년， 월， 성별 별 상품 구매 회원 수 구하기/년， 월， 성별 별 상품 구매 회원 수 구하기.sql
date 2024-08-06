-- 코드를 입력하세요
-- Domain: Online sale에는 같은 회원의 아이디가 여러개 존재할 수 있다. 다만 동일한 날짜 회원 ID, 상품 ID는 한 개가 존재한다.
-- Impl : 년, 월, 성별로 상품을 구매한 회원 수를 구할 때, 같은 년와 월에 같은 회원의 ID는 제외되어야한다. 구매한 횟수가 아니기 때문이다. 따라서 online sales에서 회원으로 한 번 집계를 한 이후에 집계를 진행한다.


select year(sales_date)as year,month(sales_date) as month, gender, count(distinct os.user_id) as users
from user_info as ui inner join online_sale as os on ui.user_id = os.user_id
where gender is not null
group by 1,2,3
order by 1,2,3


# SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT O.USER_ID) AS USERS
# FROM USER_INFO I
# JOIN ONLINE_SALE O
# ON I.USER_ID = O.USER_ID
# WHERE GENDER IS NOT NULL
# GROUP BY 1,2,3
# ORDER BY 1,2,3;

