package leetcode.medium;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String output = removeKDigits(num, k);
        System.out.println("output = " + output);
    }

    public static String removeKDigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }

        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {
            while (k > 0 && !st.empty() && st.peek() > c) {
                k--;
                st.pop();
            }
            st.push(c);
        }

        while (k > 0) {
            k--;
            st.pop();
        }

        return st.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
