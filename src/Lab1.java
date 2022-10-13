import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Point3d point1 = convertToPoint3d(scan.nextLine());
        Point3d point2 = convertToPoint3d(scan.nextLine());
        Point3d point3 = convertToPoint3d(scan.nextLine());

        if (point1.comparePoints(point2) && point2.comparePoints(point3) && point3.comparePoints(point1)){
            System.out.printf("Square = %.2f", computeArea(point1, point2, point3));
        } else {
            System.out.println("Change data");
        }

    }

    //Функция, конвертирующая вводные данные в объект типа Point3d
    private static Point3d convertToPoint3d(String s){
        String[] point = s.split(", ");
        return new Point3d(Double.parseDouble(point[0]), Double.parseDouble(point[1]), Double.parseDouble(point[2]));
    }

    //Функция, находящая площадь треугольника
    private static double computeArea(Point3d point1, Point3d point2, Point3d point3){
        double a = point1.distanceTo(point2);
        double b = point2.distanceTo(point3);
        double c = point3.distanceTo(point1);

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
