import java.util.*;
class Solution {
    public int solution(int n, int number) {
        
        //5, 55 ,555 , 5555, 55555에서 5를 사용하여 5를 더하고 5를 뺴고, 5를 곱하고 5를 나누고 5를 두 개 써서 1을 더하고 1을 뺼 수 있다.
        
       //5, 55, 555, 5555, 55555를 사용 횟수를 기록한다. 이후 5를 더하고 빼고, 곱하고, 나누고, 1을 더하고, 1을 뺸 것을 5를 사용한 횟수와 함께 기록한다. 이것을 12가 될 때까지 반복하고 12가 된다면 해당 반복된 회차를 반환한다. 단 1의 관련 연산은 2의 회차를 더한다. 단 회차가 8보다 크다면 -1을 반환한다.
        //반례, 5,55,555,5555,55555를 넣은 이후 5만을 가지고 연산하는 것이 아니라 또 동시에 5,55,555,5555,55555를 가지고 연산할 수 있다.
        
        Queue<int[]> q = new LinkedList<>();
        int[] arr = new int[5];
        arr[0] = n;
        q.add(new int[]{arr[0], 1});
        
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i-1] * 10 + n;
            q.add(new int[]{arr[i],i+1});
        }
        //어디까지 숫자를 써야할까? 12면 십 자리까지만 써도 괜찮지 않을까?
        
        while(!q.isEmpty()){
            int[] arrInt= q.poll();
            int num = arrInt[0];
            int counter = arrInt[1];
            if(num == number) return counter;
            else if(counter < 8){
                q.add(new int[]{num + 1 , counter+2});
                q.add(new int[]{num - 1 , counter+2});
            for(int i = 0; i < arr.length; i++){
                q.add(new int[]{num + arr[i], counter + i + 1});
                q.add(new int[]{num - arr[i], counter + i + 1});
                q.add(new int[]{num * arr[i], counter + i + 1});
                q.add(new int[]{num / arr[i], counter + i + 1});
           
        }
            }
            
        }
        return -1;
    }
}