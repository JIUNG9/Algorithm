import java.util.*;
class Solution {    
    public String solution(int n, int t, int m, int p) {
        
        String s ="";
        String answer ="";
        int i = 0;
        while(s.length() < t * m){
             String str = getInputRadixString(n,i);
            // System.out.println("str:" + str);
            i++;
            s = s.concat(str);
            // System.out.println("s:" + s);
        }
        
        int j = 0;
        while(answer.length() < t){
            answer = answer.concat(String.valueOf(s.charAt((p-1) + m * j)));
            j++;
        }
            return answer;
            
    }
    public String getInputRadixString(int radix, int i){
            if(i == 0) return "0";
            StringBuilder sb = new StringBuilder();
                while(i > 0){
                    int value = i % radix;
                    if(value == 10) sb.append("A");
                    else if(value == 11) sb.append("B");
                    else if(value == 12) sb.append("C");
                    else if(value == 13) sb.append("D");
                    else if(value == 14) sb.append("E");
                    else if(value == 15) sb.append("F");
                    else{
                        sb.append(value);
                    }
                    
                    i/=radix;
                    
                    
        }
    
        return sb.reverse().toString();
        
        
    }
    public String getInputRadixStringWhenUnder10(int radix, int i){
        if(i == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(i > 0){
            sb.append(i%radix);
            i/=radix;
        }
    
        return sb.reverse().toString();
        
    }
}