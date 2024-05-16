# [level 2] 택배상자 - 131704 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131704) 

### Object Modeling
- Main belt: It is set as ASC order by number and should be picked up also ASC order -> This meant use the Queue
- Suppelement belt : This is the temporary belt which can be picked up from only the last part. -> This meant use the Stack
- Loaded : order is no matter just count how many boxes are loaded- > Use the List

 Make three of the object. and encapsulate the concrete data structure. there is the key-point of this object modeling

### Approach

- Load to Suppelement-belt from the Main-belt until the box number is less than currentShouldBeLoaded
- Load to Loaded from Supplement-belt until the box number is matched with order(should be ordered as the problem suggest)
- If there is no way can load as order just return the loaded size -> NO WAY means the current MainBelt box number is less than current order and Supplement-belt current box number also  is not matched with order



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
