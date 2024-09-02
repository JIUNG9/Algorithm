# [level 5] 상품을 구매한 회원 비율 구하기 - 131534 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131534) 

### Domain
- There can be same user which bought the product at the same year and month, so when counting the number of the user who boughts at the specific year and month should be distincted


### Mistake
see the difference between two of that  round(count(distinct os.user_id) /count(us.user_id),1)as PUCHASED_RATIO vs  round(count(distinct os.user_id) /(select count(user_id) from get_the_number_user_sign_up_2021) ,1) as PUCHASED_RATIO. The first one means the number of the user which buy the products at 2021 which is grouped by the year and month. otherwsie second one is not. Just the number of user who signed up at 2021


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
