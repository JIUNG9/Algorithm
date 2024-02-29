import java.util.*;

class Solution {
    public int solution(String s1, String s2) {
        s1 = toUpper(s1);
        s2 = toUpper(s2);
        List<String> list1 = getStringList(s1);
        List<String> list2 = getStringList(s2);
        
        if(isBothSetEmpty(list1,list2)){
            return 65536;
        }   
     
        int theNumberOfCommon = getCommonNumber(list1,list2);
        int theNumberOfUnion = getTheNumberOfUnion(list1.size(),list2.size(),theNumberOfCommon);
        
        
        return multiplyWith65536AndRoundDown(theNumberOfCommon,theNumberOfUnion);
            
            
        
        }
    public List<String> getStringList(String s){
        
        int len = s.length();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            if(isAlphabet(s.charAt(i))){
                if(i + 1 < len && isAlphabet(s.charAt(i+1))){
                        String str = String.valueOf(s.charAt(i)).concat(String.valueOf(s.charAt(i+1)));
                    System.out.println("str:" + str);
                        list.add(str);
                    }
                }
            }
            return list;

        }
        
    
    public String toUpper(String s){
        return s.toUpperCase();
    }
    
    public boolean isAlphabet(char c){
        return Character.isLetter(c);
        
    }
    
    
    public int getTheNumberOfUnion(int list1Size, int list2Size, int intersectionSize){
        return list1Size + list2Size - intersectionSize;  
        }
    
    
    public int getCommonNumber(List<String> list1, List<String> list2){
            List<String> list1Copy = List.copyOf(list1);
            List<String> list2Copy = new ArrayList<>(List.copyOf(list2));
            int list1Len = list1Copy.size();
            int list2Len = list2Copy.size();
            int counter = 0;
        
        for(int i = 0; i < list1Len; i++){
            for(int j = 0; j < list2Len; j++){
                if(list1Copy.get(i).equals(list2Copy.get(j))){
                    counter++;
                    list2Copy.remove(j);
                    list2Len-=1;
                    break;
                }
             
            }
        }
return counter;

        }
        
    
    public int multiplyWith65536AndRoundDown(int common, int union){
        // type conversion
    System.out.println("common:" + common);
        System.out.println("union:" + union);
        double result = (double) common / (double) union * (double) 65536; 
            
            return (int) result;
        
        
        
        
        
    }    
    
    public boolean isBothSetEmpty(List<String> list1, List<String> list2){
        if(list1.size()==0 && list2.size()==0) return true;
        return false;
        
        
    }
    
}