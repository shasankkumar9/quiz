import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        String word1 = "uau";
        String word2 = "ssx";

        System.out.println("closeStrings(word1, word2)); = " + closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        // Count the frequency of characters in word1
        for (char c : word1.toCharArray())
            count1.merge(c, 1, Integer::sum);

        // Count the frequency of characters in word2
        for (char c : word2.toCharArray())
            count2.merge(c, 1, Integer::sum);

        // Check if the sets of characters are equal
        if (!count1.keySet().equals(count2.keySet()))
            return false;

        // Check if the frequencies are the same for each character
        Collection<Integer> freqs1 = count1.values();
        Collection<Integer> freqs2 = count2.values();

        return freqs1.containsAll(freqs2) && freqs2.containsAll(freqs1);

    }

}
