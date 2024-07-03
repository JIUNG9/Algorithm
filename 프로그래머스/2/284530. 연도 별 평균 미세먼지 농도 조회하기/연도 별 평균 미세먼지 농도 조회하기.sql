-- 코드를 작성해주세요
select year(ym) as year, round(avg(pm_val1),2) as pm10, round(avg(pm_val2),2) as 'pm2.5'
from air_pollution
where location1 like '경기도' AND location2 like '수원'
group by year(ym)
order by 1 asc