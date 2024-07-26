# [level 4] 식품분류별 가장 비싼 식품의 정보 조회하기 - 131116 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131116) 

### Approach
- Get the product info by category
### Mis-understood
- When grouping by the category and use the max() function does not guarantee the max price is matched with product id and name, because it is just grouped by the category there will be only one tuple which is represented by category
- So decide to use the dense rank
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
