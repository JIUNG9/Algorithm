# [level 2] 무인도 여행 - 154540 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/154540) 

### Approach

* If the character is not '*' while brute force search check the left, right, bottom and up side. which is not  '*' and not over the range and not under the 0 idx also not visited

``` java
for(int i = 0; i < len; i++)
        for(int j =0; j < width; j++)
        if(!vistied[i].charAt(j) && arr[i].charAt(j)!='*')
                q.add(currentPosition)
                sum = currentPosition weight;
                        while(!q.isEmpty())
                                if 
condition : can go left, right, up, bottom / not vistied / not over the range, not under the 0 position about x, y 
 add the queue for each , add the weigth to sum, visited[willMoveY][willMoveX] = true

                                
```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
