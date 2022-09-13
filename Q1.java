
import java.util.Scanner;
public class Adad {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long adad=input.nextLong();
        int javab=0,max=0;
        for (int i = 0; i <=9 ; i++) {
            int counter=0;
            long temp=adad;
            while(temp>0){
                if(temp%10==i){
                    counter++;
                }
                temp/=10;

            }
            if(counter>max){
                max=counter;
                javab=i;
            }
        }
        System.out.print(javab);

    }
}
