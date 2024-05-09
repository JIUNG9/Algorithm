# [level 2] 주식가격 - 42584 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42584) 

## Approach

### Pesudo

```
q = PrioirityQueue with reverseOrderByStockValue
q.add(first element of price)
while(loop the input of price){
        If (check q is not empty && q.peek() value is under the current idx value of price) Stock stock = q.poll(); result[stock.idx] = currentIdx - stock.idx;
        q.add(new Stock(currentIdx, currentValue);
}
While(q is not empty){
 Stock stock = q.poll();
result[stock.idx] = (len-1) - stock.idx;
}

class Stock
int idx;
int value;
```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
