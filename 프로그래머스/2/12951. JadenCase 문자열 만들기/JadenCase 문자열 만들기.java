import java.util.*;
class Solution {
    public String solution(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        boolean isFirstLetterAfterWhiteSpace = true;
        
        for(int i = 0; i < len; i++){
            while(i < len && s.charAt(i)==' '){
                sb.append(s.charAt(i++));
                isFirstLetterAfterWhiteSpace = true;
            }
            if(i < len){
                if(isFirstLetterAfterWhiteSpace && isLetter(s.charAt(i))){
                    isFirstLetterAfterWhiteSpace = false;
                    sb.append(changeToUpper(s.charAt(i)));
                }
                else {
                    sb.append(changeToLowerCase(s.charAt(i)));
                    isFirstLetterAfterWhiteSpace = false;
                }
            }
            
        }

       
            
            return sb.toString();
        }

    public boolean isLetter(char c){
        return Character.isLetter(c);
    }
    
    public char changeToUpper(char c){
        return Character.toUpperCase(c);
    }
    
    public char changeToLowerCase(char c){
        return Character.toLowerCase(c);
    }
    
    }

