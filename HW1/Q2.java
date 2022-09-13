import java.util.Scanner;

public class Shebhe_avval {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tedad = input.nextInt();
        for (int i = 0; i < tedad; i++) {
            int counter = 0;
            int adad = input.nextInt();
            for (int j = 1; j < adad; j++) {
                if (adad % j == 0)
                    counter++;
            }
            if (counter == 2)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
