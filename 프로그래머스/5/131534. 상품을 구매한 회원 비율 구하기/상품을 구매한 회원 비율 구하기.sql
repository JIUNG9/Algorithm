-- 코드를 입력하세요
with sign_up_at_2021 as (

    select *
    from user_info
    where year(joined) = 2021
)

, count_2021 as (
    select count(*) as cnt
    from user_info
    where year(joined) = 2021
)

select year(sales_date) as year, month(sales_date) as month, count(distinct su.user_id)  as purchased_users, round((count(distinct su.user_id)/cnt) ,1) as puchased_ratio
from sign_up_at_2021 as su inner join online_sale as os on os.user_id = su.user_id, count_2021
group by 1, 2
order by 1,2 

# select count(distinct su.user_id)
#  from sign_up_at_2021 as su inner join online_sale as os on os.user_id = su.user_id, count_2021


