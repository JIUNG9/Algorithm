# -- 코드를 입력하세요
# -- 2021년에 가입한 회원id를 기준으로 조인하여, online_sale을 회원 id로 집계한다. 이를 통해 한 회원이 여러 차례의 상품을 구매한 것을 방지할 수 있다.(online_sale에는 한 개 이상의 회원 아이디가 존재할 수 있다.), 같은 년, 월에 회원이 두 번 들어가면 안 된다.

# with get_user_2021 as(
#     select user_id
#     from user_info u
#     where year(u.joined) = '2021'
# )
# , get_total_cnt as(
#     select count(user_id) as cnt
#     from user_info u
#     where year(u.joined) = '2021'
# )





# select year(sales_date) as year, month(sales_date) as month, count(distinct os.user_id) as purchased_users, round((count(distinct(os.user_id))/cnt) ,1) as puchased_ratio
# from  get_user_2021 gu inner join online_sale os , get_total_cnt
# group by 1,2
# order by 1,2

SELECT
    YEAR(SALES_DATE) AS YEAR,
    MONTH(SALES_DATE) AS MONTH,
    COUNT(DISTINCT USER_ID) AS PURCHASED_USERS,
    ROUND(COUNT(DISTINCT USER_ID)/(SELECT COUNT(USER_ID)
     FROM USER_INFO
     WHERE YEAR(JOINED) = 2021), 1) AS PURCHASED_RATIO
FROM USER_INFO INNER JOIN ONLINE_SALE USING(USER_ID)
WHERE YEAR(JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR ASC, MONTH ASC;