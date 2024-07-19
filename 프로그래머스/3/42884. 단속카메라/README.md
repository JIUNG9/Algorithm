# [level 3] 단속카메라 - 42884 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42884) 

### Approach
- If the out-time which is current checked vehicle is bigger than rear car's in-time, check the next vehicle from rear car, If not add the camera at current position, and move to rear from current until start position is reached to length of the routes
### Impl
- For checking the out-time which is out at first from the routes. should sort by the out-time with ascending order.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
