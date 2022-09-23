import java.util.Scanner;
public class Charkhesh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long vurudi = input.nextLong();
        int charkhesh = input.nextInt();
        String adad = Long.toHexString(vurudi);
        int lengh = adad.length();
        if (charkhesh > lengh) {
            charkhesh %= lengh;
        }
        String bakhsh2 = adad.substring(0, lengh - charkhesh);
        String bakhsh1 = adad.substring(lengh - charkhesh, lengh);
        String javab = bakhsh1.concat(bakhsh2);
        if (javab.startsWith("0")) {
            javab = javab.substring(1, lengh);
        }
        System.out.println(javab);

    }
}
