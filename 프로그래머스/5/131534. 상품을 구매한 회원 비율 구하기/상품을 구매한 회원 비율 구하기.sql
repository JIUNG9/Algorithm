-- 코드를 입력하세요
with get_member_joined_counter_at_2021 as(
    select count(*) as num
    from user_info
    where joined like "2021%"
)

, member_who_joined_at_2021 as(

    select user_id
    from user_info
    where joined like "2021%"

)


select YEAR(sales_date) as year, Month(sales_date) as month, count(distinct os.user_id) as purchased_users, round(count(distinct os.user_id)/num,1) as puchased_ratio
from member_who_joined_at_2021 as mw inner join online_sale as os on os.user_id = mw.user_id, get_member_joined_counter_at_2021
group by year,month



