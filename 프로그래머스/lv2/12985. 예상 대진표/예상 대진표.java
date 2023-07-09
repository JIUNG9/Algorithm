class Solution
{
public int solution(int n, int a, int b) {
    int count = 1;
     if(a > b){
       int temp = a;
       a=b;
       b=temp;
     }

     while(true) {
       if(b-1 == a && a%2==1 && b%2 ==0) break;
       a = a % 2 == 1 ? a / 2 + 1  : a / 2 ;
       b = b % 2 == 1 ? b / 2 + 1 : b / 2 ;
       count++;
     }
     return count;

  }

}