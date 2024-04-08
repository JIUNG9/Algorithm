import java.util.*;
class Solution {
    public int solution(int[] a, int[] b) {
        int counter = 0;
        int aIdx = 0;
        int bIdx = 0;
        int aLen = a.length;
        int bLen = b.length;
        
        Arrays.sort(a);
        Arrays.sort(b);
    
        while(aIdx < aLen && bIdx < bLen){
            
            
            
            //무승부
            if(b[bIdx] == a[aIdx] ){
                
                bIdx++;
                continue;
            }
            
            
            //B가 더 작은 경우
           else if(aIdx < aLen && bIdx < bLen && b[bIdx] < a[aIdx]){
                while( bIdx < bLen && b[bIdx] < a[aIdx]){
                    bIdx++;
                }
                //이길 수 있는 방법이 존재하지 않음 -> bIdx를 계속 더했으므로, OutOfIdx
                if(bIdx >= bLen) break;
                
            
                //이제 B가 이길 수 있는 경우
                else{
                    aIdx++;
                    bIdx++;
                    counter++;
                }
                continue;
            }
            
            
            else if(aIdx < aLen && bIdx < bLen && b[bIdx] > a[aIdx]){
                counter++;
                aIdx++;
                bIdx++;
                continue;
            }
        }
        return counter;
        
    }
}