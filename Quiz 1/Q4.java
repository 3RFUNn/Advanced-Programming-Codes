import java.util.Scanner;

public class Pool {
    public static double hughugh = 10000;
    public static Scanner scn = new Scanner(System.in);

    public void morakhassi() {
        String javab, javab2;
        int who, roozoff;
        double pay;
        System.out.println("who are you?\n1.accountant\n2.salesman\n3.labor\n");
        while (true) {
            who = scn.nextInt();
            if (who == 1 || who == 2 || who == 3) {
                break;
            } else System.out.println("wrong entry try again!");
        }
        System.out.println("are you off?");
        javab2 = scn.nextLine();
        if (javab2.equals("no")) {
            return;
        } else {
            System.out.println("Is morakhasi pezeshki?(1.yes\n2.no)");
            javab = scn.nextLine();
            if (javab.equals("no")) {
                System.out.println("chand rooz off mishavi?");
                roozoff = scn.nextInt();
                if (roozoff >= 3) {
                    if (who == 1) {
                        pay = accountant.daramad * 0.92;
                        System.out.println("your daramad is " + pay);
                        System.out.println("everybody accountant is off");

                    }
                    if (who == 2) {
                        pay = salesman.salesmandaramad * 0.95;
                        System.out.println("your daramad is " + pay);
                        System.out.println("everybody salesman is off");

                    } else {
                        pay = labor.laborpool * 0.95;
                        System.out.println("your daramad is " + pay);
                        System.out.println("everybody labor is off");

                    }
                }
            }
            if (javab.equals("yes")) {
                System.out.println("morahassi ghabul ast");

            }
        }
    }
}

class accountant extends Pool {
    public static double daramad = hughugh * 1.4;
    public static int id = 123;
}

class salesman extends Pool {
    public static double salesmandaramad = hughugh * 1.2;
    public static int id = 456;
}

class labor extends Pool {
    public static double laborpool = hughugh;
    public static int id = 789;
}
class test {
    public static void main(String[] args) {
        Pool p1 = new Pool();
        p1.morakhassi();
    }
}


