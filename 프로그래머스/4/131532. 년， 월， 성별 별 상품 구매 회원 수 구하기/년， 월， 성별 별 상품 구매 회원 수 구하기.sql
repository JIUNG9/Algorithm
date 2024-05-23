# select year(sales_date)as year, month(sales_date) month, gender, sum(sales_amount) as users
# from user_info as ui inner join online_sale as os on ui.user_id = os.user_id
# where gender is not null
# group by year,month,gender
# order by year,month,gender

SELECT year(s.sales_date) as year,
       month(s.sales_date) as month,
       i.gender, count(distinct i.user_id) as users
from user_info i inner join online_sale s
on i.user_id = s.user_id
where i.gender is not null
group by 1,2,3
order by 1,2,3;