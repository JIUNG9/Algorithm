# [level 2] 예상 대진표 - 12985 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12985) 

### Approach
- When the subtract value from the bigger value from the smaller vlaue is 0 will be answer?
- There is the counter example when the smaller value is the 2 and bigger value is 3, the number two will be matched with 1 at the same time bigger value will be matched with 4
- So there should be one more condition. the smaller value should be odd, and bigger value should be even number
- iterate until the substracted value is 1, smaller value is odd and bigger value is even

``` java

main (){
        while(!(smallerValue % 2 == 0 && biggerValue %2 == 1 && biggerValue - smallerValue ==1)
                smallerValue = updateValue(smallerValue);
                biggerValue = updateValue(biggerValue);

}
updateValue(int num){
        if(num%2 ==1) num/=2; num+=1;
        else num/=2;
                return num;
}





```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
