import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int temp = b;
        
        if(a > b){
            b = a;
            a = temp;
        }
        

        
        while(a!=b){
            answer++;
            b= getNextParticipationNumber(b);
            a= getNextParticipationNumber(a);    
        }
        

        return answer;
    }
    public int getNextParticipationNumber(int number){
        return number%2 ==1 ? number/2+1 : number/2;
    }
}