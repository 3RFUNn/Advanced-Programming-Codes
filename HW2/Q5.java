import java.util.Scanner;

public class Epinedrum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String vorudi = scn.next();
        int shart1 = 0, shart2 = 0, shart3 = 0, shart4 = 0, shart5 = 0;
        if (vorudi.endsWith(".net") || vorudi.endsWith(".com")) {
            shart3 = 1;
        }
        if (vorudi.charAt(0) == 'a' || vorudi.charAt(0) == 'A' || vorudi.charAt(0) == 'E' || vorudi.charAt(0) == 'e' || vorudi.charAt(0) == 'O' || vorudi.charAt(0) == 'o' ||
                vorudi.charAt(0) == 'I' || vorudi.charAt(0) == 'i' || vorudi.charAt(0) == 'u' || vorudi.charAt(0) == 'U') {
            shart1 = 1;
        }
        int sar = 0, tah = 0, komaki1 = 0, komaki2 = 0;
        for (int i = 0; i < vorudi.length(); i++) {
            if (Character.isDigit(vorudi.charAt(i))) {
                shart2++;

                if (shart2 == 1 && komaki1 == 0) {
                    sar = i;
                    komaki1++;
                }
                if (shart2 == 2 && komaki2 == 0) {
                    tah = i;
                    komaki2++;
                }
            }
        }
        for (int i = 0; i < vorudi.length(); i++) {
            if (vorudi.charAt(i) == '@' && i > sar && i < tah) {
                shart4++;
            }
        }
        for (int i = 0; i < vorudi.length(); i++) {
            if (vorudi.charAt(i) == '@') {
                shart5++;
            }
        }
        if (shart1 == 1 && shart2 == 2 && shart3 == 1 && shart4 >= 1 && shart5 == shart4) {
            System.out.println("YES");
        } else System.out.println("NO");


    }
}
