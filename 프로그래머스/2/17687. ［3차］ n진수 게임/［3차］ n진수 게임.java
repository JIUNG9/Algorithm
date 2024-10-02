import java.util.*;

class Solution {
private String[] preNum ={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String solution(int n, int t, int m, int p) {
        //참가하는 인원수 * 미리 구할 문자의 갯수가 될 때까지 문자열을 미리 구한 다음 해당 문자열에서 튜브가 말해야하는 차례의 문자열만 골라서 반환한다.
        //문자열은 진수에 따라서 해당 문자열을 반환한다.
        //튜브의 순서는 0부터가 아닌 1부터이다. 따라서 초기 값은 p-1이다. 증가해야하는 값은 참가하는 인원 수이다.
        
        StringBuilder sb = new StringBuilder();
        String preStr = getNumbers(n, m * t);
            for(int i = p-1; i < preStr.length() && sb.length() < t; i+=m){
                sb.append(String.valueOf(preStr.charAt(i)));
            }
        return sb.toString();
    }
    
    
    public String getNumbers(int n , int totalLength){
        
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(sb.length() < totalLength){
            String strNum = convertToN(n,num);
            sb.append(strNum);
            num++;
        }
        return sb.toString();
    }
    public String convertToN(int n, int num){
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";
        while(num > 0){
            sb.append(preNum[num % n]);
            num/=n;
        }
        
        return sb.reverse().toString();
    }
}