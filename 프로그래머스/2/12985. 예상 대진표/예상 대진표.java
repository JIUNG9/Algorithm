class Solution
{
    public int solution(int n, int a, int b)
    {
        
        
        //짝수 번째의 번호를 가진 사람은 /2 아닌 사람은 /2 +1을 진행한다.
        //1만큼 차이가 나는 것이 반드시 같은 라운드에서 게임을 하는 것은 아니다.
        //2와 3은 1차이 남에도 불구하고 두 사람은 같은 시합을 하지 않는다.
        //1차이가 나고 작은 수 a가 홀수이며 b가 짝수일 때 같은 라운드에서 시합한다.
        
        int counter = 1;
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        
        
        while(true){
            if(b-1 == a && b%2 == 0 && a%2 ==1) break;
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
            counter++;
        }
        return counter;

        
    }
}