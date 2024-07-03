# [level 2] 행렬의 곱셈 - 12949 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12949) 


### Approach
- The input of a matrix's row length is the target matrix's row length and the input of the b matrix's width is the target width
- when made the target[i][j] fix the a matrix's 'i' and move the width position and also fix the b matrix's length and move the length positon
- But thing is, how much moves? not the target length or width, it is a matrix's width or b matrix's length otherwise between multiply matrix won't be made.

```
main(int[] a , int[] b)
int targetWidth = b[0].length;
int targetLength = a.length;
int aWidthOrBLength = a[0].length;

for(int i = 0; i < targetLength; i++)
        for(int j = 0; j < targetWidth; j++)
                int sum = 0;
                for(int k = 0; k < aWidthOrBLength; k++)
                        sum+=(a[i][k] * b[k][j);
                target[i][j] = sum

```
 


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
