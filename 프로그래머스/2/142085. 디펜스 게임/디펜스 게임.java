import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        //적이 오는 순서에 따라서 무적권을 적절히 사용하여, 최대로 많은 적을 처리하여라
        //더 이상 내가 가진 병사의 개수로 상대를 쓰러뜨릴 수 없을 때는 무적권을 사용해야한다.
        //적이 올 때 우선, 내가 쓰러뜨릴 수 있을 때까지 병사를 사용하다, 이후에 더 이상 병사를 사용할 수 없는 경우, 이전에 가장 많이 사용하였던 병사의 개수와 현재 처리해야하는 병사의 개수를 비교하여 더 큰 수에 무적권을 사용하고, 그 개수 만큼 병사를 되살린다, 이때 K가 없다면 지금까지 싸웠던 round를 반환한다.
        
        int round = 0;
        int len = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(i < len){
            
                n-=enemy[i];
                pq.add(enemy[i]);
            
            if(n < 0){
                if(k > 0){
                    k--;
                    n+=pq.poll();
                }
                else{
                    return i;
                }
            }
            i++;
        }
       return i;
    }
}