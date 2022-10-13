public class Palindrome {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (isPalindrome(args[i])){
                System.out.println("World " + (i+1) + ":true");
            } else {
                System.out.println("World " + (i+1) + ":false");
            }
        }

    }

    //Функция, переворачивающая слово
    public static String reverseString(String s){
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--){
            result += s.charAt(i);
        }
        return result;
    }

    //Функция, проверяющая является ли слово палиндромом
    public static boolean isPalindrome(String s){
        String reverse = reverseString(s);
        return s.equals(reverse);
    }
}
