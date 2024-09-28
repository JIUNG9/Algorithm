import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //가장 무거운 사람과 가장 가벼운 사람을 함께 태웠을 때 한계 무게를 넘지 않는다면 두 사람을 같이 태우고 아니라면 가장 무거운 사람만을 태운다. 이때 구명보트를 한 개 쓴다.
        int left = 0;
        int right = people.length -1;
        int answer = 0;
        Arrays.sort(people);
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            answer++;
        }
        return answer;
        
    }
}