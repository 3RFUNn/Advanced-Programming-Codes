import java.util.Scanner;

public class Zir_donbale {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tedad, max = -9000, tool = 1, sar = 0, tah = 0;
        tedad = scn.nextInt();
        int[] vorudi = new int[tedad];
        for (int i = 0; i < vorudi.length; i++) {
            vorudi[i] = scn.nextInt();
        }
        for (int i = 0; i < vorudi.length; i++) {
            for (int m = 0; i < vorudi.length - m; m++) {
                int sum = 0;
                for (int k = i; k < vorudi.length - m; k++) {
                    sum += vorudi[k];
                }

                if (sum > max) {
                    sar = i;
                    tah = vorudi.length - m;
                    tool = vorudi.length - m - i;
                    max = sum;
                }
                if (sum == max) {
                    if (vorudi.length - m - i > tool) {
                        sar = i;
                        tah = vorudi.length - m;
                    }
                }
            }
        }
        for (int i = sar; i < tah; i++) {
            System.out.print(vorudi[i] + " ");
        }
    }
}
