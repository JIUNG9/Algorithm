# [level 2] 두 큐 합 같게 만들기 - 118667 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/118667) 

### Approach

1. Init the each of queue by input arrays and Get the sum of queue. poll from the bigger side which is the sum of elements in the queue and add to smaller side queue. but should care the sync with queue and sum of elements
2. The problem is "until when should I iterate?" How many times? Let' say there are the most biggest element is bigger than the sum of rest of elements. The most biggest number is left at one side. and then all elements resides at one side. after then when the situtation the biggest number reside other side meant no progress there isn't the answer. so limit is (n + 2n - 1)


``` java
q1;
q2;


init(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        q1Sum = q1.stream().sum()
        q2Sum = q2.stream().sum()
}

main(){

while(counter <= size * 3 - 1)
{
//iterate while the one side of be target.
}
        return -1;


}

```


   

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
