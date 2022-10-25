import javax.swing.*;
import java.util.Scanner;

public class Admin {
    static private String username,username1;
    static private String pass,password1;
    public static Scanner scn=new Scanner(System.in);
    Tolikonande[] maker=new Tolikonande[100];
    public static int bb=0;
    Barbar[] carrier=new Barbar[100];
    private static String[] carrierUser=new String[100];
    private static String[] carrierPass=new String[100];
    int[] carrierCar=new int[100];
    Moshtari[] customer=new Moshtari[100];

    public Admin(){
        System.out.println("welcome create your user pass admin :)");
        System.out.println("Set your username:");
        username=scn.nextLine();
        System.out.println("set your password:");
        pass=scn.nextLine();
    }
    public static void checkpass(){
        while (true) {
            System.out.println("enter your username:");
            username1 = scn.nextLine();
            System.out.println("enter your password:");
            password1 = scn.nextLine();
            if(username1.equals(username) && pass.equals(password1)){
                break;
            }else System.out.println("wrong entry try again!");

        }
    }



}
