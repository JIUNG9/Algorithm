
import java.util.*;
import java.util.stream.Collectors;

class Solution {
   public String solution(String s) {
    //1.1 if the charAt(0) is the number do not change
    //1.2 else, change the charAt(0) to upper case
    //2. if charAt(i) is lowercase and i - 1 is equal to " ", change i to uppercase
    //3. if chartAt(i) is the uppercase and i - 1 is not equal to " " change i to lower case 
    StringBuilder sb = new StringBuilder();



    //These cases are the 1.1 and 1.2
    int len = s.length();
    if (s.charAt(0) >= 97 && s.charAt(0) <= 122) {
      sb.append(Character.toString(s.charAt(0) - 32));
    }
    else{
      sb.append(s.charAt(0));
    }


    //These cases are 2, 3
    for (int i = 1; i < len; i++) {

    if (s.charAt(i) >= 97 && s.charAt(i) <= 122 && s.charAt(i-1)==' ') {
      sb.append(Character.toString(s.charAt(i)-32));
    }
    else if (s.charAt(i) >= 62 && s.charAt(i) <= 90 && s.charAt(i-1)!=' ') {
      sb.append(Character.toString(s.charAt(i)+32));
    }
    else{
      sb.append(s.charAt(i));
    }
    }
return sb.toString();
  }
}
