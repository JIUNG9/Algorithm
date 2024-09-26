import java.util.*;
class Solution {
    public String solution(String s) {
        //모든 문자열을 순회하는데 공백이 아닌 것이 나오는 순간의 첫 순간에 해당 문자열이 영어라면 대문자로 수정 첫 순간이 아닌 것은 모두 소문자
        StringBuilder sb = new StringBuilder(); 
        boolean isFirstLetter = true;
        
        for(int i = 0; i < s.length(); i++){
            while(i < s.length() && s.charAt(i) == ' '){
                isFirstLetter = true;
                sb.append(s.charAt(i));
                i++;
            }
            if(i == s.length()) break;
            if(isFirstLetter){
                sb.append(Character.toUpperCase(s.charAt(i)));
                isFirstLetter= false;
            }
            else{
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            
        }
        return sb.toString();
      
      
}
}