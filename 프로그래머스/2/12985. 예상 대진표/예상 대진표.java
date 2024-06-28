class Solution
{
    private int small;
    private int big;
    private int counter = 0;
    public int solution(int n, int a, int b)
    {
        
        assignTheSmallAndBig(a,b);

        while(!(small%2==1 && big %2 ==0 && big - small == 1)){
            counter++;
            small = updateToNext(small);
            big = updateToNext(big);
        }
            return counter+1;
        
    }
    
    public int updateToNext(int i){
        return i%2==1 ? i/2+1 : i/2;
    }
    public void assignTheSmallAndBig(int a, int b){
        if(a > b){
            big = a;
            small = b;
        }
        else{
            small = a;
            big = b;
        }
        
    }
    
}