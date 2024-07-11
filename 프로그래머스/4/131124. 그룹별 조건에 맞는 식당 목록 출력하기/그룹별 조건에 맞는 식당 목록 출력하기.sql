-- 코드를 입력하세요
-- Domain: There are multiple rows by same member_id
-- Impl: Use the dense_rank() over() function, partiion by the counter of member_id and order by desc


with get_most_reviewer as (
    select rr.member_id
    from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id
    group by rr.member_id
    order by count(rr.member_id) desc limit 1
)


select member_name, review_text, date_format(review_date,"%Y-%m-%d") as review_date
from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id
where rr.member_id in(select member_id from get_most_reviewer)
order by 3,2