# [level 2] 할인 행사 - 131127 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131127) 

### Approach
- Get the number of counter which is sequentially all products in wanted array elements are bargained. The bargain duration is 10days from start
1. Can use the inner for loop, the inner for loop just iterate 10times and discount input size is 100,000. 1,000,000 is tolerable
2. Use the sliding window. when the current the number of iteration is over the 9, move the window. all the time if wantedMap contains the current checking elements decrease the value. when the iteration number is over 9 and wantedMap contains the currentIdx-10 as the key. increase the value and check the all values under or equal with '0' this means all products are bargained now


``` java

Map<String,Integer> map

main(){
initMapByWanted();
while(iterate all discount array)
        if(map.contains(currentCheckProducct)) decrease the value
        if(iteration count > 9 && map.contains(iteration count - 10) increase the value
        if(allValuesEqualOrUnder0) counter++
                return counter;
}
```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
