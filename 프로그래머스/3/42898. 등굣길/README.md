# [level 3] 등굣길 - 42898 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42898) 

### Approach
- When approach like this problem. add the padding for length and width. so doesn't need to chcek the range of input.(case 1)
- The puddle doesn't increase the case of reaching to the destination(case2)
- For init data the first case should be '1' not 0. so set the start position as 1. and should assure doesn't init the init value again(case3)

``` java
dp[][] = new int[length+1][width+1] (case 1)
for(i = 1; i <= length; i++)
        for(int j = 1; j <= width; j++)
                if(i==1 && j== 1) continue;(case 3)
                if(puddle){ init to 0, and continue (case2)
                                }


```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
