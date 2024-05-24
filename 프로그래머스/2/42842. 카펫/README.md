# [level 2] 카펫 - 42842 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42842) 

### Approach
- The sum of the brown and yello is 2,005,000, and conside the case of the factor list Math.sqrt(2,005,000) about 1,000. so can the brute search tolerable with this problem
- get the sum of brwon and yellow and then get factor list by sum. when the elements can be sum by multiply with each other, elements * 2 -4 value matched with the brown input is the answer. but the yellow should be over number 3. because the depic of the picture. because the input pic is wrapped by the brown color. so for wrapping the brown block the len should be at least 3.

``` java

sum = brown + yellow

while(until get all of list but over the small value should be at least 3)

while(get answer, iterate the factor list)
when current iterating list sum of elements * 2 - 4 equals with brown number return new int[]{bigNubmer, smallNumber}

```


    출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
