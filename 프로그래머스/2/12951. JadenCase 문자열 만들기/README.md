# [level 2] JadenCase 문자열 만들기 - 12951 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12951) 

### Approach
- If the first letter just right after the white space is the Letter change to uppercase. otherwise change to the lower case

``` java

boolean isFirstLetterAfterWhiteSpace = true

for(i;i< len; i++)
        while(i < len && until current is not whitespace) result.append(current char); i++;
                if(i < len)
                        if(currentLetter is Letter && isFirstLetterAfterWhiteSpace) result.append(changeToUpper(currentChar)) isFirstLetterAfterWhiteSpace = false;
                        else result.append(changeToLower(currentChar)); isFirstLetterAfterWhiteSpace = false;
                

```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
