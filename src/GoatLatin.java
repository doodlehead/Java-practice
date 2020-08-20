import java.util.Set;

public class GoatLatin {
    //1 <= s.length <= 150
    //Runtime: 2 ms
    //Memory usage: 37.9 MB
    public String toGoatLatin(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        String[] words = s.split(" ");
        String[] res = new String[words.length];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(Character.toLowerCase(words[i].charAt(0)))) {
                //First letter is vowel
                sb.append(words[i]);
            } else {
                //First letter is consonant

                //Don't need to do the first letter removal for a 1-letter word
                if (words[i].length() != 1) {
                    sb.append(words[i].substring(1, words[i].length()));
                    sb.append(words[i].charAt(0));
                } else {
                    sb.append(words[i]);
                }
            }

            sb.append("ma");

            for (int p = 0; p < i + 1; p++) {
                sb.append('a');
            }

            if (i != words.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
