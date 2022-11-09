import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
        System.out.println("1:" + remainder(1, 3));
        System.out.println("2:" + triArea(3, 2));
        System.out.println("3:" + animals(2, 3, 5));
        System.out.println("4:" + profitableGamble(0.2, 50, 9));
        System.out.println("5:" + operation(24, 15, 9));
        System.out.println("6:" + ctoa('A'));
        System.out.println("7:" + addUpTo(3));
        System.out.println("8:" + nextEdge(8, 10));
        System.out.println("9:" + sumOfCubes("[1, 5, 9]"));
        System.out.println("10:" + abcmath(42, 5, 10));

    }
    //num1
    private static int remainder(int a, int b){
        return a % b ;
    }
    //num2
    private static int triArea(int a, int h){
        return (a * h) / 2;
    }
    //num3
    private static int animals(int chickens, int cows, int pigs){
        return chickens * 2 + (cows + pigs) * 4;
    }
    //num4
    private static boolean profitableGamble(double prob, int prize, int pay){
        return prob * prize > pay;
    }
    //num5
    private static String operation(int n, int a, int b) {
        if (a + b == n) {
            return "added";
        } else if (a - b == n){
            return "subtracted";
        } else if (a * b == n){
            return "multiplied";
        } else if (a / b == n){
            return "divided";
        } else {
            return "none";
        }
    }
    //num6
    private static int ctoa (char a){
        return a;
    }
    //num7
    private static int addUpTo(int a){
        int result = 0;
        for (int i = 1; i <= a; i++){
            result += i;
        }
        return  result;
    }
    //num8
    private static int nextEdge(int a, int b){
        return a + b - 1;
    }
    //num9
    private static int sumOfCubes(String str){
        int[] array = Arrays.stream(str.substring(1, str.length()-1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for (int i : array) {
            result += Math.pow(i, 3);
        }
        return result;
    }
    //num10
    private static boolean abcmath(int a, int b, int c){
        for (int i = 0; i < b; i++){
            a += a;
        }
        return a % c == 0;
    }
}
