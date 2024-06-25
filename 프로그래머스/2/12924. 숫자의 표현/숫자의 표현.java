import java.util.*;
class Solution {
    private int answer = 0;
   public int solution(int target) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 1;
        int num = 1;

        q.add(1);
        num++;

        while(!q.isEmpty() && q.peek() <= target){
            if(sum >= target){
                if(sum == target) answer++;
                sum-=q.poll();
            }
            if(sum < target){
                q.add(num);
                sum+=num++;
            }
        }


        return answer;

    }

}