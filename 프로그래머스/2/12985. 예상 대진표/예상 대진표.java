class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int counter = 0;
        while(a != b){
            if(a%2==1){
                a/=2;
                a++;
            }
            else{
                a/=2;
            }
            if(b%2==1){
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