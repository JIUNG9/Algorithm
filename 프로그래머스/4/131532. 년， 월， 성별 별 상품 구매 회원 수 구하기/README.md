# [level 4] 년, 월, 성별 별 상품 구매 회원 수 구하기 - 131532 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131532) 

### Domain
- There can be two of more user_id by at the online_sale
### Impl
- When grouping by the year, month and gender there can be the same user_id at online_sale. but I should check the sum of the person who bought the product. So not count two of more with same user_id -> Use the distinct keyword

### Mistake
``` sql
select year(sales_date)as year,month(sales_date) as month, gender, count(os.user_id) as users
from user_info as ui inner join online_sale as os on ui.user_id = os.user_id
where gender is not null
group by 1,2,3, os.user_id
order by 1,2,3
above code won't be worked as I thought. there can be same user_id with same year, month and gender so grouping with same user_id will count distinctly! but It wasn't I group also same user at different year, month and gender.
```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
