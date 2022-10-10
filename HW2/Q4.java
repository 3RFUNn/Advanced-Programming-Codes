import java.util.Scanner;

public class Duel {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String azaye_ghabile = scn.next();
        String bokosh = "()";
        int tedad = azaye_ghabile.length();

        for (int i = 0; i < tedad; i++) {
            if (azaye_ghabile.contains(bokosh)) {
                azaye_ghabile = azaye_ghabile.replace(bokosh, "");

            }
        }
        System.out.println(azaye_ghabile.length());
    }
}
