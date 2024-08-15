import java.util.*;
class Solution {

private String[] numbersStr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; sequence.length() < t * m; i++) {
            sequence.append(convertToNotation(n, i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = p - 1; result.length() < t; i+= m) {
            result.append(sequence.charAt(i));
        }

        return result.toString();
    }

    private String convertToNotation(int notation, int number) {
        StringBuilder sb = new StringBuilder();
        if (number == 0) return "0";
        while (number > 0) {
            sb.append(numbersStr[number % notation]);
            number /= notation;
        }
        return sb.reverse().toString();
    }

}