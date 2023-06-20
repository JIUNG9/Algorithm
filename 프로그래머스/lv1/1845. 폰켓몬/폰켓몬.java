import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        
        //선택해야하는 횟수 => nums.length/2
        int len = nums.length;
        int comb = len /2 ;
        
        for(int i =0; i < len; i++){
            set.add(nums[i]);
        }
        //set의 개수가 선택해야하는 횟수보다 크거나 같다면 선택해야하는 횟수
        int answer = (set.size() >= comb) ? comb : set.size();
        //아니라면 set의 개수
        return answer;
        

    }
}