import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
                //모든 것을 순회하면서  저장했던 숫자들이 존재하고 현재 확인하는 숫자보다 작다면(현재 숫자가 더 크다면) 이전에 저장했던 idx에 현재 확인 하는 원소로 결과 값을 모두 업데이트한 이후 현재 숫자를 저장한다. 

        int len = numbers.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1,arr2)->{
            return Integer.compare(arr1[1],arr2[1]);
        });
        int[] answer = new int[len];
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < len; i++) {
            int current = numbers[i];
            
            while (!pq.isEmpty() && current > pq.peek()[1]) {
                int[] arr = pq.poll(); 
                int idx = arr[0];
                answer[idx] = current; 
            }
            
            pq.add(new int[]{i, current});
        }
        
        return answer;
    }
}
