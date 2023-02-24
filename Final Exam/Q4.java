import java.io.File;
import java.util.*;

class PhoneBook {
    public static void main(String[] args) {
        try {

            Scanner vorudi = new Scanner(System.in);
            Scanner scanner = null;
            File file1 = new File("c://files//file.txt");
            try {
                scanner = new Scanner(file1);
            } catch (Exception e) {
                System.out.println("reading files error!");
            }
            Map<String, String> daftartelephone = new HashMap<>();
            assert scanner != null;
            while (scanner.hasNext()) {
                String khat = scanner.nextLine();
                String[] moshakhassat = khat.split(" ");
                daftartelephone.put(moshakhassat[0] + moshakhassat[1], moshakhassat[2]);
            }
            System.out.println("Enter your name :");
            String name = vorudi.nextLine();
            while (true) {
                for (int i = 0; i < daftartelephone.size(); i++) {
                    if (daftartelephone.containsKey(name)) {
                        System.out.println(daftartelephone.get(name));
                    }
                }
                break;
            }
                System.out.println("Enter your number");
                String number = vorudi.next();
                daftartelephone.put(name, number);

            Set set1 = daftartelephone.keySet();
            Iterator fileITR = set1.iterator();
            while (fileITR.hasNext()) {
                String str = (String) fileITR.next();
                System.out.println(str + " : " + daftartelephone.get(str));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

