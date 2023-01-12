import java.util.*;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("1:" + essay(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println("2:" + split("((()))(())()()(()())"));
        System.out.println("3.1:" + toCamelCase("is_modal_open"));
        System.out.println("3.2:" + toSnakeCase("helloEdabit"));
        double [] a = {9, 17, 30, 1.5};
        System.out.println("4:" + overTime(a));
        System.out.println("5:" + BMI("205 pounds", "73 inches"));
        System.out.println("6:" + bugger(999));
        System.out.println("7:" + toStarShorthand("abbccc"));
        System.out.println("8:" + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("9:" + trouble(451999277, 41177722899L));
        System.out.println("10:" + countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

    public static String essay(int n, int k, String s){
        String result = "";
        String [] a = s.split(" ");
        String firstResult = "";
        for (int i = 0; i < n; i++){
            if ((firstResult.length() + a[i].length()) <= k){
                firstResult += a[i];
                result = result + a[i] + " ";
            } else {
                i--;
                result += "\n";
                firstResult = "";;
            }

        }
        return result;
    }

    public static ArrayList<String> split(String s){
        ArrayList<String> result = new ArrayList<>();
        String interResult = "";
        int countOpen = 0;
        int countClose = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                interResult += s.charAt(i);
                countOpen++;
            } else {
                interResult += s.charAt(i);
                countClose++;
            }
            if (countClose == countOpen){
                result.add(interResult);
                s = s.substring(i);
                countClose = 0;
                countOpen = 0;
                interResult = "";
                i = 0;
            }
        }
        return result;
    }

    public static String toCamelCase(String s){
        String [] a = s.split("_");
        String result = a[0];
        for (int i = 1; i < a.length; i++){
            result += String.valueOf(a[i].charAt(0)).toUpperCase();
            result += a[i].substring(1);
        }
        return result;

    }
    public static String toSnakeCase(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++){
            String anObject = String.valueOf(s.charAt(i)).toLowerCase();
            boolean isUpperCase = !String.valueOf(s.charAt(i)).equals(anObject);
            if (isUpperCase){
                result += "_" + anObject;
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }


    public static String overTime(double [] a){
        double begin = a[0] * 60;
        double end = a[1] * 60;
        double salary = a[2] / 60;
        double n = a[3];
        double result = 0;
        for (double i = begin; i < end; i++){
            if (i >= 1020){
                result += salary * n;
            } else {
                result += salary;
            }
        }
        return  String.format("%.2f", result);
    }

    public static String BMI(String w, String h){
        String [] a = w.split(" ");
        String [] b = h.split(" ");
        double weight, height;
        String mWeight = a[1];
        String mHeight = b[1];
        if (mWeight.equals("pounds")){
            weight = 0.45 * Double.parseDouble(a[0]);
        } else {
            weight = Double.parseDouble(a[0]);
        }
        if (mHeight.equals("inches")){
            height = 0.025 * Double.parseDouble(b[0]);
        } else {
            height = Double.parseDouble(b[0]);
        }
        double index = (double) (((int)((weight / (height * height)) * 10)) / 10.0);
        if (index < 18.5){
            return index + " Underweight";
        } else if (index >= 18.5 && index < 24.9){
            return index + " Normal weight";
        } else {
            return index + " Overweight";
        }
    }

    public static int bugger(int a){
        int num = 0;
        while (a / 10 != 0){
            int result = 1;
            for(int i = a; i > 0; i /= 10){
                result *= i % 10;
            }
            a = result;
            num++;
        }
        return num;
    }

    public static String toStarShorthand(String s){
        String result = "";
        ArrayList <Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        ArrayList uniqueList = (ArrayList) list.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < uniqueList.size(); i++){
            int num = Collections.frequency(list, uniqueList.get(i));
            result += uniqueList.get(i);
            if (num > 1){
                result = result + "*" + num;
            }
        }
        return result;
    }

    public static boolean doesRhyme(String a, String b){
        String [] arr1 = a.split(" ");
        String [] arr2 = b.split(" ");
        String w1 = arr1[arr1.length - 1].toLowerCase(Locale.ROOT);
        String w2 = arr2[arr2.length - 1].toLowerCase(Locale.ROOT);
        ArrayList<Character> vowels1 = new ArrayList<>();
        ArrayList<Character> vowels2 = new ArrayList<>();
        for (int i = 0; i < w1.length(); i++){
            if ("aeiou".indexOf(w1.charAt(i)) != -1){
                vowels1.add(w1.charAt(i));
            }
        }
        for (int i = 0; i < w2.length(); i++){
            if ("aeiou".indexOf(w2.charAt(i)) != -1){
                vowels2.add(w2.charAt(i));
            }
        }
        return vowels1.size() == vowels2.size() && vowels1.containsAll(vowels2);
    }

    public static boolean trouble(long num1, long num2){
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        for(int i = 0; i < str1.length() - 2; i++){
            if(str1.charAt(i) == str1.charAt(i + 1) && str1.charAt(i) == str1.charAt(i + 2)){
                for(int j = 0; j < str2.length() - 1; j++){
                    if(str2.charAt(j) == str2.charAt(j + 1) && str2.charAt(j) == str1.charAt(i)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int countUniqueBooks(String str, Character c){
        boolean flag = false;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c){
                flag = !flag;
            }
            if (flag){
                list.add(str.charAt(i));
            }
        }
        ArrayList uniqueList = (ArrayList) list.stream().distinct().collect(Collectors.toList());
        uniqueList.remove(c);
        return uniqueList.size();
    }

}
