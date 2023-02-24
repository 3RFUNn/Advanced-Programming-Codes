import java.util.Scanner;

public class Lift {
    private int floor;
    private int noPersons;
    private int capacity;

    public Lift() {

    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNoPersons(int noPersons) {
        this.noPersons = noPersons;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFloor() {
        return floor;
    }

    public int getNoPersons() {
        return noPersons;
    }
}

class IllegalFloor extends Exception {
    IllegalFloor() {
        super();
    }

    public void validation(int f) throws IllegalFloor {
        if (f > 50 || f < -5) {
            throw new IllegalFloor();
        }
    }
}

class IllegalLoad extends Exception {
    IllegalLoad() {
        super();
    }

    public void valid(int c) throws IllegalLoad {
        if (c < 0 || c > 450) {
            throw new IllegalLoad();
        }
    }
}

class test {
    public static void main(String[] args) {
        Lift l1 = new Lift();
        IllegalFloor f1 = new IllegalFloor();
        IllegalLoad load = new IllegalLoad();
        while (true) {
            System.out.println("hello which floor you want to go?");
            Scanner scn = new Scanner(System.in);
            l1.setFloor(scn.nextInt());
            try {
                f1.validation(l1.getFloor());
                break;
            } catch (IllegalFloor e) {
                System.out.println("invalid floor!");
            }

        }
        while (true) {
            System.out.println("how much capacity?");
            Scanner scn = new Scanner(System.in);
            l1.setCapacity(scn.nextInt());
            try {
                load.valid(l1.getCapacity());
                break;
            } catch (IllegalLoad e) {
                System.out.println("Load exceeds capacity!");
            }

        }
        System.out.println("you may proceed");
    }
}
