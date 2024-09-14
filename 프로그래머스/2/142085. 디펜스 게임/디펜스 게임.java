import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        //최적의 해 -> 가장 적합할 때 무적권을 사용해야한다. 그럼 언제?
        //병사를 다 써버린 이후에 무적권을 사용하는 것은 최적의 해를 보장하지 않는다.
        //평균을 구해서 무적권을 사용하는 것도 보장할 수 없다.
        //즉 병사를 사용하다 더 이상 막아낼 수 없을 때 이전에 처리했던 가장 큰 인원수의 병력을 무적권을 사용하여 처리하는 것이 가장 최적의 해를 보장한다.
        //구현 방법: PQ를 사용한다.
        int len = enemy.length;
        int counter = 0;
        int i = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        while(i < len){
            //더 이상 진행할 수 없을 경우
            if(k <=0 && n - enemy[i] < 0) break;
            //막아낼 수 있을 때까지 병사 사용
            while(i < len && n - enemy[i] >= 0){
                n-=enemy[i];
                q.add(enemy[i]);
                i++;
                counter++;
            }
            //현재는 막을 수 없는 상태 따라서 무적권이 존재한다면 
            if(i < len && k > 0){
                //이전에 처리했던 가장 큰 값을 무적권을 사용하여 현재 적을 처리할 수 있게 함
                if(q.size() > 0){
                    //edge case 
                    if(enemy[i] > q.peek()){
                        i++;
                        counter++;
                    }
                    else{
                        n+=q.poll();     
                    }
                    
                    k--;
                }
                //만약 이전에 처리했던 것이 없다면 무적권을 사용해서 현재 다가오는 병력을 막고 다음 것을 처리할 준비
                else{
                    k--;
                    i++;
                    counter++;
                }
                
            }
            
        }
            
            return counter;
        }
        
        
}