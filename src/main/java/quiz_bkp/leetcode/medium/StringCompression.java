package quiz_bkp.leetcode.medium;

import java.util.stream.IntStream;

public class StringCompression {

    static int compress(char[] chars) {
        int i = 0;
        for (int j = 1, ctr = 1; j <= chars.length; j++, ctr++) {

            if (j == chars.length || chars[j] != chars[j - 1]) {
                chars[i++] = chars[j - 1];
                if (ctr >= 2) {
                    char[] subArr = String.valueOf(ctr).toCharArray();
                    for (char ch : subArr) {
                        chars[i++] = ch;
                    }
                }
                ctr = 0;
            }

        }

        return i;

    }

    static int compressV2(char[] chars) {

        if (chars == null || chars.length == 0) return 0;

        int rIdx = 0, wIdx = 0;
        int count = 1;

        while (rIdx < chars.length) {
            char currChar = chars[rIdx++];

            while (rIdx < chars.length && chars[rIdx++] == currChar) {
                count++;
            }

            chars[wIdx++] = currChar;
            for (char c : Integer.valueOf(count).toString().toCharArray()) {
                chars[wIdx++] = c;
            }

        }
        return wIdx - 1;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int result = compressV2(chars);
        System.out.println("result = " + result);
        IntStream.range(0, result).mapToObj(i -> chars[i]).forEach(System.out::print);
        assert result == 6 : "Wrong";
    }

}
