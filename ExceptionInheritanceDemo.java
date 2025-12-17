// Custom Exception
class WrongAge extends Exception {
    WrongAge(String msg) {
        super(msg);
    }
}

// Base class
class Father {
    int fage;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        fage = age;
        System.out.println("Father's age set to: " + fage);
    }
}

// Derived class
class Son extends Father {
    int sage;

    Son(int fage, int sage) throws WrongAge {
        super(fage);   // Call Father constructor

        if (sage >= fage) {
            throw new WrongAge("Son's age must be less than Father's age");
        }
        this.sage = sage;
        System.out.println("Son's age set to: " + this.sage);
    }
}

// Main class
public class ExceptionInheritanceDemo {
    public static void main(String[] args) {
        try {
            Son s = new Son(50, 25);
            System.out.println("Object created successfully");
        } catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
