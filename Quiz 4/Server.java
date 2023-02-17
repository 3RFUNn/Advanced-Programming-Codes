import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static int number = 0;
    public static long code = ((long) (Math.random() * 90000)) + 10000;
    static Map<String, ClientHandler> users;

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(3000);

        users = new ConcurrentHashMap<>();

        while (true) {
            Socket socket = serverSocket.accept();    
            ClientHandler temp = new ClientHandler(socket);// creat
            number++;
            (new Thread(temp)).start();
        }

    }

    static class ClientHandler implements Runnable {

        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        ClientHandler(Socket socket) throws Exception {
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
                while (Server.number < 5) {

                }
                boolean isUsernameOk = false;
                String username = "";
                while (!isUsernameOk) {
                    username = this.dis.readUTF();
                    if (Server.users.containsKey(username)) {
                        String errorMessage = "err: UserName already exists... please enter another one: ";
                        this.dos.writeUTF(errorMessage);
                    } else {
                        String okMessage = "OK: Username was OK.";
                        this.dos.writeUTF(okMessage);
                        isUsernameOk = true;
                    }
                }

                System.out.println("The Game is on");
                Server.users.put(username, this);

                while (true) {
                    String message = this.dis.readUTF();
                    long code = Long.parseLong(message);
                    if (code == Server.code) {
                        System.out.println(username + "won the round");
                        this.dos.writeUTF("you won");
                        Server.code = ((long) Math.random() * 90000) + 10000;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
