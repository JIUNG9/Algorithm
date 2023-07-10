import java.math.BigInteger;

class Solution {
public int solution(int[] arr) {

    BigInteger lcmValue = new BigInteger(String.valueOf(arr[0]));

    for(int i = 1; i < arr.length; i++){
      lcmValue = lcm(lcmValue,BigInteger.valueOf(arr[i]));
    }
    return lcmValue.intValue();
  }

  public  BigInteger lcm(BigInteger x, BigInteger y) {
    //0이 아닌 두 수의 곱 / 두 수의 최대공약수
    return new BigInteger(String.valueOf(x)).multiply(y).divide(gcd(x, y));
  }

  public  BigInteger gcd(BigInteger a, BigInteger b) {
    if (b.intValue()==0) {
      return a;
    }
    return gcd(b, new BigInteger(String.valueOf(a)).remainder(b));
  }

}