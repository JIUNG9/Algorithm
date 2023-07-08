class Solution {
 public int solution(int n) {
    Long[] fiboArr = getFiboArr();
    return Math.toIntExact(fiboArr[n]);

  }

  public Long[] getFiboArr() {
    Long[] fibo = new Long[1000000];
    fibo[0] = 0L;
    fibo[1] = 1L;
    for (int i = 2; i < 1000000; i++) {
      fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
    }
    return fibo;
  }
}