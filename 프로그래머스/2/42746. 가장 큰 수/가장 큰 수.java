import java.util.stream.*;
import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> answerList = Arrays.stream(numbers).boxed().sorted((i1,i2)->{
            String i1FirstLetter = String.valueOf(i1).substring(0,1);
            String i2FirstLetter = String.valueOf(i2).substring(0,1);
            
            int result = i2FirstLetter.compareTo(i1FirstLetter);
            
            if(result == 0){
                String str1 = String.valueOf(i1);
                String str2= String.valueOf(i2);
                String str1WithStr2 = str1 +str2;
                String str2WithStr1= str2 + str1;
                
                return str2WithStr1.compareTo(str1WithStr2);
            
            }
            else return result;
            
        }).collect(Collectors.toList());
        
        
        
        
        
        
        
        for(Integer i: answerList){
            sb.append(String.valueOf(i));
        }
        
        String answer = sb.toString();
        
        return sb.substring(0,1).equals("0") ? "0": answer;
    }
}