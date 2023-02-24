import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LATARI {
    public static int Counter = 1;
    public static long Number;
    static Map<String, ClientHandler> users;
    static List<ClientHandler> SynList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8800);

        Number = ((long) (Math.random() * 90000)) + 10000;
        System.out.println(Number);
        users = new ConcurrentHashMap<>();

        while (true) {
            Socket SKT = serverSocket.accept();
            ClientHandler temp = new ClientHandler(SKT);
            (new Thread(temp)).start();
        }
    }
}

class ClientHandler implements Runnable {
    protected DataOutputStream DOS;
    protected boolean player = false;
    protected DataInputStream DIS;


    ClientHandler(Socket socket) throws IOException {
        this.DIS = new DataInputStream(socket.getInputStream());
        this.DOS = new DataOutputStream(socket.getOutputStream());

    }

    @Override
    public void run() {

        try {
            boolean UserOk = true;
            String UserID = "";
            while (UserOk) {
                UserID = this.DIS.readUTF();
                if (LATARI.users.containsKey(UserID)) {
                    String ErrorMSG;
                    ErrorMSG = "err: UserName exists... " +
                            "enter another one: ";
                    this.DOS.writeUTF(ErrorMSG);
                } else {
                    String OKMSG;
                    OKMSG = "username is acceptable";
                    this.DOS.writeUTF(OKMSG);
                    UserOk = false;
                }
            }
            LATARI.users.put(UserID, this);
            ClientHandler targetHandler = LATARI.users.get(UserID);
            LATARI.SynList.add(targetHandler);
            System.out.println("User " + UserID + " is Connected!");

            DOS.writeUTF("THe game starts!");

            while (true) {
                while (!player) {
                    String msg = DIS.readUTF();
                    long answer = Long.parseLong(msg);
                    if (answer != LATARI.Number) {
                        DOS.writeUTF("Wrong number try again");

                    } else {
                        DOS.writeUTF(" yayyy You Won!");
                        LATARI.SynList.remove(targetHandler);
                        LATARI.Counter++;
                        LATARI.Number = ((long) (Math.random() * 90000)) + 10000;
                        System.out.println("the latari code is " + LATARI.Number);
                        player = false;
                    }
                }
                for (int i = 0; i < LATARI.SynList.size(); i++) {
                    ClientHandler Handler = LATARI.SynList.get(i);
                    Handler.DOS.writeUTF(UserID + " Won the Game!");
                    Handler.DOS.writeUTF("get ready new Round " + LATARI.Counter + " has begun!");
                }
                LATARI.SynList.add(targetHandler);
                player = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

