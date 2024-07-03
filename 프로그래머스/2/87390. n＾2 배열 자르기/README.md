# [level 2] n^2 배열 자르기 - 87390 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87390) 

### Approach
- Lossy conversion can be happened before divided by n (0 <= left <= right < n^2 means o <= left / n < = right / n < n ), The n is smaller than 10^7 can cover the int range. So conversion right after divied by 'n' won't be occured lossy conversion(int)(left/n)
- The main approach not get the all of rows from the input just get the rows which needs and start from the starRow's remainder to totalLength - n + endRow's remainder (use the <= not < in condition)
- The rule : The x th row has the number of (x+1) with (x+1) times and the sequentional value is came next from (x+1) to n (<= n not < in condition)

  
``` java
main(long left, long right, int n)
int startRow = (int)(left/n);
int endRow = (int)(right/n);
int startRemainder = (int)(left%n)
int endRemainder = (int)(left%n)

for(int i = startRow; i <= endRow; i++)
        for(int j = 0; j < startRow; j++) 
                list.add(startRow+1); // add the startRow + 1 because row start from the 0 otherwise the number start from the 1
        for(int k = startRow + 2; k <=n; k++)
                list.add(k);

for(int i = startRemainder; i <= list.size() - n + endRemainder; i++)
        answerList.add(list.get(i));

return answerList.stream().mapToInt(i->i).toArray();
```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
