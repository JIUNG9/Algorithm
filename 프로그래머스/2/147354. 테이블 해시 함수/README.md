# [level 2] 테이블 해시 함수 - 147354 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/147354) 

### Approach
- get sum of modular by input
- get sum of bitwise sum


``` java
getArrElementModSumByInput(int[] arr, int input){
int sum = 0;
for(Integer i : arr)
        while(i > 0)
        sum+=i%input;
        n/=2;
                return sum;

main(){

for(int i = start-1; i < end; i++)
        list.add(getArrElementModSumByInput(data[i],i));

for(Integer i : list)
        sum^i
}


```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
