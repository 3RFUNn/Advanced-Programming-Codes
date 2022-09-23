import java.util.Scanner;
public class Maghlub {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long adad = input.nextLong();
        long first = input.nextLong();
        long last = input.nextLong();
        if (first == last) {
            System.out.println(adad);
            return;
        }
        long counter = 0;
        long num = adad;
        while (adad > 0) {
            adad /= 10;
            counter++;
        }
        long rast = (long) (num % (Math.pow(10, counter - last)));
        long chap = (long) Math.floor((num / (Math.pow(10, counter - first + 1))));
        long adad_asli = (long) ((num / (Math.pow(10, counter - last))) % Math.pow(10, last - first + 1));
        long m = 0;
        while (adad_asli > 0) {
            m += adad_asli % 10;
            m *= 10;
            adad_asli /= 10;
        }
        System.out.println((long) (rast + (m * Math.pow(10, counter - last - 1)) + chap * Math.pow(10, counter - first + 1)));

    }
}
