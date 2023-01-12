import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("1:" + solutions(1, 0, -2));
        System.out.println("2:" + findZip("all zip files are zipped"));
        System.out.println("3:" + checkPerfect(6));
        System.out.println("4:" + flipEndChars("Cat, dog, and mouse."));
        System.out.println("5:" + isValidHexCode("#CD5C5C"));
        int a[] = {1, 3, 4, 4, 4};
        int b[] = {2, 5, 7};
        System.out.println("6:" + same(a, b));
        System.out.println("7:" + isKaprekar(297));
        System.out.println("8:" + longestZero("01100001011000"));
        System.out.println("9:" + nextPrime(12));
        System.out.println("10:" + rightTriangle(3, 4, 5));
    }

    private static int solutions(int a, int b, int c) {
        int d = b * b - 4 * a * c;
        if (d == 0) {
            return 1;
        }
        if (d < 0) {
            return 0;
        }
        return 2;
    }

    private static int findZip(String s) {
        String zip = "zip";
        int i = s.indexOf(zip);
        String s1 = s.substring(i + 3);
        int j = s1.indexOf(zip);
        if (j > 0)
            return j + (s.length() - s1.length());
        return -1;
    }

    public static boolean checkPerfect(int a) {
        int sum = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                sum += i;
            }
        }
        return sum == a;
    }

    public static String flipEndChars(String s) {
        if (s.length() < 2) {
            return "Incompatible.";
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return "Two's a pair.";
        }
        return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
    }

    public static boolean isValidHexCode(String s) {
        if (s.charAt(0) == '#' && s.length() - 1 == 6) {
            String s1 = s.substring(1);
            return s1.matches("^[0-9a-fA-F]+$");
        }
        return false;
    }

    public static boolean same(int[] a, int[] b) {
        int n1 = Arrays.stream(a).distinct().toArray().length;
        int n2 = Arrays.stream(b).distinct().toArray().length;
        return n1 == n2;
    }

    public static boolean isKaprekar(int a) {
        int b = a * a;
        if (((int) Math.log10(b) + 1) == 1) {
            return b == a;
        }
        String s1 = String.valueOf(b);
        int c = Integer.parseInt(s1.substring(0, s1.length() / 2));
        int d = Integer.parseInt(s1.substring(s1.length() / 2));
        return c + d == a;
    }

    public static String longestZero(String s) {
        int n = 0;
        int maxN = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                n++;
            } else {
                if (n > maxN) {
                    maxN = n;
                    n = 0;
                }
            }
        }
        return "0".repeat(maxN);
    }

    public static int nextPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                a++;
                i = 2;
            }
        }
        return a;
    }

    public static boolean rightTriangle(int a, int b, int c){
        int [] array = {a, b, c};
        Arrays.sort(array);
        return array[2] * array[2] == array[0] * array[0] + array[1] * array[1];
    }
}


