import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("1:" + repeat("mice", 5));
        int [] a1 = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println("2:" + differenceMaxMin(a1));
        int [] a2 = {1, 3};
        System.out.println("3:" + isAvgWhole(a2));
        int [] a3 = {1, 2, 3};
        System.out.println("4:" + cumulativeSum(a3));
        System.out.println("5:" + getDecimalPlaces("43.20"));
        System.out.println("6:" + fibonacci(3));
        System.out.println("7:" + isValid("59001"));
        System.out.println("8:" + isStrangePair("ratio", "orator"));
        System.out.println("9.1:" + isPrefix("automation", "auto-"));
        System.out.println("9.2:" + isSuffix("arachnophobia", "-phobia"));
        System.out.println("10:" + boxSeq(0));
    }
    //num1
    private static String repeat(String a, int n){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++){
            result.append(String.valueOf(a.charAt(i)).repeat(n));
        }
        return result.toString();
    }
    //num2
    private static int differenceMaxMin(int [] array){
        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }
    //num3
    private static boolean isAvgWhole(int [] array){
        return (double) Arrays.stream(array).sum() % array.length == 0;
    }
    //num4
    private static String cumulativeSum(int [] array){
        List<Integer> list = new ArrayList();
        for (int i = 0; i < array.length; i++){
            int result = 0;
            for (int j = 0; j <= i; j++){
                result += array[j];
            }
            list.add(result);
        }
        return list.toArray().toString();
    }
    //num5
    private static int getDecimalPlaces(String a){
        String mainChapterNum = a.substring(a.indexOf(".") + 1);
        return mainChapterNum.length();
    }
    //num6
    private static int fibonacci(int n) {
        int result = 0;
        int num = 0;
        int num2 = 1;
        for (int i = 0; i < n; i ++)
        {
            result = num + num2;
            num = num2;
            num2 = result;
        }
        return result;
    }
    //num7
    private static boolean isValid(String s){
        if (s.length() != 5){
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            try {
                String a_s = String.valueOf(a);
                Integer.parseInt(a_s);
            } catch (Exception e){
                return false;
            }
        }
        return true;
    }
    //num8
    private static boolean isStrangePair(String a, String b){
        if (a.equals("") && b.equals(""))
            return true;
        if (a.equals("") || b.equals("")){
            return false;
        }
        return a.charAt(0) == b.charAt(b.length() - 1) && a.charAt(a.length() - 1) == b.charAt(0);
    }
    //num9
    private static boolean isPrefix(String world, String prefix){
        String newPrefix = prefix.substring(0, prefix.indexOf("-"));
        String newWorld = world.substring(0, newPrefix.length());
        return newWorld.equals(newPrefix);
    }

    private static boolean isSuffix(String world, String suffix){
        String newSuffix = suffix.substring(1);
        String newWorld = world.substring(world.length() - newSuffix.length());
        return newWorld.equals(newSuffix);
    }
    //num10
    private static int boxSeq(int a){
        if (a % 2 == 0){
            return a;
        }
        return a + 2;
    }

}
