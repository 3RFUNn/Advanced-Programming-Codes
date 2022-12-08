import java.util.Scanner;

public class AzInMatrisa {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int satr, sotoon;
        satr=scn.nextInt();
        sotoon=scn.nextInt();
        int tartib=0;
        int max=0;
        int[][] array=new int[satr][sotoon];
        int[] counter= new int[sotoon];
        for (int i = 0; i <sotoon ; i++) {
            counter[i]=0;
        }
        for (int i = 0; i <satr ; i++) {
            for (int j = 0; j <sotoon ; j++) {
                array[i][j]=scn.nextInt();
            }
        }
        for (int i = 0; i <sotoon ; i++) {
            for (int j = 0; j <satr ; j++) {
                if(array[j][i]==0){
                    counter[i]++;
                }
            }
            if(i==0){
                max=counter[i];
            }
            if(counter[i]<=max){
                tartib=i;
            }
        }
        for (int i = 0; i <satr ; i++) {
            System.out.println(array[i][tartib]);
        }
    }
}
