import java.util.Scanner;

public class quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a, b, c;
        double d, r1, r2;

        System.out.print("Enter value of a: ");
        a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        c = sc.nextDouble();

        d = b * b - 4 * a * c;   // Discriminant

        if (d > 0) {
            r1 = (-b + Math.sqrt(d)) / (2 * a);
            r2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Two real solutions:");
            System.out.println("Root 1 = " + r1);
            System.out.println("Root 2 = " + r2);
        } 
        else if (d == 0) {
            r1 = -b / (2 * a);
            System.out.println("One real solution:");
            System.out.println("Root = " + r1);
        } 
        else {
            System.out.println("No real solutions exist.");
        }

        sc.close();
    }
}
