import java.util.Scanner;

public class Dayere_moshtarak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble(), y1 = input.nextDouble(), r1 = input.nextDouble();
        double x2 = input.nextDouble(), y2 = input.nextDouble(), r2 = input.nextDouble();
        double D = Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
        if (D >= r1 + r2) {
            System.out.println("0.000");
        } else if (D <= Math.abs(r1 - r2) && (r1 < r2)) {
            double big = Math.PI * (r1 * r1);
            double big1 = (Math.floor(big * 1000)) / 1000;
            System.out.format("%.3f", big1);

        } else if (D <= Math.abs(r1 - r2) && (r1 > r2)) {
            double little = Math.PI * (r2 * r2);
            double little1 = (Math.floor(little * 1000)) / 1000;
            System.out.format("%.3f", little1);
        } else {
            double temp;
            if (r2 < r1) {
                temp = r2;
                r2 = r1;
                r1 = temp;
            }
            double FirstPart = Math.acos((D * D + r1 * r1 - r2 * r2) / (2 * D * r1)) * 2;
            double SecondPart = Math.acos((D * D + r2 * r2 - r1 * r1) / (2 * D * r2)) * 2;
            double Area52 = 0.5 * FirstPart * (r1 * r1) - 0.5 * (r1 * r1) * Math.sin(FirstPart);
            double Area51 = 0.5 * SecondPart * (r2 * r2) - 0.5 * (r2 * r2) * Math.sin(SecondPart);
            double masahat = Area51 + Area52;
            double ghat = (Math.floor(masahat * 1000)) / 1000;
            System.out.format("%.3f", ghat);

        }
    }
}