import java.util.Scanner;

public class IllegalTriangleException extends Exception {
        IllegalTriangleException(){
            super();
        }
        public void validation(int r1,int r2,int r3) throws IllegalTriangleException{
                if(r1>=r2+r3 || r2>=r3+r1 || r3>=r1+r2){
                    throw new IllegalTriangleException();
                }else System.out.println("Valid triangle");
        }
}
class test{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int r1,r2,r3;
        try {
            IllegalTriangleException i1=new IllegalTriangleException();
            r1=scn.nextInt();
            r2=scn.nextInt();
            r3=scn.nextInt();
            i1.validation(r1,r2,r3);
        }catch (IllegalTriangleException e){
            System.out.println("You can't make triangle");
        }
    }
}
