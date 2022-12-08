import java.util.Scanner;

public class Charkheshmatrix {
    public static void RotateMatrixClockwise(int[][] oldmatrix, int tedad) {
        int[][] newMatrix = new int[oldmatrix[0].length][oldmatrix.length];
        int[][] newmatrix2 = new int[oldmatrix.length][oldmatrix[0].length];
        for (int k = 1; k < tedad + 1; k++) {
            if (k == 1) {
                int newColumn, newRow = 0;
                for (int oldColumn = oldmatrix[0].length - 1; oldColumn >= 0; oldColumn--) {
                    newColumn = 0;
                    for (int oldRow = 0; oldRow < oldmatrix.length; oldRow++) {
                        newMatrix[newRow][newColumn] = oldmatrix[oldRow][oldColumn];
                        newColumn++;
                    }
                    newRow++;
                }
            }
            if (k == 2) {
                int newColumn, newRow = 0;
                for (int oldColumn = oldmatrix.length - 1; oldColumn >= 0; oldColumn--) {
                    newColumn = 0;
                    for (int oldRow = 0; oldRow < oldmatrix[0].length; oldRow++) {
                        newmatrix2[newRow][newColumn] = newMatrix[oldRow][oldColumn];
                        newColumn++;
                    }
                    newRow++;
                }
            }
            if (k == 3) {
                int newColumn, newRow = 0;
                for (int oldColumn = oldmatrix[0].length - 1; oldColumn >= 0; oldColumn--) {
                    newColumn = 0;
                    for (int oldRow = 0; oldRow < oldmatrix.length; oldRow++) {
                        newMatrix[newRow][newColumn] = newmatrix2[oldRow][oldColumn];
                        newColumn++;
                    }
                    newRow++;
                }

            }


            if (k == tedad && tedad % 2 == 1) {
                for (int i = 0; i < newMatrix.length; i++) {
                    for (int j = 0; j < newMatrix[i].length; j++) {
                        System.out.print(newMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            if (k == tedad && tedad % 2 == 0) {
                for (int i = 0; i < newmatrix2.length; i++) {
                    for (int j = 0; j < newmatrix2[i].length; j++) {
                        System.out.print(newmatrix2[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int row, column;
        column = scn.nextInt();
        row = scn.nextInt();
        int[][] arraye = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arraye[i][j] = scn.nextInt();
            }
        }
        String halat = scn.next();
        int tedad = scn.nextInt();
        tedad %= 4;
        System.out.println(tedad);
        if (tedad == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(arraye[i][j] + " ");
                }
                System.out.println();
            }
        } else if (halat.equals("Counterclockwise")) {
            RotateMatrixClockwise(arraye, tedad);
        } else if (halat.equals("Clockwise")) {
            RotateMatrixClockwise(arraye, 4 - tedad);
        }
    }
}

