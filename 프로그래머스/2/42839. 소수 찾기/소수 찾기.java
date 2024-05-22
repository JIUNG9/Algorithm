import java.util.*;
class Solution {
    
    private Set<Integer> set;
    private boolean[] used;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        String[] arr = numbers.split("");
        used = new boolean[arr.length];
        dfs("",numbers);
        return set.size();
        
        
        
    }
    public void dfs(String pat,String numbers){
        
        if(!pat.equals("") && isPrime(Integer.parseInt(pat))) set.add(Integer.parseInt(pat));
        
        for(int i = 0; i < numbers.length(); i++){
            if(pat.length() < numbers.length() && !used[i]){
            used[i] = true;
            dfs(pat + numbers.substring(i,i+1),numbers);
            used[i] = false;
            }
        }
        
        
    }
public boolean isPrime(int n) {
    if (n <= 1) return false; 
    if (n == 2) return true;  
    if (n % 2 == 0) return false; 

    int sqrt = (int) Math.sqrt(n);
    for (int i = 3; i <= sqrt; i += 2) {
        if (n % i == 0) {
            return false; 
        }
    }
    return true; 
}
}