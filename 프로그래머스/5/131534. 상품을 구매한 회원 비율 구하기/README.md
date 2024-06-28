# [level 5] 상품을 구매한 회원 비율 구하기 - 131534 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131534) 

### Approach
- Analyze the domain : The "ONLINE_ORDER" domain has the multi row by same user. 
- Get the number of user who sign up at 2021
- Get the user who sign up at 2021
- There can be same user_id who buys serveral times at same year and month so when get the number of user who buys at same year and month, use the distinct keyword


``` sql
with get_total_numbers_who_sign_up_2021 as()
,get_user_who_sign_up_2021 as ()

selelct year,month, count(distinct order_sale.user_id), round( count(distinct order_sale.user_id) /get_total_numbers_who_sign_up_2021,1)
from get_user_who_sign_up_2021 as gu inner join online_sale as os on os.user_id = gu.user_id
order by year,month



```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
