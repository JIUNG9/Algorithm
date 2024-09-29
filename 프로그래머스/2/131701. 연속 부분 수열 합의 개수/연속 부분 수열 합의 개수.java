import java.util.*;
class Solution {
    Set<Integer> set;
    public int solution(int[] elements) {
        //순서를 지켜 숫자를 더해서 나올 수 있는 경우의 수를 중복 없이 저장하여 해당 개수를 반환한다.
        //dfs -> Heap에 어떤 것을 사용할 것인지, Stack은 어떻게 사용할 것인지, 순서는 상관있는지(동작)
        
        set = new HashSet<>();
        dfs(elements, 0, 0, elements.length);
        
        return set.size();
    }
    
    public void dfs(int[] e, int idx, int sum, int len){
        
        for(int i = idx; i < len + idx; i++){
            sum+=e[i%len];
            set.add(sum);
            
        }
         if(idx < e.length) dfs(e, idx + 1, 0 , len);
    }
}