import java.util.Scanner;
import java.lang.Math;

public class Triangle_masahat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            double tool = input.nextDouble();
            if (tool != -1) {
                double masahat = (Math.pow(3, 0.5) / 4.0) * (Math.pow(tool, 2.0));
                System.out.format("%.4f\n", masahat);
            } else
                break;
        }
    }
}
