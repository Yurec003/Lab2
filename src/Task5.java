import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task5 {

    public static void main(String[] args) {
        System.out.println("1.1:" + encrypt("Hello"));
        int a[] = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        System.out.println("1.2:" + decrypt(a));
        System.out.println("2:" + canMove("Queen", "C4", "D6"));
        System.out.println("3:" + canComplete("butl", "beautiful"));
        System.out.println("4:" + sumDigProd(16, 28));
        String b[] = {"toe", "ocelot", "maniac"};
        System.out.println("5:" + sameVowelGroup(b));
        System.out.println("6:" + validateCard(1234567890123456l));
        System.out.println("7:" + numToEng(126));
        System.out.println("8:" + getSha256Hash("password123"));
        System.out.println("9:" + correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println("10:\n" + hexLattice(7));
    }

    public static ArrayList<Integer> encrypt(String s){
        ArrayList<Integer> list = new ArrayList<>();
        int a = s.charAt(0);
        list.add(a);
        for (int i = 1; i < s.length(); i++){
            int b = s.charAt(i);
            list.add(b - a);
            a = b;
        }
        return list;
    }

    public static String decrypt(int list[]){
        ArrayList<Character> word = new ArrayList<>();
        int a = list[0];
        word.add((char) a);
        for (int i = 1; i < list.length; i++){
            int b = list[i];
            int num = a + b;
            word.add((char)num);
            a = num;
        }
        String w = "";
        for(char c: word){
            w = w + c;
        }
        return w;
    }

    public static boolean canMove(String figure, String point1, String point2){
        char p1[] = point1.toCharArray();
        char p2[] = point2.toCharArray();
        char letter1 = p1[0];
        char letter2 = p2[0];
        int num1 = p1[1];
        int num2 = p2[1];
        int l1 = letter1;
        int l2 = letter2;
        switch (figure){
            case "Pawn":
                if (letter1 != letter2){
                    return false;
                }
                if (num2 - num1 != 1){
                    return false;
                }
                return true;
            case "Horse":
                if ((Math.abs(num2 - num1) == 2 && Math.abs(l2 - l1) == 1) || (Math.abs(num2 - num1) == 1 && Math.abs(l2 - l1) == 2)){
                    return true;
                }
                return false;
            case "Elephant":
                if (num2 - num1 == l2 - l1){
                    return true;
                }
                return false;
            case "Rook":
                if (num2 == num1 || l2 == l1){
                    return true;
                }
                return false;
            case "Queen":
                if (num2 - num1 == l2 - l1 || (num2 == num1 || l2 == l1)){
                    return true;
                }
                return false;

            case "King":
                if ((l2 == l1 && Math.abs(num2 - num1) == 1) || (num2 == num1 && Math.abs(l2 - l1) == 1))
                    return true;
                return false;
            default:
                return false;
            }
    }

    public static boolean canComplete(String input, String word) {
        if (input.length() > word.length()) {
            return false;
        }
        int matchingCharacters = 0;
        for (int i = 0; i < word.length(); i++) {
            if (input.indexOf(word.charAt(i)) != -1) {
                matchingCharacters++;
                input = input.replaceFirst(Character.toString(word.charAt(i)), "");
            }
        }
        if (matchingCharacters == input.length()) {
            return true;
        } else {
            return word.contains(input);
        }
    }

    public static int sumDigProd(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        while (sum > 9) {
            int prod = 1;
            while (sum > 0) {
                prod *= (sum % 10);
                sum /= 10;
            }
            sum = prod;
        }
        return sum;
    }

    public static ArrayList<String> sameVowelGroup(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        Set<Character> firstWordVowels = new HashSet<>();
        for (char c : words[0].toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                firstWordVowels.add(c);
            }
        }
        for (String word : words) {
            Set<Character> wordVowels = new HashSet<>();
            for (char c : word.toLowerCase().toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    wordVowels.add(c);
                }
            }
            if (firstWordVowels.equals(wordVowels)) {
                result.add(word);
            }
        }
        return result;
    }

    public static boolean validateCard(long number) {
        String num = number + "";
        if (num.length() < 14 || num.length() > 19) return false;
        int sum = 0;
        int last = Integer.parseInt(num.charAt(num.length() - 1) + "");
        for (int i = 0; i < num.length() - 1; i++) {
            int digit = Integer.parseInt(num.charAt(i) + "");
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
        }
        return (10 - sum % 10) == last;
    }

    public static String numToEng(int num) {
        if (num == 0) {
            return "zero";
        }
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String result = "";
        if (num >= 100) {
            result += units[num / 100] + " hundred ";
            num %= 100;
        }
        if (num >= 10 && num < 20) {
            result += teens[num - 10] + " ";
            return result.trim();
        }
        if (num >= 20) {
            result += tens[num / 10] + " ";
            num %= 10;
        }
        if (num > 0) {
            result += units[num] + " ";
        }
        return result.trim();
    }

    public static String getSha256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String correctTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equalsIgnoreCase("and") || word.equalsIgnoreCase("the") || word.equalsIgnoreCase("of") || word.equalsIgnoreCase("in")) {
                sb.append(word.toLowerCase());
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1).toLowerCase());
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String hexLattice(int s){
        int count = hexCheck(s);
        if(count==-1){
            return "Invalid";
        }else{
            String res = "";
            String[] tmp = new String[2*(count-1)+1];
            tmp[count-1]=" o ";
            for(int i=1; i<count; i++){
                tmp[count-1]+="o o ";
                tmp[count-i-1] = " ";
                tmp[count+i-1] = " ";
                for (int j=0; j<i; j++){
                    tmp[count-i-1] += " ";
                    tmp[count+i-1] += " ";
                }
                for (int j=0;j<count;j++){
                    tmp[count-i-1] += "o ";
                    tmp[count+i-1] += "o ";
                }
                for(int j=1;j<i;j++){
                    tmp[count-j-1] += "o ";
                    tmp[count+j-1] += "o ";
                }
            }
            for (int i=0; i<2*(count-1)+1; i++){
                res += tmp[i];
                res += "\n";
            }
            return res;
        }
    }
    public static int hexCheck(int s){
        int test = 1, count = 1;
        while(test<s){
            test+=(count+1)+(count*4)+(count-1);
            count++;
        }
        if(test == s){
            return count;
        }
        return -1;
    }


}
