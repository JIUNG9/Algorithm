import java.util.*;
class Solution {
    
      public String addPadding(String s){
    return "0"+s;
    }
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        int answerIdx = 0;
        long[] answer = new long[len];
        for(int i = 0; i < len; i++){
            long num = numbers[i];
            String strBinary = converToBinary(num);
            strBinary = addPadding(strBinary);
            int strLen = strBinary.length();
            long number =0 ;
            int idx = 1;            
            int digit = 0;

            char c = strBinary.charAt(strLen-idx);    
            
            while(c != '0'){
                digit++;
                idx++;
                if(strLen-idx < 0) break;
                c = strBinary.charAt(strLen-idx);
            }
          if (digit != 0) {
                number = num + getDigit(digit) - getDigit(digit-1);
            } else {
                number = num + getDigit(digit);
            }
            
            answer[answerIdx++] = number;
        }
        return answer;
    }
    
    public long getDigit(long iteration){
        long digit = 1;
        while(iteration > 0){
            digit *=2;
            iteration--;
        }
        return digit;
    }
    
    public String converToBinary(long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(String.valueOf(num%2));
            num/=2;
        }
        return sb.reverse().toString();
}
}