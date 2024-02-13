class Solution {
   public int[] solution(String s) {

    //1. count the number of iteration
    //2. count the removed '0' numbers
    //3. loop while s.length is not 1
    //-> while loop count removed 0 numbers
    //-> while loop count iteration number
    //-> while loop change the number to binary which is removed 0
    int iterationCounter = 0;
    int removed0Counter = 0;
    while(s.length()!=1){
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i)=='0') removed0Counter++;
        else{
          sb.append(s.charAt(i));
        }
      }
      iterationCounter++;
      s = decimalToBinary(sb.toString().length());
    }

    return new int[]{iterationCounter,removed0Counter};
  }

  public String decimalToBinary(int value){
    StringBuilder sb = new StringBuilder();
    while(value!=0){
      sb.append(value%2);
      value/=2;
    }
    sb.reverse();


    return sb.toString();

  }
}