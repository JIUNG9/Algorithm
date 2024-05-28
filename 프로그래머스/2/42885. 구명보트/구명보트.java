import java.util.*;

class Solution {
    private int boat;
    public int solution(int[] people, int limit) {
        
        //증명-> 가장 무거운 사람과 가장 가벼운 사람을 짝지어 태웠을 때 그 다음 무거운 사람과 그 다음 가벼운 사람의 조합 또한 같거나 더 가벼운 이유. -> 가장 무거운 사람과 가장 가벼운 사람이 limit보다 작다면 가장 작은 사람 무게의 사람보다 더 무거운 사람의 사람을 찾아 최적의 해를 구하지 않아도 되는 이유는, 가장 가벼운 사람과 가장 무거운 사람의 합을 더하지 않는다면 이후 가장 가벼운 사람과 그 다음 무거운 사람의 조합을 찾게 되는데, 가장 가벼운 사람의 무게와 그 다음 무거운 사람의 합은 항상 가장 무거운 사람과 가장 가벼운 사람의 무게의 합보다 작기 때문이다.
        
        Arrays.sort(people);
        int l  = 0;
        int r = people.length - 1;
        while(l <= r){
            if(l == r) {
                boat+=1;
                break;
            }
            else if(people[l] + people[r] <= limit){
                l++;
                r--;
                boat++;
            }
            else{
                r--;
                boat++;
            }
        }
        
        return boat;
        
    }
}