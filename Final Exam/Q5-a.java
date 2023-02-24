import java.io.DataInputStream;
        import java.io.DataOutputStream;
        import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
        import java.net.UnknownHostException;
        import java.util.Scanner;

class Client {

    public static void main(String arg[]) throws UnknownHostException, IOException {
        try {


            boolean isContinue = true;

            while (isContinue) {
                System.out.println("Which operation do you want to perform ? Please enter index number: ");
                boolean isValid = false;
                Scanner scanner = new Scanner(System.in);
                String selected = null;
                while (!isValid) {

                    System.out.println("1. Add");
                    System.out.println("2. Sub");
                    System.out.println("3. Multiply");
                    System.out.println("4. Divide");

                    int selection = scanner.nextInt();

                    switch (selection) {

                        case 1:
                            selected = "add";
                            isValid = true;
                            break;
                        case 2:
                            selected = "sub";
                            isValid = true;
                            break;
                        case 3:
                            selected = "mul";
                            isValid = true;
                            break;
                        case 4:
                            selected = "div";
                            isValid = true;
                            break;
                        default:
                            System.out.println("Invalid choice : ");
                            isValid = false;
                            break;
                    }
                }
                System.out.println("Please enter two parameters for this operation:");
                System.out.println("Param 1 :");
                int first = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Param 2 :");
                int second = scanner.nextInt();
                Socket opSocket = new Socket("localhost", 1234);
                DataOutputStream opToClient = new DataOutputStream(opSocket.getOutputStream());
                opToClient.writeInt(first);
                opToClient.writeInt(second);
                opToClient.writeUTF(selected);
                DataInputStream opInStream = new DataInputStream(opSocket.getInputStream());
                String ans = opInStream.readUTF();
                System.out.println(ans);
                isContinue = false;
            }
        }catch (Exception e){System.out.println(e);}
        }
    }
    class connector{
        public static void main(String []arg) throws IOException{


            try{

                while(true){
                    ServerSocket serverSocket = new ServerSocket(1234);
                    Socket sc = serverSocket.accept();
                    try{
                        System.out.println("Getting Main Request.. ");
                        DataInputStream inFromClient = new DataInputStream(sc.getInputStream());
                        int first = inFromClient.readInt();
                        int second = inFromClient.readInt();
                        String selected =inFromClient.readUTF();
                        int port =1234;
                        Socket opSocket = new Socket("localhost", port);
                        DataOutputStream opToClient = new DataOutputStream(opSocket.getOutputStream());
                        opToClient.writeInt(first);
                        opToClient.writeInt(second);
                        opToClient.writeUTF(selected);
                        DataInputStream opInStream = new DataInputStream(opSocket.getInputStream());
                        String ans = opInStream.readUTF();
                        DataOutputStream outFromClient = new DataOutputStream(sc.getOutputStream());
                        outFromClient.writeUTF(ans);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    finally{
                        sc.close();
                        serverSocket.close();
                    }
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }
    class server{
        public static void main(String []arg) throws IOException{


            try{

                while(true){
                    ServerSocket serverSocket = new ServerSocket(1234);
                    Socket sc = serverSocket.accept();
                    try{
                        System.out.println("Getting Request.. ");
                        DataInputStream inFromClient = new DataInputStream(sc.getInputStream());
                        int first = inFromClient.readInt();
                        int second = inFromClient.readInt();
                        String selected=inFromClient.readUTF();
                        PrintWriter pr = new PrintWriter(sc.getOutputStream(),true);
                        int answer = 0;
                        if(selected.equals("add")) {
                            answer = first + second;
                        }else if (selected.equals("sub")){
                            answer=first-second;
                        }else if(selected.equals("div")){
                            answer=first/second;
                        }else if(selected.equals("mul")){
                            answer=first*second;
                        }

                        DataOutputStream outFromClient = new DataOutputStream(sc.getOutputStream());

                        outFromClient.writeUTF("Answer of operation is :"+answer);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    finally{
                        sc.close();
                        serverSocket.close();
                    }
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }
