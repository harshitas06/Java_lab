import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int n;   // number of subjects

    // Method to accept details
    void accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Method to calculate SGPA
    double calculateSGPA() {
        int totalCredits = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int gp = getGradePoint(marks[i]);
            total += credits[i] * gp;
            totalCredits += credits[i];
        }

        return (double) total / totalCredits;
    }

    // Method to find grade point
    int getGradePoint(int m) {
        if (m >= 90) return 10;
        else if (m >= 80) return 9;
        else if (m >= 70) return 8;
        else if (m >= 60) return 7;
        else if (m >= 50) return 6;
        else return 0;
    }

    // Method to display details
    void display() {
        System.out.println("\nStudent Details");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.printf("SGPA: %.2f\n", calculateSGPA());
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.accept();
        s.display();
    }
}
