import java.util.ArrayList;
import java.util.Scanner;

public class Moshtari {
    double[] hazine=new double[100];
    public static int ct=0;
    Scanner scn=new Scanner(System.in);
    private static double[] poolmoshtari=new double[100];
    private static String[] customerUser=new String[100];
    private static String[] customerPass=new String[100];
    private static double[][] customerhajmkharid=new double[100][1000];
    private static int[] jensmoshtari=new int[100];
    private static double[][] pooljensmoshtari=new double[100][1000];
    public static ArrayList<String>[][] kharide = new ArrayList[100][1000];
    public void kharidesaz(){
        for (int i = 0; i <100 ; i++) {
            for (int j = 0; j <1000 ; j++) {
                kharide[i][j]=new ArrayList<String>();
                customerhajmkharid[i][j]=0;
            }
        }
    }
    public void poolmoshtari(){
        for (int i = 0; i <100 ; i++) {
            poolmoshtari[i]=0;
        }
    }

    public void jensmoshtari(){
        for (int i = 0; i <100 ; i++) {
            poolmoshtari[i]=0;
        }
    }
    public void moshtarisaz() {
        String name;
        System.out.println("set moshtari name: ");
        while (true) {
            name = scn.nextLine();
            for (int i = 0; i < 100; i++) {
                if (name.equalsIgnoreCase(customerUser[i])) {
                    System.out.println("username already taken try again!");
                    break;
                } else customerUser[ct] = name;


            }
            customerUser[ct]=name;
            break;
        }
        System.out.println("set moshtari pass:");
        String passmoshtari;
        passmoshtari=scn.nextLine();
        customerPass[ct]=passmoshtari;
        ct++;
    }
    public int moshtarinumber;
  public void moshtariuserpass(){
      System.out.println("which moshtari are you?(enter number)");

      for (int i = 0; i <ct ; i++) {
          System.out.println(i+"."+customerUser[ct]);
      }
      while (true){
          moshtarinumber=scn.nextInt();
          if(moshtarinumber>=0 && moshtarinumber<ct){
              break;
          }else System.out.println("try again!");
      }
      System.out.println("give password?");
      String pass;
      while (true){
          pass=scn.nextLine();
          if(pass.equals(customerPass[moshtarinumber])){
              break;
          }else System.out.println("try again!");
      }

    }
    public void listaddikharid(){
        moshtariuserpass();
        Tolikonande t1=new Tolikonande();
        int tolidadad;
        System.out.println("which tolidkonande do you want?");
        t1.printtolidkonande();
        while (true){
            tolidadad=scn.nextInt();
            if(tolidadad>=0 && tolidadad< Tolikonande.getTk()){
                break;
            }else System.out.println("wrong try again!");
        }
        t1.ajnas(tolidadad);
        System.out.println("which jens do you want?(to exit enter number -1)");
        int jensadad;
        while (true){
            jensadad=scn.nextInt();
            if(jensadad==-1){
                break;}

                kharide[ct][jensmoshtari[ct]].addAll(Tolikonande.kala[tolidadad][jensadad]);
                poolmoshtari[moshtarinumber]+=Tolikonande.getPooljens(tolidadad,jensadad);
                customerhajmkharid[ct][jensmoshtari[ct]]+=Tolikonande.getHajmjens(tolidadad,jensadad);
                jensmoshtari[ct]++;


        }


    }
    public void Dastebandi(){
        moshtariuserpass();
        System.out.println("which daste bandi kala would you like to see?");
        System.out.println("1.khoraki\t\n2.\tpooshak\n3.\telectric\n");
        String jens=scn.nextLine();
        for (int i = 0; i <Tolikonande.kala.length ; i++) {
            for (int j = 0; j <Tolikonande.kala[i].length ; j++) {
                System.out.print(i+"."+j+".");
                if(Tolikonande.kala[i][j].contains(jens)){
                    System.out.print(Tolikonande.kala[i][j]);
                }
                System.out.println();
            }

        }
        int row,column;
        System.out.println("enter first and second number of product:");
        while (true) {
            System.out.println("first number is:");
            row = scn.nextInt();

            System.out.println("second number is:");
            column = scn.nextInt();
            if(Tolikonande.kala[row][column].contains("Null") || Tolikonande.kala[row][column].contains("null")){
                System.out.println("wrong entry try again!");
            }else break;
        }
        kharide[moshtarinumber][jensmoshtari[moshtarinumber]].addAll(Tolikonande.kala[row][column]);
        poolmoshtari[moshtarinumber]+=Tolikonande.getPooljens(row,column);
        customerhajmkharid[moshtarinumber][jensmoshtari[moshtarinumber]]+=Tolikonande.getHajmjens(row,column);
        jensmoshtari[moshtarinumber]++;
    }
    public void didanelistkharid(){
      moshtariuserpass();
        for (int i = 0; i <kharide[moshtarinumber].length ; i++) {
            System.out.println(i+"."+kharide[moshtarinumber][i]);
        }
    }
    public void didanelistkharid2(){
        for (int i = 0; i <kharide.length ; i++) {
            for (int j = 0; j<kharide[i].length ; j++) {
                System.out.println(i + "."+ j + "."+ kharide[moshtarinumber][i]);
            }
        }
    }


    public static int getCt() {
        return ct;
    }

    public static double getPoolmoshtari(int i) {
        return poolmoshtari[i];
    }

    public static String getCustomerUser(int i) {
        return customerUser[i];
    }

    public static void getJensmoshtari(int i) {
        jensmoshtari[i]--;
    }

    public static double getCustomerhajmkharid(int i,int j) {
        return customerhajmkharid[i][j];
    }
}
