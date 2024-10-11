import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] files) {
        //files의 파일명을 대소문자를 구분하지 않고 사전 순으로 정렬하고, number부분은 사전 순이 아닌 숫자순으로 정렬한다. 
        //file은 숫자가 나오기 이전까지가 head 숫자가 시작되는 부분은 number,숫자가 끝나는 부분부터 tail이다.
        //실수, NullPointException -> String head, number, tail weren't instantiated. So It can't be concated by itself
        int len = files.length;
        List<File> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            File f = new File(files[i]);
            list.add(f);
        }
        
        
        return list.stream().sorted((f1,f2)->{
            if(f1.head.toUpperCase().equals(f2.head.toUpperCase())){
                return Integer.compare(Integer.parseInt(f1.number), Integer.parseInt(f2.number));
            }
            else{
                return f1.head.toUpperCase().compareTo(f2.head.toUpperCase());
            }
        }).map(f -> f.concat()).toArray(String[]::new);
        
    }

    class File {
        String head = "";
        String number = "";
        String tail = "";

        public File(String input) {
            int len = input.length();
            int i = 0;

            while (i < len && !Character.isDigit(input.charAt(i))) {
                head += input.charAt(i++);
            }

            while (i < len && Character.isDigit(input.charAt(i))) {
                number += input.charAt(i++);
            }

            if (i < len) {
                tail = input.substring(i);
            }
        }

        @Override
        public String toString() {
            return "head: " + this.head + ", number: " + this.number + ", tail: " + this.tail;
        }

        public String concat() {
            return this.head + this.number + this.tail;
        }
    }
}
