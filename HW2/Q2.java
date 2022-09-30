import java.util.Scanner;

public class Charkhesh {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tedad = scn.nextInt();
        int[] vorudi = new int[tedad];
        for (int i = 0; i < vorudi.length; i++) {
            vorudi[i] = scn.nextInt();
        }
        int kuchik = vorudi[0], charkhesh = 0;
        for (int i = 0; i < vorudi.length; i++) {
            if (vorudi[i] < kuchik) {
                kuchik = vorudi[i];
                charkhesh = i;
            }
            if (vorudi[i] == kuchik) {
                if (i == vorudi.length - 1) {
                    charkhesh = vorudi.length - 1;
                }
            }
        }
        System.out.println(charkhesh);
    }
}
