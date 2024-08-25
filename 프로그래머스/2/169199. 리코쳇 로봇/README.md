# [level 2] 리코쳇 로봇 - 169199 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/169199) 

### Approach

- First approach: 시작 위치를 구하여 상, 하, 좌, 우로 이동하여 맵을 넘기 전, D를 만나기 전 그리고 방문했던 적이 없는 경우 같은 방향으로 이동한다. 이동한 곳에서 똑같은 곳으로 움직이는 것을 막기 위해 방문 처리를하고 움직인 곳에서 동일하게 반복하여 G에 도달하도록 하여라, 만약 도달시킬 수 없다면 0을 반환하고. 만약 도달한다면 이때까지 진행했던 회차를 반환한다.
- Fix the first Logic: "방문했던 적이 없는 경우" -> This meant, every step while moving If current position is already visited, can't be visited. -> This is the wrong. the last position user is stopped cuz of the map size and obstacle should be handled which is visited. Otherwise this logic make this work -> "다음 스텝에서 벽을 만나거나 장애물을 만날 경우 해당 지점에서 멈춘다. 해당 지점이 이미 방문했던 적이 있다면 해당 지점에서는 더 이상 검사를 하지 않는다. 만약 방문했던 적이 없더라면 해당 지점을 방문처리 하고 다른 방향 또한 체크한다."

### Impl
- I use the Object reference which is Robot. It is not absolutely wrong. but while iterating should change the robot when just changing the reference value. there will be only one Robot even I add the Robot at Queue. 'So NOT TO USE THE OBJECT TYPE WITH THIS PROBLEM CAN BE IDEAL OR MAKE THE NEW REFERNCE EVERY TIME'

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
