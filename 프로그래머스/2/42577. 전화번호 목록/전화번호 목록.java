import java.util.*;
class Solution {
    public boolean solution(String[] arr) {
        
        Arrays.sort(arr);
        int len = arr.length;
        
        for(int i = 1; i < len; i++){
            if(arr[i].startsWith(arr[i-1])) return false;
        }
        return true;
    }
}