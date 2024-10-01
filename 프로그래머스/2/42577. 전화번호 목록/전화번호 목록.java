import java.util.*;
class Solution {
    public boolean solution(String[] pb) {
        //String은 정렬하면 lexically하게 정렬된다. a, ab, abc 이렇게 정렬된다. 따라서 현재 확인하는 문자열 이후의 문자열이 현재 문자열을 포함한다면 return false이다.
        
        Arrays.sort(pb);
        for(int i = 0; i < pb.length -1; i++){
            String first = pb[i];
            String second = pb[i+1];
            if(second.startsWith(first)) return false;
        }
        return true;
    }
}