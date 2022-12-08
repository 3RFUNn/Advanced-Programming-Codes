import java.util.Scanner;

class matrix {

    static void halazuni(int m, int n, int arr[][]) {
        int i, k = 0, l = 0, sum = 0, emtiaz = 0;


        while (k < m && l < n) {
            for (i = l; i < n; ++i) {
                sum += arr[k][i];
                if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0) {
                    emtiaz++;
                }
            }
            k++;

            for (i = k; i < m; ++i) {
                sum += arr[i][n - 1];
                if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0) {
                    emtiaz++;
                }
                n--;
                if (l < n) {
                    for (i = m - 1; i >= k; --i) {
                        sum += arr[i][l];
                        if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0) {
                            emtiaz++;
                        }
                        l++;
                    }

                    if (k < m) {
                        for (i = n - 1; i >= l; --i) {
                            sum += arr[m - 1][i];
                            if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0) {
                                emtiaz++;
                            }
                            m--;
                        }

                    }
                }
            }
        }
        System.out.println(emtiaz);
    }

    public static void main(String[] args) {
        int m;
        Scanner scn=new Scanner(System.in);
        m=scn.nextInt();
        int[][] arr=new int[m][m];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]=scn.nextInt();
            }
        }
        halazuni(m,m,arr);
    }
}
