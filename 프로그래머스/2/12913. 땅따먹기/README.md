# [level 2] 땅따먹기 - 12913 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12913) 

## Approach



### Greedy
#### Approach 
- I thought the greedy approach from top to bottom gurantee the answer. also below code time complexity is 12 * O(n)
#### Problem
- But the problem is this should be gurantee also when approach from bottom to top. so Greedy approach won't be valid when approach bottom to top
``` java


        for(int i = 1; i < land.length; i++){
            int max = land[i-1][0];
            int maxIdx = 0;
            int secondMax = land[i-1][0];
            for(int j = 0; j < land[0].length; j++){
                if(max < land[i-1][j]){
                    max = land[i-1][j];
                    maxIdx = j;
                }
            }
            
            for(int k = 0; k < land[0].length; k++){
                if(secondMax < land[i-1][k] && k != maxIdx){
                    secondMax = land[i-1][k];
                }
            }
            
            for(int t = 0; t < land[0].length; t++){
                if(t == maxIdx)
                {
                    land[i][t] +=secondMax;
                    
                }
                else{
                    land[i][t]+=max;
                }
                answer = Math.max(answer, land[i][t]);
            }
            
        }
        


        return answer;
        
        
    }

```


## Approach 
### Approach : Dynamic programming -> gurantee the both side of approach!

``` java 
    int solution(int[][] land) {
        
        int[][] dp = new int[land.length][4];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i = 1; i < land.length; i++){
            for(int j =0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(k==j) continue;
                    dp[i][j] = Math.max(dp[i-1][k] + land[i][j],dp[i][j]);
                                    }
            }

            
        }
        


            int[] lastX = dp[land.length-1];
            Arrays.sort(lastX);
            return lastX[3];        
        
    }
```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
