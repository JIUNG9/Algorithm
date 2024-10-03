import java.util.*;
class Solution {
    private int answer = 0;
    private Queue<Integer> q;
    private Map<Integer,Integer> a;
    private Map<Integer,Integer> b;
    public int solution(int[] topppings) {
//총 토핑의 개수를 구한 다음, 철수가 모든 토핑을 가지고 있는다. (철수는 모든 토핑의 종류와 개수를 알고 있어야한다) (또한 영희도 자신이 가지고 있는 토핑의 종류와 개수를 알고 있어야한다)이후 철수가 토핑을 넣은 순서대로 영희에게 모든 토핑을 다 줄 때까지 반복한다. <!!!또한 철수가 가지고 있는 토핑의 종류를 모두 나눠준다면 해당 토핑을 지운다!!!>. 만약 철수의 토핑이 절반이 된다면 정답 가지수를 하나 추가한다. 

        
        //철수와 영희는 모든 토핑의 종류와 개수를 알고 있어야한다.
         a = new HashMap<>();
         b = new HashMap<>();
        //순서대로
         q = new LinkedList<>();
        
        init(topppings);

//실수한 부분 : remove를 안 넣어줌
        while(!q.isEmpty()){
            if(a.size() == b.size()) answer++;
            int t = q.poll();
            //철수가 가지고 있는 토핑을 영희에게 넘겨준다, 철수는 하나를 빼고 영희에게 하나 준다.
            int value = a.get(t);
            a.put(t,value-1);
            b.put(t, b.getOrDefault(t,0) + 1);
            if(value - 1 == 0) a.remove(t);
        }
        return answer;
        
    }
    public void init(int[] arr){
        for(int i = 0; i < arr.length; i++){
            q.add(arr[i]);
            a.put(arr[i], a.getOrDefault(arr[i],0) + 1);    
        
}
    }
}