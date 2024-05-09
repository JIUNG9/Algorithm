import java.util.*;
import java.util.Collections;

class Solution {
    public int[] solution(int[] p) {
        int len = p.length;
        int[] result = new int[len];
        PriorityQueue<Stock> q = new PriorityQueue<>((s1,s2)->{
            return Integer.compare(s2.value, s1.value);
        });
        
        q.add(new Stock(0,p[0]));
        for(int i = 1; i < len; i++){
            while(!q.isEmpty() && q.peek().value > p[i]){
                Stock stock = q.poll();
                result[stock.idx] = i - stock.idx;
            }
            q.add(new Stock(i,p[i]));
        }
        
        while(!q.isEmpty()){
            Stock stock = q.poll();
            result[stock.idx] = (len-1)- stock.idx;            
        }
        return result;
        
    }
    
    class Stock{
        private int idx;
        private int value;
        
        public Stock(int idx, int value){
            this.idx = idx;
            this.value =value;
        }
        
        
    }
    
}