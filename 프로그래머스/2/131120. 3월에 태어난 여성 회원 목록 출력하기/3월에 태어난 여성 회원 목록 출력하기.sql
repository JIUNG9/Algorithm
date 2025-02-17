-- 코드를 입력하세요
select member_id, member_name, gender, date_format(date_of_birth, "%Y-%m-%d") as date_of_birth
from member_profile
where gender like "W" and TLNO  is not null and month(date_of_birth) like 3
order by 1 asc