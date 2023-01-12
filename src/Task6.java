import java.net.URL;
import java.util.*;

public class Task6 {

    public static void main(String[] args) throws Exception {
        System.out.println("1:" + bell(3));
        System.out.println("2.1:" + translateWord("flag"));
        System.out.println("2.2:" + translateSentence("I like to eat honey waffles."));
        System.out.println("3:" + validColor("rgba(0,0,0,0.123456789)"));
        String b[] = {"b"};
        System.out.println("4:" + stripUrlParams("https://edabit.com?a=1&b=2&a=2", b));
        System.out.println("5:" + Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println("6:" + ulam(206));
        System.out.println("7:" + longestNonrepeatingSubstring("abcabcbb"));
        System.out.println("8:" + convertToRoman(16));
        System.out.println("9:" + formula("6 * 4 = 24"));
        System.out.println("10:" + palindromeDescendant(11211230));
    }

    public static int bell(int n) {
        int[][] bellTriangle = new int[n + 1][n + 1];
        bellTriangle[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            bellTriangle[i][0] = bellTriangle[i - 1][i - 1];

            for (int j = 1; j <= i; j++) {
                bellTriangle[i][j] = bellTriangle[i - 1][j - 1] + bellTriangle[i][j - 1];
            }
        }

        return bellTriangle[n][0];
    }

    public static String translateWord(String word) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        String suffix = "";
        if (word.matches(".*[.!?]$")) {
            suffix = word.substring(word.length() - 1);
            word = word.substring(0, word.length() - 1);
        }

        char firstChar = Character.toLowerCase(word.charAt(0));
        if (vowels.contains(firstChar)) {
            return word + "yay" + suffix;
        } else {
            int vowelIndex = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (vowels.contains(c)) {
                    vowelIndex = i;
                    break;
                }
            }
            if (vowelIndex == -1) {
                return word + "ay" + suffix;
            } else {
                String prefix = word.substring(0, vowelIndex);
                String suffix2 = word.substring(vowelIndex);
                return suffix2 + prefix + "ay" + suffix;
            }
        }
    }

    public static String translateSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(translateWord(word)).append(" ");
        }
        return sb.toString().trim();
    }

    public static boolean validColor(String color) {
        return color.matches("^rgb(a)?\\s*\\(\\s*(0|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\s*,\\s*(0|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\s*,\\s*(0|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\s*(,\\s*(0|1|0\\.\\d{1,9}))?\\s*\\)$");
    }

    public static String stripUrlParams(String urlString, String... paramsToRemove) throws Exception {
        URL url = new URL(urlString);
        String query = url.getQuery();
        if (query == null) {
            return urlString;
        }
        String[] pairs = query.split("&");
        Map<String, String> params = new LinkedHashMap<>();
        for (String pair : pairs) {
            int index = pair.indexOf("=");
            String key = (index > 0) ? pair.substring(0, index) : pair;
            String value = (index > 0) ? pair.substring(index + 1) : null;
            if (paramsToRemove != null && paramsToRemove.length > 0) {
                boolean remove = false;
                for (String param : paramsToRemove) {
                    if (param.equals(key)) {
                        remove = true;
                        break;
                    }
                }
                if (remove) {
                    continue;
                }
            }
            params.put(key, value);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            if (value != null) {
                sb.append("=").append(value);
            }
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String newQuery = sb.toString();
        String newUrlString = urlString.replace(query, newQuery);
        return newUrlString;
    }

    public static String[] getHashTags(String str) {
        String[] words = str.split("\\s+");
        ArrayList<String> hashTags = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 2) {
                hashTags.add("#" + word.toLowerCase());
            }
        }
        Collections.sort(hashTags, (s1, s2) -> s2.length() - s1.length());
        return hashTags.subList(0, Math.min(3, hashTags.size())).toArray(new String[0]);
    }

    public static int ulam(int n) {
        ArrayList<Integer> ulam = new ArrayList<>();
        ulam.add(1);
        ulam.add(2);
        for (int i = 2; i < n; i++) {
            int next = ulam.get(i - 1) + 1;
            while (!isUlam(next, ulam)) {
                next++;
            }
            ulam.add(next);
        }
        return ulam.get(n - 1);
    }

    public static boolean isUlam(int num, ArrayList<Integer> ulam) {
        int count = 0;
        for (int i = 0; i < ulam.size(); i++) {
            for (int j = i + 1; j < ulam.size(); j++) {
                if (ulam.get(i) + ulam.get(j) == num) {
                    count++;
                }
            }
        }
        return count == 1;
    }

    public static String longestNonrepeatingSubstring(String s) {
        Set<Character> windowChars = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        String result = "";

        while (end < s.length()) {
            char c = s.charAt(end);
            if (windowChars.contains(c)) {
                windowChars.remove(s.charAt(start));
                start++;
            } else {
                windowChars.add(c);
                end++;
                if (end - start > maxLength) {
                    maxLength = end - start;
                    result = s.substring(start, end);
                }
            }
        }

        return result;
    }

    public static String convertToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        }
        while (num >= 900) {
            sb.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            sb.append("D");
            num -= 500;
        }
        while (num >= 400) {
            sb.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            sb.append("C");
            num -= 100;
        }
        while (num >= 90) {
            sb.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            sb.append("L");
            num -= 50;
        }
        while (num >= 40) {
            sb.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            sb.append("X");
            num -= 10;
        }
        while (num >= 9) {
            sb.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            sb.append("V");
            num -= 5;
        }
        while (num >= 4) {
            sb.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            sb.append("I");
            num -= 1;
        }
        return sb.toString();
    }

    public static boolean formula(String form){
        int equalsIdx = form.indexOf("=");
        if(equalsIdx == -1)
            return false;
        if(form.indexOf("=", equalsIdx + 1) != -1)
            return false;
        String[] parts = form.split("=");
        if(parts.length != 2)
            return false;
        int leftPart = solvePart(parts[0]);
        int rightPart = solvePart(parts[1]);
        return leftPart == rightPart;
    }

    public static int solvePart(String part){
        String operations = "+-*/";
        int idx = 0;
        while(idx < part.length() && operations.indexOf(part.charAt(idx)) == -1)
            idx++;
        if(idx == part.length())
            return Integer.parseInt(part.strip());
        char operation = part.charAt(idx);
        return switch (operation) {
            case '+' -> solvePart(part.substring(0, idx)) + solvePart(part.substring(idx + 1));
            case '-' -> solvePart(part.substring(0, idx)) - solvePart(part.substring(idx + 1));
            case '*' -> solvePart(part.substring(0, idx)) * solvePart(part.substring(idx + 1));
            case '/' -> solvePart(part.substring(0, idx)) / solvePart(part.substring(idx + 1));
            default -> 0;
        };
    }

    public static boolean palindromeDescendant(int digit){
        String num = String.valueOf(digit);
        if(num.length() % 2 != 0)
            return false;
        StringBuilder sb = new StringBuilder();
        while(num.length() > 1){
            if(isPalindrome(num))
                return true;
            for(int i = 0; i < num.length() / 2; i++){
                int first = Character.getNumericValue(num.charAt(i * 2));
                int second = Character.getNumericValue(num.charAt(i * 2 + 1));
                sb.append(first + second);
            }
            num = sb.toString();
            sb = new StringBuilder();
        }
        return false;
    }

    public static boolean isPalindrome(String palindrome){
        if(palindrome.length() == 0)
            return false;
        if(palindrome.length() % 2 != 0)
            return false;
        return palindrome.substring(0, palindrome.length() / 2).equals(new StringBuilder(palindrome.substring(palindrome.length() / 2)).reverse().toString());
    }
}
