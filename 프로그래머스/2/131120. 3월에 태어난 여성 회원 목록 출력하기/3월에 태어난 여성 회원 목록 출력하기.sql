-- 코드를 입력하세요
SELECT
    MEMBER_ID
    , MEMBER_NAME
    , GENDER
    , Date_format( DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH

from MEMBER_PROFILE 
where TLNO is not null and GENDER = "W" and DATE_OF_BIRTH like "%03%"
order by 1