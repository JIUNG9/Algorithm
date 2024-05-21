# [level 3] 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기 - 164671 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/164671) 

### Approach
1. get the most view by using window function. for getting most view use the dense rank
   
``` sql
with get_most_view as(
    select board_id, dense_rank() over(order by ugb.views desc) as rnk
    from used_goods_board as ugb    
)
```

2. Inner join on both of board_id and get the most view row by using where clause


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
