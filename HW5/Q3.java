import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Sudoko extends Exception {
    Sudoko() {
        super();
    }

    public void PrintBoard(String[][] array) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

class Vorudi extends Sudoko {
    Vorudi() throws Vorudi {
        throw new Vorudi();
    }
}

class CheckRowException extends Sudoko {
    CheckRowException() {
        super();
    }

    public void check(int[][] array) throws CheckRowException {
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 8; col++)
                for (int col2 = col + 1; col2 < 9; col2++)
                    if ((array[row][col] == array[row][col2]) && (array[row][col] != 0 || array[row][col2] != 0))
                        throw new CheckRowException();
    }
}

class CheckColumnException extends Sudoko {
    CheckColumnException() {
        super();
    }

    public void check(int[][] array) throws CheckColumnException {
        for (int col = 0; col < 9; col++)
            for (int row = 0; row < 8; row++)
                for (int row2 = row + 1; row2 < 9; row2++)
                    if ((array[row][col] == array[row2][col]) && (array[row][col] != 0 || array[row2][col] != 0))
                        throw new CheckColumnException();
    }
}

class CheckBoxException extends Sudoko {
    CheckBoxException() {
        super();
    }

    public void check(int[][] array) throws CheckBoxException {
        for (int row = 0; row < 9; row += 3)
            for (int col = 0; col < 9; col += 3)
                for (int pos = 0; pos < 8; pos++)
                    for (int pos2 = pos + 1; pos2 < 9; pos2++)
                        if ((array[row + pos % 3][col + pos / 3] == array[row + pos2 % 3][col + pos2 / 3]) &&
                                (array[row + pos % 3][col + pos / 3] != 0 || array[row + pos2 % 3][col + pos2 / 3] != 0))
                            throw new CheckBoxException();
    }
}

class AdadException extends Sudoko {
    AdadException() {
        super();
    }

    public void vorudi(int num) throws AdadException {
        if (num < 1 || num > 9) {
            throw new AdadException();
        }
    }
}

class test3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Sudoko s1 = new Sudoko();
        CheckRowException r1 = new CheckRowException();
        CheckColumnException c1 = new CheckColumnException();
        CheckBoxException b1 = new CheckBoxException();
        AdadException a1 = new AdadException();
        int[][] Frontend = new int[9][9];
        int[][] Komaki = new int[9][9];
        String[][] Backend = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Frontend[i][j] = 0;
                Komaki[i][j] = 0;
            }
        }
        for (String[] strings : Backend) {
            Arrays.fill(strings, "\u25A1");
        }
        System.out.println("Hello to the sudoko game!\nThis is your empty Board:");
        s1.PrintBoard(Backend);
        while (true) {
            System.out.println("What do you want to do?(enter number)\n1.\tplay the game\n2.\tShowChart");
            int vorudi;
            while (true) {
                vorudi = scn.nextInt();
                if (vorudi == 1 || vorudi == 2) {
                    break;
                } else System.out.println("wrong entry try again!");
            }
            if (vorudi == 2) {
                s1.PrintBoard(Backend);
            }
            if (vorudi == 1) {
                while (true) {
                    int row = 0, column = 0, number = 0, win = 0;
                    System.out.println("Enter coordinates:");
                    try {
                        System.out.println("Enter Row:(1 to 9)");
                        row = scn.nextInt();
                        a1.vorudi(row);
                        System.out.println("Enter column:(1 to 9)");
                        column = scn.nextInt();
                        a1.vorudi(column);
                    } catch (AdadException e) {
                        System.out.println("entry out of bound!");
                        continue;
                    }
                    System.out.println("Enter the number for the given coordinate:(1 to 9)");
                    try {
                        number = scn.nextInt();
                        a1.vorudi(number);
                        Frontend[row - 1][column - 1] = number;
                    } catch (AdadException e) {
                        System.out.println("entry out of bounds!");
                        Frontend[row - 1][column - 1] = Komaki[row - 1][column - 1];
                        continue;
                    }
                    try {
                        r1.check(Frontend);
                        c1.check(Frontend);
                        b1.check(Frontend);
                        Komaki[row - 1][column - 1] = number;
                        Backend[row - 1][column - 1] = Integer.toString(number);
                    } catch (CheckRowException | CheckColumnException | CheckBoxException e) {
                        System.out.println("the number can't be applied !");
                        Backend[row - 1][column - 1] = "\u25A1";
                        break;
                    }
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (Backend[i][j].equals("\u25A1")) {
                                win++;
                            }
                        }
                    }
                    if (win == 0) {
                        System.out.println("You won");
                        return;
                    }
                    break;

                }
            }
        }
    }
}
