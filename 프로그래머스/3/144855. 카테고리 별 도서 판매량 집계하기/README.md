# [level 3] 카테고리 별 도서 판매량 집계하기 - 144855 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/144855) 

### Approach
- 음식 종류 별로 즐겨 찾기 수가 가장 많은 식당을 얻어, 해당 식당의 정보를 출력하고 음식의 종류를 기준으로 내림차순 정렬
- dense rank function을 통해 음식 종류 별 가장 좋아요 개수가 많은 레스토랑 아이디와 rank를 통해 rank가 1이고 음식 종류가 같은 튜플을 얻고 음식 종류를 기준으로 내림차순한다.
- Get the most favorite from the user which is grouped by the restaurant type
- Impl: even grouping by the restaurant, can't get the type of the most favorties by the food type, because it is not partitioned by the food_type, so use the dense_rank() function(for partitioning) with window function, return the restaraunt id and rank. through that data get the result

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
