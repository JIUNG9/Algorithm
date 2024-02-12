# [level 2] 가장 큰 수 - 42746 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42746) 

### consideration
The number of input is 100,000 so n^2 will be 100,000,000,000. it is too slow to run it
'0' can be one of the element of array. this mean the array can be ["0","0,"0"]
### Approach
Override the Comparator interface which get only first digit of number 1.1 If number is not equal compare the number which means bigger number will be rear side. 1.2 If number is equal make the value with o1, o2. this mean compare String value of o1+o2 and o2+o1
If the first digit is "0" this mean all elements are consisted of "0" so just return "0" else return the answer by concatenating from rear side
