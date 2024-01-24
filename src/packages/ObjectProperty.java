package packages;

public class ObjectProperty {
    public static void main(String[] args) {
        Point p = new Point(10, 20);
        Point p2 = new Point(10, 20);
        Point p3;
        System.out.println(p.getClass());
        System.out.println(p.getClass().getName());
        System.out.println(p.hashCode());
        System.out.println(p);

        if(p.equals(p2)){
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
        p3 = p;
        if(p == p3){
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
    }
}
