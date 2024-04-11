import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr,(s2,s1)->{
            return s1.compareTo(s2);
            });
        
        
        for(int i = 0; i < arr.length;i++){
        System.out.println(arr[i]);    
        sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}