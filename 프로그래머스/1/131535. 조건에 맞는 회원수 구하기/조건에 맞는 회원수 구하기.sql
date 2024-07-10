-- 코드를 입력하세요
select count(*) as users
from user_info
where year(joined) like "2021" and age >= 20 and age < 30