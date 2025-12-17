class CollegeThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); // 10 seconds
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class DeptThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); // 2 seconds
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        CollegeThread t1 = new CollegeThread();
        DeptThread t2 = new DeptThread();

        t1.start();
        t2.start();
    }
}

