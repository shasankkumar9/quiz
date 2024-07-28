package quiz_bkp.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> sCount = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            } else {
                sCount.put(ch, 1);
            }
        }

        System.out.println("sCount = " + sCount);

        for (Character ch : t.toCharArray()) {
            if (!sCount.containsKey(ch) || sCount.get(ch) == 0) {
                return false;
            }
            int count = sCount.get(ch);
            if (count == 1) {
                sCount.remove(ch);
            } else {
                sCount.put(ch, sCount.get(ch) - 1);
            }

        }
        System.out.println("sCount = " + sCount);

        return sCount.isEmpty();
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "agraman";

        System.out.println(isAnagram(s, t));

    }

}
