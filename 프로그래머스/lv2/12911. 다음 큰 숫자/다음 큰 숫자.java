class Solution {
  public int solution(int n) {

    for(int i = n+1; ; i++){
      if(getZeroCount(Integer.toBinaryString(n))== getZeroCount(Integer.toBinaryString(i))){
        return i;
      }
    }
  }



  public int getZeroCount(String s){
    int count = 0;
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) =='1') count++;
    }
    return count;
  }
}