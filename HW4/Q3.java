package reversi;

import java.util.Scanner;

class Cell {

    private int corY;
    private char corX;
    private char ch;


    public Cell(char x, int y, char c) {
        corY = y;
        corX = x;
        ch = c;
    }

    Cell() {
    }

    char getCorX() {
        return corX;
    }

    int getCorY() {
        return corY;
    }

    char getCh() {
        return ch;
    }

    void setPosition(char x, char c, int y) {
        corX = x;
        corY = y;
        ch = c;
    }
}

public class Reversi {
  public static boolean play;
  public static boolean play1;
    private int rows = 9;
    private int cols = 9;
    private int userCont = 0;
    private int userCont1 = 0;
    public Cell gameCells[][];


    public Reversi() {
        int mid;
        mid = (rows+2) / 2;
        gameCells = new Cell[10][10];
        for (int i = 0; i < rows; ++i)
            gameCells[i] = new Cell[10];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                gameCells[i][j] = new Cell();
                char c = (char) (97 + j);
                char adad=(char)(j+'0');
                char adad2=(char)(i+'0');
                if(i==0 && j==0){

                }
                else if(i==0 && j>0){
                    gameCells[i][j].setPosition(c,adad,i+1);
                }
                else if (j==0 && i>0){
                    gameCells[i][j].setPosition(c,adad2,i+1);
                }
                else if ((i == mid - 1) && (j == mid - 1)) {
                    gameCells[i][j].setPosition(c, 'I', i + 1);
                } else if ((i == mid - 1) && (j == mid)) {
                    gameCells[i][j].setPosition(c, 'O', i + 1);
                } else if ((i == mid) && (j == mid - 1)) {
                    gameCells[i][j].setPosition(c, 'O', i + 1);
                } else if ((i == mid) && (j == mid)) {
                    gameCells[i][j].setPosition(c, 'I', i + 1);
                } else {
                    gameCells[i][j].setPosition(c, '.', i + 1);
                }
            }
        }
        for (int i = 0; i <gameCells.length-1 ; i++) {
            for (int j = 0; j <gameCells[i].length-1 ; j++) {
                System.out.print(gameCells[i][j].getCh()+" ");
            }
            System.out.println();
        }
    }
    public int play1(int xCor, int yCor) {
        play1=false;
        int status;
        int change1, max1 = 0;
        int[] numberOfMoves = new int[1];
        change1 = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (gameCells[i][j].getCh() == '.') {
                    move(i, j, change1, 'O', 'I', numberOfMoves);
                    if (max1 < numberOfMoves[0]) {
                        max1 = numberOfMoves[0];
                        play1=true;
                    }
                }
            }
        }
        userCont1 = max1;
        if (userCont1 == 0) {
            userCont1 = -1;
            return -1;
        }
        if (userCont1 != 0) {
            change1 = 1;
            if (!(gameCells[xCor][yCor].getCh() == '.'))
                return 1;

            status = move(xCor, yCor, change1, 'O', 'I', numberOfMoves);
            if (status == -1)
                return 1;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(gameCells[i][j].getCh()+" ");
            }
            System.out.println("");
        }
        return 0;
    }

    public int play(int xCor, int yCor) {
        play=false;
        int status;
        int change, max = 0;
        int numberOfMoves[] = new int[1];
        change = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (gameCells[i][j].getCh() == '.') {
                    move(i, j, change, 'I', 'O', numberOfMoves);
                    if (max < numberOfMoves[0]) {
                        max = numberOfMoves[0];
                        play=true;
                    }
                }
            }
        }
        userCont = max;
        if (userCont == 0) {
            userCont = -1;
            return -1;
        }
        if (userCont != 0) {
            change = 1;
            if (!(gameCells[xCor][yCor].getCh() == '.'))
                return 1;

            status = move(xCor, yCor, change, 'I', 'O', numberOfMoves);
            if (status == -1)
                return 1;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols; j++) {
                System.out.print(gameCells[i][j].getCh()+" ");
            }
            System.out.println();
        }
        return 0;
    }



    public void reset() {
        int mid;
        mid = (rows+2) / 2;
        gameCells = new Cell[10][10];
        for (int i = 0; i < rows; ++i)
            gameCells[i] = new Cell[10];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                gameCells[i][j] = new Cell();
                char c = (char) (97 + j);
                char adad=(char)(j+'0');
                char adad2=(char)(i+'0');
                if(i==0 && j==0){

                }
                else if(i==0 && j>0){
                    gameCells[i][j].setPosition(c,adad,i+1);
                }
                else if (j==0 && i>0){
                    gameCells[i][j].setPosition(c,adad2,i+1);
                }
                else if ((i == mid - 1) && (j == mid - 1)) {
                    gameCells[i][j].setPosition(c, 'I', i + 1);
                } else if ((i == mid - 1) && (j == mid)) {
                    gameCells[i][j].setPosition(c, 'O', i + 1);
                } else if ((i == mid) && (j == mid - 1)) {
                    gameCells[i][j].setPosition(c, 'O', i + 1);
                } else if ((i == mid) && (j == mid)) {
                    gameCells[i][j].setPosition(c, 'I', i + 1);
                } else {
                    gameCells[i][j].setPosition(c, '.', i + 1);
                }
            }
        }
        for (int i = 0; i <gameCells.length-1 ; i++) {
            for (int j = 0; j <gameCells[i].length-1 ; j++) {
                System.out.print(gameCells[i][j].getCh()+" ");
            }
            System.out.println();
        }
    }

    int move(int xCor, int yCor, int change, char char1, char char2, int[] numberOfMoves) {
        int cont, st2 = 0, st = 0;
        int status = -1, corX, corY, temp;
        char str;
        int ix, y, x;

        x = xCor;
        y = yCor;
        numberOfMoves[0] = 0;
        if ((x + 1 < rows) && (gameCells[x + 1][y].getCh() == char2)) {

            cont = x;
            while ((cont < rows) && (st2 != -1) && (st != 2)) {
                cont++;
                if (cont < rows) {
                    if (gameCells[cont][y].getCh() == char2)
                        st = 1;
                    else if (gameCells[cont][y].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = cont - x - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                for (int i = x; i < cont; ++i) {
                    str = gameCells[i][y].getCorX();
                    ix = gameCells[i][y].getCorY();
                    gameCells[i][y].setPosition(str, char1, ix);
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((x - 1 >= 0) && (gameCells[x - 1][y].getCh() == char2)) {
            cont = x;
            while ((cont >= 0) && (st2 != -1) && (st != 2)) {
                cont--;
                if (cont >= 0) {
                    if (gameCells[cont][y].getCh() == char2)
                        st = 1;
                    else if (gameCells[cont][y].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = x - cont - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                for (int i = cont; i <= x; ++i) {
                    str = gameCells[i][y].getCorX();
                    ix = gameCells[i][y].getCorY();
                    gameCells[i][y].setPosition(str, char1, ix);
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((y + 1 < cols) && (gameCells[x][y + 1].getCh() == char2)) {
            cont = y;
            while ((cont < cols) && (st2 != -1) && (st != 2)) {
                cont++;
                if (cont < cols) {
                    if (gameCells[x][cont].getCh() == char2)
                        st = 1;
                    else if (gameCells[x][cont].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = cont - y - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                for (int i = y; i < cont; ++i) {
                    str = gameCells[x][i].getCorX();
                    ix = gameCells[x][i].getCorY();
                    gameCells[x][i].setPosition(str, char1, ix);
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((y - 1 >= 0) && (gameCells[x][y - 1].getCh() == char2)) {
            cont = y;
            while ((cont >= 0) && (st2 != -1) && (st != 2)) {
                cont--;
                if (cont >= 0) {
                    if (gameCells[x][cont].getCh() == char2)
                        st = 1;
                    else if (gameCells[x][cont].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = y - cont - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                for (int i = cont; i <= y; ++i) {
                    str = gameCells[x][i].getCorX();
                    ix = gameCells[x][i].getCorY();
                    gameCells[x][i].setPosition(str, char1, ix);
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((x - 1 >= 0) && (y + 1 < cols) && (gameCells[x - 1][y + 1].getCh() == char2)) {
            corY = y;
            corX = x;
            while ((corX >= 0) && (corY < cols) && (st2 != -1) && (st != 2)) {
                corX--;
                corY++;
                if ((corX >= 0) && (corY < cols)) {
                    if (gameCells[corX][corY].getCh() == char2)
                        st = 1;
                    else if (gameCells[corX][corY].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = x - corX - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                while ((corX <= x) && (y < corY)) {
                    corX++;
                    corY--;
                    if ((corX <= x) && (y <= corY)) {
                        str = gameCells[corX][corY].getCorX();
                        ix = gameCells[corX][corY].getCorY();
                        gameCells[corX][corY].setPosition(str, char1, ix);
                    }
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((x - 1 >= 0) && (y - 1 >= 0) && (gameCells[x - 1][y - 1].getCh() == char2)) {
            corY = y;
            corX = x;
            while ((corX >= 0) && (corY >= 0) && (st2 != -1) && (st != 2)) {
                corX--;
                corY--;
                if ((corX >= 0) && (corY >= 0)) {
                    if (gameCells[corX][corY].getCh() == char2)
                        st = 1;
                    else if (gameCells[corX][corY].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = x - corX - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                while ((corX <= x) && (corY <= y)) {
                    corX++;
                    corY++;
                    if ((corX <= x) && (corY <= y)) {
                        str = gameCells[corX][corY].getCorX();
                        ix = gameCells[corX][corY].getCorY();
                        gameCells[corX][corY].setPosition(str, char1, ix);
                    }
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((x + 1 < rows) && (y + 1 < cols) && (gameCells[x + 1][y + 1].getCh() == char2)) {
            corY = y;
            corX = x;
            while ((corX < rows) && (corY < cols) && (st2 != -1) && (st != 2)) {
                corX++;
                corY++;
                if ((corX < rows) && (corY < cols)) {
                    if (gameCells[corX][corY].getCh() == char2)
                        st = 1;
                    else if (gameCells[corX][corY].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = corX - x - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                while ((corX >= x) && (corY >= y)) {
                    corX--;
                    corY--;
                    if ((corX >= x) && (corY >= y)) {
                        str = gameCells[corX][corY].getCorX();
                        ix = gameCells[corX][corY].getCorY();
                        gameCells[corX][corY].setPosition(str, char1, ix);
                    }
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if ((x + 1 < rows) && (y - 1 >= 0) && (gameCells[x + 1][y - 1].getCh() == char2))
        {
            corY = y;
            corX = x;
            while ((corX < rows) && (corY >= 0) && (st2 != -1) && (st != 2)) {
                corX++;
                corY--;
                if ((corX < rows) && (corY >= 0)) {
                    if (gameCells[corX][corY].getCh() == char2)
                        st = 1;
                    else if (gameCells[corX][corY].getCh() == char1)
                        st = 2;
                    else
                        st2 = -1;
                }
            }
            if (st == 2) {
                temp = corX - x - 1;
                numberOfMoves[0] += temp;
            }
            if (st == 2 && change == 1) {
                while ((corX >= x) && (corY <= y)) {
                    corX--;
                    corY++;
                    if ((corX >= x) && (corY <= y)) {
                        str = gameCells[corX][corY].getCorX();
                        ix = gameCells[corX][corY].getCorY();
                        gameCells[corX][corY].setPosition(str, char1, ix);
                    }
                }
                status = 0;
            }
            st = 0;
            st2 = 0;
        }
        if (status == 0)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        Reversi r1 = new Reversi();
        Scanner scn = new Scanner(System.in);
        int x1, y1;
        int x2, y2;
        int a = 0;
        System.out.println("to reset enter coordinates -1 -1 ");
        while (true) {
            while (true) {
                System.out.println("enter coordinates player 1:");
                x1 = scn.nextInt();
                y1 = scn.nextInt();
                if (x1 == -1 || y1 == -1) {
                    r1.reset();
                    continue;
                }
                r1.play(x1, y1);
                break;
            }

            while (true) {
                System.out.println("enter coordinates player 2:");
                x2 = scn.nextInt();
                y2 = scn.nextInt();
                if (x2 == -1 || y2 == -1) {
                    r1.reset();
                    continue;
                }
                r1.play1(x2, y2);
                break;
            }

        }
    }
}




