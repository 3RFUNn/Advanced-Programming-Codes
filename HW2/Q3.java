import java.util.Scanner;

public class Sansoorchi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tedad = scn.nextInt();
        for (int j = 0; j < tedad; j++) {

            String kalame = scn.next();
            String fosh = scn.next();

            for (int i = 0; i < kalame.length(); i++) {
                if (kalame.contains(fosh)) {
                    kalame = kalame.replace(fosh, "");

                }
            }
            System.out.println(kalame);
        }
    }
}
