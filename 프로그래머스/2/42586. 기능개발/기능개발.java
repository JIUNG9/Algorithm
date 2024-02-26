import java.util.*;
class Solution {
    public int[] solution(int[] p, int[] s) {
        Queue<Integer> needDays = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int counter = 0;
        int len = p.length;
        //init stk
        for(int i = 0; i < len; i++){
            needDays.add(getTakeDays(p[i],s[i]));
        }
        
        
        
        while(!needDays.isEmpty()){
            counter++;
            int val = needDays.poll();
            while(!needDays.isEmpty() && needDays.peek() <= val){
                needDays.poll();
                counter++;
            }
            list.add(counter);
            counter  = 0;
        }
        
        
        
     return  listToArr(list);
    }
    
    public int[] listToArr(List<Integer> list){
        int size =list.size();
        int[] arr = new int[size];
        
        for(int i = 0; i < size; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public int getTakeDays(int progress, int speed){
        int numb = 100 - progress;
        if(numb % speed != 0){
            return numb / speed + 1;
        }
        else{
            return numb / speed;
        }
    }
    
}