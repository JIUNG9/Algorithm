# [level 2] [3차] 파일명 정렬 - 17686 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17686) 

### Object Design
- There is a file which has the three parts
- should convert to file when there is String array input

``` java

class FileConvertor{

convertToFile(String[] strArr)
fileToString(File file) file.toString() 
}


class File implements Comparable<File>{
head
number
tail

toString() 

}
compareTo(File o){
compare head First
compare number next
}

```



### Missed Point
- ordering by the lexically didn’t work that I expected because If there is  ‘0’ as the prefix always the value which has the ‘0’ as the prefix come first when I do sort operation by the stream
on the other hand using the Integer as the number will save the value without 0 prefix. So compare the numbers by the Integer and save them as the String

- first sort by the head and then sort by number even number is same. just order by input order. I confused about just order by input order. I just return 1, But that was the problem.  It doesn't gurantee the natrue order of input. just return the result of compare the number won't chagne the sequence of input.
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
