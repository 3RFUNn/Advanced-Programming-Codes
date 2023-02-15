import java.util.Scanner;

public class Calculator extends Exception {
    Calculator() {
        super();
    }
}

class Sum_Sub_Mult_Div extends Calculator {
    public void Sum(String n1, String n2) {
        int num1 = 0, num2 = 0;
        try {
            num1 = Integer.parseInt(n1);
            num2 = Integer.parseInt(n2);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return;
        }
        System.out.println("your answer is : " + (num1 + num2));
    }

    public void Sub(String n1, String n2) {
        int num1 = 0, num2 = 0;
        try {
            num1 = Integer.parseInt(n1);
            num2 = Integer.parseInt(n2);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return;
        }
        System.out.println("your answer is : " + (num1 - num2));
    }

    public void Mult(String n1, String n2) {
        int num1 = 0, num2 = 0;
        try {
            num1 = Integer.parseInt(n1);
            num2 = Integer.parseInt(n2);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return;
        }
        System.out.println("your answer is : " + (num1 * num2));
    }

    public void Div(String n1, String n2) {
        int num1 = 0, num2 = 0;
        try {
            num1 = Integer.parseInt(n1);
            num2 = Integer.parseInt(n2);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return;
        }
        if (num2 == 0) {
            throw new ArithmeticException();
        }
        System.out.println("your answer is : " + (num1 / num2));
    }

}

class Jazr extends Calculator {
    Jazr() {
        super();
    }

    public void jazr(String num1) throws Jazr {
        int num = 0;
        try {
            num = Integer.parseInt(num1);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return;
        }
        if (num < 0) {
            throw new Jazr();
        }
        System.out.println("your answer is : " + (int) Math.sqrt(num));
    }
}

class test2 {
    public static void main(String[] args) {
        Sum_Sub_Mult_Div s1 = new Sum_Sub_Mult_Div();
        Jazr j1 = new Jazr();
        Scanner scn = new Scanner(System.in);
        String num1, num2;
        int vorudi;
        while (true) {
            System.out.println("Welcome to the Calculator!\nChoose your operation :(Enter entry number)");
            System.out.println("1.\tJam(+)\n2.\tTafrigh(-)\n3.\tZarb(x)\n4.\tTaghsim(/)\n5.\tJazr(\u221A)");
            while (true) {
                vorudi = scn.nextInt();
                if (vorudi >= 1 && vorudi <= 5) {
                    break;
                } else System.out.println("wrong entry try again!");
            }
            switch (vorudi) {
                case 1:
                    System.out.println("first number : ");
                    num1 = scn.next();
                    System.out.println("second number : ");
                    num2 = scn.next();
                    s1.Sum(num1, num2);
                    break;
                case 2:
                    System.out.println("first number : ");
                    num1 = scn.next();
                    System.out.println("second number : ");
                    num2 = scn.next();
                    s1.Sub(num1, num2);
                    break;
                case 3:
                    System.out.println("first number : ");
                    num1 = scn.next();
                    System.out.println("second number : ");
                    num2 = scn.next();
                    s1.Mult(num1, num2);
                    break;

                case 4:
                    System.out.println("first number : ");
                    num1 = scn.next();
                    System.out.println("second number : ");
                    num2 = scn.next();
                    try {
                        s1.Div(num1, num2);
                    } catch (ArithmeticException a1) {
                        System.out.println(a1);
                    }
                    break;
                case 5:
                    System.out.println("enter number : ");
                    num1 = scn.next();
                    try {
                        j1.jazr(num1);
                    } catch (Jazr j2) {
                        System.out.println("Invalid number is given !");
                    }
                    break;
            }
            System.out.println("___________________________");
            System.out.println("would you like to do another operation?(enter number)\n1.\tYes\n2.\tNo\n");
            int operation;
            while (true) {
                operation = scn.nextInt();
                if (operation == 1 || operation == 2) {
                    break;
                } else System.out.println("wrong entry try again !");
            }
            if (operation == 2) {
                break;
            }

        }
    }
}
