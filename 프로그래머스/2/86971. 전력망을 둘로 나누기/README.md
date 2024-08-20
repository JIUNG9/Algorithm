# [level 2] 전력망을 둘로 나누기 - 86971 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86971) 

### Approach
- Cut the wires one by one. get the connectedLen from the start. when there is connected Node which is from the start, find the all of nodes which is connected from the start node but not already visited. when finisihed finding the connectedWire, The connectedNode is wire + 1. so can get the the number of connected node. iterating the n times(wire length)


### Impl:
- I have the mistake when delete the wire through list . not array. the index of list is changed. when remove the 'i'th, the rest of elements which is at rear of'i' will be moved forward. even do the recover the wire the order is not kept like before.
- So use the Array data type


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
