# [level 4] 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기 - 157339 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/157339) 

### Approach
- The key point is the range check of the date
- The start_date is absolutely equal with end_date or small. so just check the range of end_date like NOT end_date > 2022-11-01, The start_date and end_date will be bigger than 2022-11-01

<p><code>FEE</code>의 경우 예시처럼 정수부분만 출력되어야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
