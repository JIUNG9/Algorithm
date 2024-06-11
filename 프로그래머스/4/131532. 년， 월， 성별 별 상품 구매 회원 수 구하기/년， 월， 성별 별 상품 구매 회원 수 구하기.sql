select  YEAR(sales_date) as year, MONTH(sales_date) as month, gender, count(distinct(os.user_id))as users
from user_info as ui inner join online_sale as os on ui.user_id = os.user_id
where gender is not null
group by 1,2,3
order by 1,2,3