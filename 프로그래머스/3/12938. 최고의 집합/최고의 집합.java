import java.util.*;
class Solution {
    public int[] solution(int n, int s) {  
        
        
        // s / n 이 0보다 작거나 같은 경우 return new int[]{-1};
        // s % n == 0 (s/n)의 결과값을 n개 만큼 만들어서 반환
        // s % n !=0 이 아닌 경우 (s/n)의 결과값을  n개 만큼 리스트에저장 우선적으로 저장 이후 나머지 값을 1씩 빼가면서 뒤의 숫자부터 더해주기
        
        int divided = s / n;
        int remainder = s%n;
        int[] returnArr = new int[n];
        int idx = 0;
        
        if(divided == 0) return new int[]{-1};
        else{
            for(int i = n-1; i >= 0; i--){
                if(remainder > 0) {
                    returnArr[i] = divided+1;
                    remainder--;
                }
                else{
                    returnArr[i] = divided;
                }
            }
            return returnArr;
        }
       
        }
    }
