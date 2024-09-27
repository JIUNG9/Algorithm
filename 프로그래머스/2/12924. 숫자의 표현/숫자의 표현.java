class Solution {
    private int counter = 0;
    public int solution(int n) {
        //1부터 n까지 연속된 숫자를 시작 수 부터 n까지 총합이 n보다 작을 때까지 더한다. 만약 총합이 n을 넘는다면 종료한다. 그리고 값이 일치한다면 경우의 수를 추가한다.
        
        for(int i = 1; i <= n; i++){
            int sum = 0;
            //copied i, i의 idx를 움직이지 않는다. i는 outernal roation 숫자이다.
            int j = i;
            //범위가 허용하는 한 n보다 작을 때까지 더한다.
            while(j <= n && sum < n){
                sum+=j;
                j++;
            }
            if(sum == n) counter++;
        }
        return counter;
        
    }
}