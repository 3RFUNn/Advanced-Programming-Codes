import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Barbar {
    public static ArrayList<String>[][] darhaleersal = new ArrayList[100][1000];
    public static ArrayList<String>[][] ersalshode = new ArrayList[100][1000];
    private static String[] carrierUser = new String[100];
    private static String[] carrierPass = new String[100];
    private static int[] darhalersaladad = new int[100];
    private static int[] ersalshodeadad = new int[100];
    private static double[] hajmecar = new double[100];
    private static double[] hajmedarhaleersal = new double[100];
    private static double[] hajmeersalshode = new double[100];

    public static ArrayList<String> getErsalshode(int i,int j) {
        return ersalshode[i][j];
    }

    public static double getHajmeersalshode(int i) {
        return hajmeersalshode[i];
    }

    int[] carrierCar = new int[100];
    double motor = 0.5, vanet = 12, khodro = 2;
    public static int bb = 0;
    Scanner scn = new Scanner(System.in);

    public void hajmsaz() {
        for (int i = 0; i < 100; i++) {
            hajmecar[i] = 0;
            hajmedarhaleersal[i] = 0;
            hajmeersalshode[i] = 0;
        }
    }

    public void ersalsaz() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                darhaleersal[i][j] = new ArrayList<String>();
                ersalshode[i][j] = new ArrayList<String>();
            }
        }
    }

    public void adadbarbar() {
        for (int i = 0; i < 100; i++) {
            darhalersaladad[i] = 0;
            ersalshodeadad[i] = 0;
        }
    }

    public void darhalersal() {
        barbaruserpass();
        System.out.println("which moshtari would you like to ersal?");
        int ct = Moshtari.getCt();
        for (int i = 0; i < Moshtari.kharide.length; i++) {
            System.out.println(i + "." + Moshtari.getCustomerUser(i));
        }
        int adadersali = scn.nextInt();
        System.out.println("which jens would you like to add to ersali?");
        for (int i = 0; i < Moshtari.kharide[ct].length; i++) {
            System.out.println(i + "." + Moshtari.kharide[adadersali][i]);
        }
        int jensadad;
        jensadad = scn.nextInt();
        if (Moshtari.getCustomerhajmkharid(adadersali, jensadad) <= hajmecar[barbarnumber]) {
        } else {
            System.out.println("cannot add this to barbar!");
            return;
        }

        darhaleersal[barbarnumber][darhalersaladad[barbarnumber]].addAll(Moshtari.kharide[adadersali][jensadad]);
        hajmedarhaleersal[barbarnumber] += Moshtari.getCustomerhajmkharid(adadersali, jensadad);
        Moshtari.kharide[adadersali][jensadad].clear();
        Moshtari.getJensmoshtari(adadersali);
        darhalersaladad[barbarnumber]++;
    }

    public void ersalshode() {
        barbaruserpass();
        System.out.println("which jens would u like to tahvil?");
        for (int i = 0; i < darhaleersal.length; i++) {
            System.out.println(i + "." + Arrays.toString(darhaleersal[i]));
        }
        int tahviladad = scn.nextInt();

        System.out.println("choose your jens?");
        for (int i = 0; i < darhaleersal[tahviladad].length; i++) {
            System.out.println(i + "." + darhaleersal[tahviladad][i]);
        }
        int jensadad = scn.nextInt();
        ersalshode[barbarnumber][ersalshodeadad[barbarnumber]].addAll(darhaleersal[tahviladad][jensadad]);
        hajmeersalshode[barbarnumber] += hajmedarhaleersal[barbarnumber];
        hajmedarhaleersal[barbarnumber] = 0;
        darhaleersal[tahviladad][jensadad].clear();
        darhalersaladad[barbarnumber]--;
        ersalshodeadad[barbarnumber]++;


    }

    public int barbarnumber;

    public void barbaruserpass() {
        System.out.println("which barbar are you?(enter number)");

        for (int i = 0; i < bb; i++) {
            System.out.println(i + "." + carrierUser[bb]);
        }
        while (true) {
            barbarnumber = scn.nextInt();
            if (barbarnumber >= 0 && barbarnumber < bb) {
                break;
            } else System.out.println("try again!");
        }
        System.out.println("give password?");
        String pass;
        while (true) {
            pass = scn.nextLine();
            if (pass.equals(carrierPass[barbarnumber])) {
                break;
            } else System.out.println("try again!");
        }
    }

    public void AddBarbar() {
        System.out.println("set barbar username:");
        carrierUser[bb] = scn.nextLine();
        System.out.println("set carrier password:");
        carrierPass[bb] = scn.nextLine();
        while (true) {
            System.out.println("what kind of vehicle do you want for the carrier?\nEnter number:\n1.\tmotor\n2.\tvanet\n3.\tkhodro");
            carrierCar[bb] = scn.nextInt();
            if (carrierCar[bb] == 1 || carrierCar[bb] == 2 || carrierCar[bb] == 3) {
                break;
            } else System.out.println("wrong number try again!");
        }
        if (carrierCar[bb] == 1) {
            hajmecar[bb] = motor;
        } else if (carrierCar[bb] == 2) {
            hajmecar[bb] = vanet;
        } else if (carrierCar[bb] == 3) {
            hajmecar[bb] = khodro;
        }
        bb++;
    }

    public void changecar() {
        System.out.println("which barbar are you?");
        for (int i = 0; i < bb; i++) {
            System.out.println(i + "." + carrierUser[i]);
        }
        int number;
        while (true) {
            number = scn.nextInt();
            if (number >= 0 && number <= bb) {
                break;
            } else System.out.println("wrong entry try again!");
        }
        System.out.println("what kind of vehicle do you want for the carrier?\nEnter number:\n1.\tmotor\n2.\tvanet\n3.\tkhodro");
        while (true) {
            int adadmashin = scn.nextInt();
            if (adadmashin == 1 || adadmashin == 2 || adadmashin == 3) {
                carrierCar[number] = scn.nextInt();
                break;
            } else System.out.println("wrong entry try again!");

        }
        if (carrierCar[number] == 1) {
            hajmecar[number] = motor;
        } else if (carrierCar[number] == 2) {
            hajmecar[number] = vanet;
        } else if (carrierCar[number] == 3) {
            hajmecar[number] = khodro;
        }
    }
}
