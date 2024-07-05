# [level 2] 리코쳇 로봇 - 169199 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/169199) 

### Missed Point
- I use the while loop for reaching the point until meet 'G' or end of the map length or width, but I had mistake when the while loop end by condition. It is reached already end of the length or width or 'G' see below of code block

``` java

while(currentLen < length && currentLen > 0 && currentWidth < width && currentWidth > 0 && currentPosition is not 'G') move;

---> at this point the currentX or currentY already overlapped by the length or width or alreday positioned at 'G'
----> so add the go back code
currentX = goBack();
currentY = goBack();

if(visited[currentY][currentY]) 



```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
