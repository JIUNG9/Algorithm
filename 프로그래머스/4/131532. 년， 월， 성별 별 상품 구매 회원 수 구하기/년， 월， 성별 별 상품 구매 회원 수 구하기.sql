-- 
-- year과 month로 집계하여 유저의 아이디가 중복되는 것을 필터링한 데이터를 기준으로 유저의 성별을 구하여, 해당 데이터의 성별이 존재하는 유저의 데이터를 연도, 월, 성별 별로 유저의 인원수를 구하여 집계 이후 년, 월, 성별을 기준으로 ASC 정렬




select year(sales_date) as year, month(sales_date) as month, gender ,count(distinct os.user_id) as users
from online_sale os inner join user_info ui on os.user_id = ui.user_id
where ui.gender is not null
group by 1,2,3
order by 1,2,3