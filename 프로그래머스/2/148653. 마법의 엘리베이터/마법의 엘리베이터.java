class Solution {
public int solution(int s) {
    int counter = 0;
    //끝 자리 수가 5보다 작다면 + 끝자리 숫자
    //끝 자리 수가 5보다 크다면 10 - 끝자리 숫자, 앞 자리 수 올림
    //끝 자리 수가 5이고 앞 자리 수가 5이상이라면 + 5 , 앞 자리 수 올림
    //끝 자리 수가 5이고 앞 자리 수가 5미만이라면 + 5(버림)
    while(s!=0){
      int lastDigit = s%10;
      s /= 10;
      if(lastDigit < 5){
        counter+=lastDigit;
      }
      else if(lastDigit > 5){
        s+=1;
        counter += (10 - lastDigit);
      }
      else if(s%10 >=5){
        counter+=5;
        s++;
      }
      else if(s %10 < 5){
        counter+=5;
      }

    }
    return counter;
  }

}