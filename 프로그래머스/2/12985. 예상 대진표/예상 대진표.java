class Solution
{
    public int solution(int n, int a, int b)
    {
        
        //작은 수가 0이 되고 큰 수가 1이 될 때까지 라운드를 진행
        //짝수 번째의 번호를 가진 사람은 /2 아닌 사람은 /2 +1을 진행한다.
        //-1차이 나는 것이 반드시 같은 라운드에서 게임을 하는 것은 아니다.
        //1,2라고 가정하자 이 둘은 첫 번째 라운드에서 만난다.
        //2와 3은 1차이 남에도 불구하고 두 사람은 같은 시합을 하지 않는다.
        
        int counter = 1;
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        // 1 2 (3 4) 5 6 
        while(!(b-1 == a && a % 2 == 1 && b % 2 ==0)){
            counter++;
            if(a % 2 == 1){
                a/=2;
                a++;
            }
            else{
                a/=2;
            }
            if(b%2 == 1){
                b/=2;
                b++;
            }
            else{
                b/=2;
            }
        }
        return counter;

        
    }
}