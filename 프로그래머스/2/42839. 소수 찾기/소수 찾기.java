
import java.util.*;

class Solution {
 private final int MAX_VALUE = 9999999;

  public int solution(String numbers) {
    Set<Integer> set = new HashSet<>();
    //1. add every cases
    permutation("", numbers, set);
    //2. filter the set
    filterPrime(set);
    //3. return
    return set.size();
  }


  public boolean[] getPrimeArr() {
    boolean[] isPrime = new boolean[MAX_VALUE + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= MAX_VALUE; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= MAX_VALUE; j += i) {
          isPrime[j] = false;
        }
      }
    }
    return isPrime;
  }


  public void filterPrime(Set<Integer> set) {
    boolean[] primeChecker = getPrimeArr();
    set.remove(0);
    set.remove(1);

    for (int i = 2; i < MAX_VALUE; i++) {
      if (!primeChecker[i]) {
        set.remove(i);
      }
    }
  }


  public void permutation(String s, String pattern, Set<Integer> set) {

    if (!s.equals("")) {
      set.add(Integer.valueOf(s));
    }
    for (int i = 0; i < pattern.length(); i++) {
      permutation(s + pattern.charAt(i), pattern.substring(0, i) + pattern.substring(i + 1), set);

    }


  }
}