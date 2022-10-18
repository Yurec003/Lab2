public class Point3d extends Point2d {
    //Объявляем переменные - координаты точки
    private double zCoord;
    //Конструктор
    public Point3d(double xCoord, double yCoord, double zCoord) {
        super(xCoord, yCoord);
        this.zCoord = zCoord;
    }

    public Point3d(){
        this(0.0, 0.0, 0.0);
    }

    //Getters и Setters для каждой переменной(координты)

    public double getzCoord() {
        return zCoord;
    }

    public void setzCoord(double zCoord) {
        this.zCoord = zCoord;
    }

    //Функция, находящая расстояние между двумя точками
    public double distanceTo(Point3d point){
        return (double)Math.round(Math.sqrt(
                Math.pow(point.getxCoord() - getxCoord(), 2) +
                        Math.pow(point.getyCoord() - getyCoord(), 2) +
                        Math.pow(point.getzCoord() - getzCoord(), 2)
        ) * 100) / 100;
    }

    //Функция, сравнивающая точки
    public boolean comparePoints(Point3d point){
        if ((getxCoord() == point.getxCoord()) && (getyCoord() == point.getyCoord()) && (getzCoord() == point.getzCoord())){
            return false;
        }
        return true;
    }

}
