-- 코드를 입력하세요

-- 리뷰를 가장 많이 작성한 회원은 리뷰 테이블에서 존재하는 멤버의 아이디를 그룹지어 멤버의 아이디가 가장 많이 존재하는 멤버의 아이디를 통해 가장 리뷰를 많이 쓴 사람을 구한다.
-- 해당 유저 테이블에서 유저의 이름과 리뷰 테이블에서 리뷰의 텍스트와 자료 형식을 가공하여 원하는 형식의 데이트를 얻을 수 있다. 위에서 구한 결과에서 rnk가 1인 사람을 review에서 검색 조건으로 두어 결과 값을 얻는다.  결과 값은 리뷰 작성일 기준 오름차순, 리뷰 텍스트를 기준으로 오름차순한다.

with get_rnk as(
    select member_id, dense_rank() over(order by count(member_id) desc) as rnk
    from rest_review rr
    group by member_id
)


select member_name, review_text, date_format(review_date,"%Y-%m-%d") as review_date
from rest_review rr inner join member_profile mp on rr.member_id = mp.member_id
where rr.member_id in (select member_id from get_rnk where rnk = 1)
order by 3,2