# [level 2] 2개 이하로 다른 비트 - 77885 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/77885) 

### Approach
- chnage the the "0" character to "1" from the input String start idx, this meant the bigger value than input. but consider also can change the another value for making chagned value to more smaller
- For making the changed value to more smaller find the value "1" from the changed idx to 0(reverse way) If there is the "1" change to "0"
- Thoese two of steps assure the changed the value is the smallest value with changed two of characters


``` java

String input;
String reversed = input.reverse();        //for convinient to use the substring method from String
while(until find '0') move++; // This meant the String number should have the "0" Character even filled up with only "1" so add the "0" as the prefix as String
         inputNumber += 2^move;
while(until find '1', but move idx should bigger than 0) move--;
         inputNumber -= 2^move;
                return inputNumber;



//can use the Cache with Array or List for saving the square operation. it will alleviate the cost of calculation

```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
