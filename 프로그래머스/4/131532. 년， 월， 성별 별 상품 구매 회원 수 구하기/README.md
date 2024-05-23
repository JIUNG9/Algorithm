# [level 4] 년, 월, 성별 별 상품 구매 회원 수 구하기 - 131532 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131532) 

### Missed point


``` sql
select year(sales_date)as year, month(sales_date) month, gender, sum(sales_amount) as users
from user_info as ui inner join online_sale as os on ui.user_id = os.user_id
where gender is not null
group by year,month,gender
order by year,month,gender
```

- I missed the distinct keyword at sum function.
- I didn't understand the sales table which can have the same user_id
- I didn't analyze the joined data. There is absolutely same user_id and the problem require the number of user_id


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
