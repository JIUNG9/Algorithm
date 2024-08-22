# [level 3] 기지국 설치 - 12979 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12979) 

### Logical
- First approach: station이 존재하고 시작 범위(1)부터 기지국이 가지는 범위를 더하여 가장 앞에 위치하는 기지국이 커버하는 범위(stations[idx] - w) 보다  작을 경우 기지국을 설치하지 않고 존재하는 기지국위치에 기지국이 다룰 수 있는 최대 범위(기지국 + w) 이동하여 해당 위치부터 검색한다. station이 존재하고, 가장 앞에 존재하는 기지국이 커버할 수 없다면  기지국을 설치하고 현재 위치에서 기지국이 다루는 범위 * 2 + 1 위치로 이동하여 확인한다.(*2까지는 커버가 가능하므로)
- Second Approach:  현재 지점부터 n까지 station이 존재하고 가장 앞에 있는 기지국이 현재 위치를 커버할 수 있다면 현재 위치를 기지국의 위치 + w + 1로 옮기고 아니라면 기지국을 설치하고 현재 위치를 2w + 1 로 옮긴다.


- Difference: The first approach doesn't state the end index. and the condition also imply. When there is left station at rear side from the current. and the station can cover current positon doesn't set up the base-station and move to station postion + w + 1 otherwise move to 2 * w + 1 (set the base-station as posbbile as can cover.)


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
