-- 코드를 입력하세요
-- Domain: Online Sale에는 같은 유저 아이디가 존재할 수 있다.
-- 2021년에 가입한 전체의 유저의 회원 아이디를 기준으로 구매한 유저의 수와 2021년의 가입한 전체 회원의 수와 구매한 사람의 비율을 구하여라 online sale에 존재하는 유저 아이디가 여러 개라면 한 개만 포함하여 고려한다.비율은 소수 두 번째 자리에서 반올림하고 년 별, 월 별을 구하고 년, 월 기준으로 오름차순한다.


with get_the_number_user_sign_up_2021 as (
    select user_id
    from user_info
    where year(joined) like '2021'
)

-- see the difference between two of that  round(count(distinct os.user_id) /count(us.user_id),1)as PUCHASED_RATIO vs  round(count(distinct os.user_id) /(select count(user_id) from get_the_number_user_sign_up_2021) ,1) as PUCHASED_RATIO. The first one means the number of the user which buy the products at 2021 which is grouped by the year and month. otherwsie second one is not. Just the number of user who signed up at 2021


select year(sales_date)as YEAR, month(sales_date)as MONTH , count(distinct os.user_id) as PURCHASED_USERS, round(count(distinct os.user_id) /(select count(user_id) from get_the_number_user_sign_up_2021),1)as PUCHASED_RATIO
from  get_the_number_user_sign_up_2021 as us inner join online_sale as os on us.user_id = os.user_id
group by 1,2
order by 1,2


# WITH JOINED2021 AS (
#     SELECT  *
#     FROM    USER_INFO
#     WHERE   YEAR(JOINED) = '2021'
# )

# SELECT      YEAR(B.SALES_DATE) YEAR, MONTH(B.SALES_DATE) MONTH,
#             COUNT(DISTINCT B.USER_ID) PURCHASED_USERS,
#             ROUND(COUNT(DISTINCT B.USER_ID) / (SELECT COUNT(*) FROM JOINED2021), 1) PURCHASED_RATIO
# FROM        JOINED2021 A
# INNER JOIN  ONLINE_SALE B ON A.USER_ID = B.USER_ID
# GROUP BY    YEAR, MONTH
# ORDER BY    YEAR, MONTH