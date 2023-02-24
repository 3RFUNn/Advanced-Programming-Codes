import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws Exception {
        Socket skt = new Socket("192.168.1.1", 8800);
        DataInputStream dis = new DataInputStream(skt.getInputStream());
        DataOutputStream Dos = new DataOutputStream(skt.getOutputStream());
        Scanner scn = new Scanner(System.in);



        boolean UserOk = true;
        while (UserOk) {
            System.out.println("Enter ur User plz: ");
            String username;
            username = scn.nextLine();
            Dos.writeUTF(username);
            String Valid;
            Valid = dis.readUTF();
            if (Valid.startsWith("OK"))
                UserOk = false;
            else
                System.out.println("wrong entry user already exists");
        }
        Thread Listener = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String payam = dis.readUTF();
                        System.out.println("Incoming message: " + payam);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Listener.start();

        String massege = dis.readUTF();
        System.out.println(massege);
        while (true) {
            System.out.println("Enter chance number:");
            String javab = scn.nextLine();
            Dos.writeUTF(javab);
        }
    }
}
