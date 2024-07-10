# [level 2] 전력망을 둘로 나누기 - 86971 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86971) 

### Approach
- Missed point: 1. the node has the start and end position so consider the both cases when considering each node is connected.
- Logical: By cutting the each connected Node, check the min number of the difference from the connectedLen and the ohter part of the connectedLen

``` java

for(int i = 0; i < len; i++)
        cutNode;
        initVisited;
        connectedLen = 1; //when using the parameter which name is startNode and endNode those are connected so init the visited and make the connectedLen as 1
        dfs(startNode)
        dfs(endNode)
        recoverCutNode;

dfs(int node)
        for(int i =0; i < len; i++)
                if(!visited[i] && startNode == currentEndNode) connectedLen++; visited[i] = true ;dfs(currentEndNode); visited[i] = false;
                else if(!visited[i] && startNode == currentStartNode) dfs(currentStartNode) connectedLen++; visited[i] = true ;dfs(currentStartNode); visited[i] = false;
```




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
