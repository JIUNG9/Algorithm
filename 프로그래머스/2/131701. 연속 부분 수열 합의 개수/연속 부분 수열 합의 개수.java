import java.util.*;
class Solution {
    Set<Integer> set;
    public int solution(int[] elements) {
        //순서를 지켜 숫자를 더해서 나올 수 있는 경우의 수를 중복 없이 저장하여 해당 개수를 반환한다.
        //dfs -> Heap에 어떤 것을 사용할 것인지, Stack은 어떻게 사용할 것인지, 순서는 상관있는지(동작)
        //dfs설계 첫 원소부터 끝 원소까지 모든 값을 중복되는 값 없이 구함, 두 번째 원소부터 순차적으로 더하여 첫 번째 원소까지 중복되는 값 없이 구함, 세 번째 원소부터 순차적으로 더하여 두 번쨰 원소까지 중복되는 값 없이 구함
        //구현 : n번 만큼 반복하여, 0번부터 n번까지 원소의 인덱스를 1씩 증가하면서, 원소의 끝의 도달한다면 원소의 처음부터 돌아가 n개의 원소를 더하여 중복이 없도록 하여 합의 원소를 구함
        // 해당 DFS는 정확히 n번 반복하고, 방문 처리를 할 필요가 없음
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