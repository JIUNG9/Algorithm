# [level 4] 주문량이 많은 아이스크림들 조회하기 - 133027 


### Approach
-Domain : July, There are same rows by the flavor. otherwise first_half is not
-Impl: Group by the total_number by the flavor in july table. and join with first_half and group by two of flavor for each and order by the sum of two of total_order at last limit 3 will be answer
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
