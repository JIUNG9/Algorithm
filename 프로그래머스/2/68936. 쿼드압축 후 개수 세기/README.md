# [level 2] 쿼드압축 후 개수 세기 - 68936 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/68936) 

### Approach
1. check the current checking range of rect is zipped.
2. If can't be compacted make it 4 slice into parts
   2.1  iterate no more slice anymore(the size until 1)
   2.2 This mean use the iterate -> recursivce
   2.3 If current checking size can be compacted no more check

### Implementation


```
main()
{
int[2] answer;
dfs(0,size,0,size);
return answer;
}

canZip(int[][] elements, startX , endX, startY, endY);

dfs(startX,endX,startY,endY, int[][] elements){
        if(canZip) answer[elements[startY][startX]]++ return;

        dfs(0,x/2,0,y/2);
        dfs(x/2,x,0,y/2);
        dfs(0,x/2,y/2,y);
        dfs(x/2,x,y/2,y/2);

}

```




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
