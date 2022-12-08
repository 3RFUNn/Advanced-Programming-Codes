//barname nawbi vase mineswwwper
//Credits by Erfan Rafiee(RFOSK)

#include<bits/stdc++.h>
#include <cstdio>
#include <chrono>
#include <unistd.h>

using namespace std;
#define Bishtarin 100
#define MAXMINES 100

int Radif;// andaze radif
int Sotoon; //andaze sotoon e bazi
int MINES; // tedad min ha

// BaziSAz
class Minesweeper {
public:
    // Gereftane harekat e karbar
    void makeMove(int *x, int *y) {
        cout << "Enter your move player\n";
        cout << "enter row:\n";
        scanf("%d", x);
        cout << "Enter column:\n";
        scanf("%d", y);
    }

// print  kardane safhe
    void PrintSafhe(char myBoard[][Bishtarin]) {
        int i, j;

        cout << "\t";

        for (i = 0; i < Sotoon; i++) {
            printf("%d  ", i);
        }
        cout << endl;
        cout << endl;


        for (i = 0; i < Radif; i++) {
            printf("%d|\t", i);
            for (j = 0; j < Sotoon; j++) {
                printf("%c  ", myBoard[i][j]);
            }
            printf("\n");
        }
    }
};

class Bazi : public Minesweeper{
public:
    void BoardSaz(char realBoard[][Bishtarin], char myBoard[][Bishtarin]) {

        for (int i = 0; i < Radif; i++) {
            for (int j = 0; j < Sotoon; j++) {
                myBoard[i][j] = realBoard[i][j] = '-';
            }
        }
    }

    void BaziSaz() {
        int mines, r, s;
        cout << "Enter the Radif of the game:\n";
        cin >> r;
        cout << endl;
        cout << "Enter the Sotoon of the game:\n";
        cin >> s;
        cout << endl;
        cout << "Enter the number of mines\n";
        while (true) {
            cin >> mines;
            cout << endl;
            if (mines > (r * s - 1)) {
                cout << "too many bombs try again" << endl;
            } else break;
        }
        MINES = mines;
        Radif = r;
        Sotoon = s;
    }
    void flag_gozar(int row, int col, char myboard[Bishtarin][Bishtarin]) {
        if (myboard[row][col] == '-') {
            myboard[row][col] = '>';
        } else if (myboard[row][col] == '>') {
            myboard[row][col] = '-';
        } else if (myboard[row][col] == '?') {
            myboard[row][col] = '$';
        } else if (myboard[row][col] == '$') {
            myboard[row][col] = '?';
        }
    }

    void soal_gozar(int row, int col, char myboard[Bishtarin][Bishtarin]) {
        if (myboard[row][col] == '-') {
            myboard[row][col] = '?';
        } else if (myboard[row][col] == '?') {
            myboard[row][col] = '-';
        } else if (myboard[row][col] == '>') {
            myboard[row][col] = '$';
        } else if (myboard[row][col] == '$') {
            myboard[row][col] = '>';
        }
    }
};

class Mine : public Minesweeper{
public:
    // tayide tedad
// return true if dorost
    bool TayidKonande(int row, int col) {
        return (row >= 0) && (row < Radif) && (col >= 0) && (col < Sotoon);
    }

// adade dade shode daraye min ast ya na
    bool MinHast(int row, int col, char board[][Bishtarin]) {
        return board[row][col] == '*';
    }

    // shomareshe min haye atraf
    int CountAtraf(int row, int col, int mines[][2], char realBoard[][Bishtarin]) {

        int count = 0;
        if (TayidKonande(row - 1, col) == true) {
            if (MinHast(row - 1, col, realBoard) == true)
                count++;
        }
        if (TayidKonande(row + 1, col) == true) {
            if (MinHast(row + 1, col, realBoard) == true)
                count++;
        }
        if (TayidKonande(row, col + 1) == true) {
            if (MinHast(row, col + 1, realBoard) == true)
                count++;
        }
        if (TayidKonande(row, col - 1) == true) {
            if (MinHast(row, col - 1, realBoard) == true)
                count++;
        }
        if (TayidKonande(row - 1, col + 1) == true) {
            if (MinHast(row - 1, col + 1, realBoard) == true)
                count++;
        }
        if (TayidKonande(row - 1, col - 1) == true) {
            if (MinHast(row - 1, col - 1, realBoard) == true)
                count++;
        }
        if (TayidKonande(row + 1, col + 1) == true) {
            if (MinHast(row + 1, col + 1, realBoard) == true)
                count++;
        }
        if (TayidKonande(row + 1, col - 1) == true) {
            if (MinHast(row + 1, col - 1, realBoard) == true)
                count++;
        }

        return (count);
    }

    bool playMinesweeperUtil(char myBoard[][Bishtarin], char realBoard[][Bishtarin], int mines[][2], int row, int col,
                             int *movesLeft) {
        int i;
        Minesweeper M1;
        if (myBoard[row][col] != '-' && myBoard[row][col] != '>' && myBoard[row][col] != '?' &&
            myBoard[row][col] != '$') {
            return false;
        } else if (myBoard[row][col] == '>' || myBoard[row][col] == '$') {
            return false;
        }
        if (realBoard[row][col] == '*') {
            myBoard[row][col] = '*';

            for (i = 0; i < MINES; i++)
                myBoard[mines[i][0]][mines[i][1]] = '*';

            M1.PrintSafhe(myBoard);
            printf("\nYou lost!\n");
            return true;
        } else {
            int count = CountAtraf(row, col, mines, realBoard);
            (*movesLeft)--;

            myBoard[row][col] = count + '0';

            if (!count) {
                if (TayidKonande(row - 1, col) == true) {
                    if (MinHast(row - 1, col, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row - 1, col, movesLeft);
                }
                if (TayidKonande(row + 1, col) == true) {
                    if (MinHast(row + 1, col, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row + 1, col, movesLeft);
                }
                if (TayidKonande(row, col + 1) == true) {
                    if (MinHast(row, col + 1, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row, col + 1, movesLeft);
                }
                if (TayidKonande(row, col - 1) == true) {
                    if (MinHast(row, col - 1, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row, col - 1, movesLeft);
                }
                if (TayidKonande(row - 1, col + 1) == true) {
                    if (MinHast(row - 1, col + 1, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row - 1, col + 1, movesLeft);
                }
                if (TayidKonande(row - 1, col - 1) == true) {
                    if (MinHast(row - 1, col - 1, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row - 1, col - 1, movesLeft);
                }
                if (TayidKonande(row + 1, col + 1) == true) {
                    if (MinHast(row + 1, col + 1, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row + 1, col + 1, movesLeft);
                }
                if (TayidKonande(row + 1, col - 1) == true) {
                    if (MinHast(row + 1, col - 1, realBoard) == false)
                        playMinesweeperUtil(myBoard, realBoard, mines, row + 1, col - 1, movesLeft);
                }
            }
            return false;
        }
    }

// Random min gozari
    void PlaceRandom(int mines[][2], char realBoard[][Bishtarin]) {
        bool mark[Bishtarin * Bishtarin];

        memset(mark, false, sizeof(mark));

        for (int i = 0; i < MINES;) {
            int random = rand() % (Sotoon * Radif);
            int x = random / Radif;
            int y = random % Sotoon;

            if (!mark[random]) {
                mines[i][0] = x;
                mines[i][1] = y;

                realBoard[mines[i][0]][mines[i][1]] = '*';
                mark[random] = true;
                i++;
            }
        }
    }

    void bombshomar(char myboard[][Bishtarin], char realboard[][Bishtarin]) {
        int tedad_bomb = MINES;
        for (int i = 0; i < Radif; ++i) {
            for (int j = 0; j < Sotoon; ++j) {
                if ((myboard[i][j] == '>' || myboard[i][j] == '$') && (realboard[i][j] == '*'))
                    tedad_bomb--;
            }
        }
        cout << "the remaining bombs are:" << tedad_bomb << endl;
    }

// jaygozin kardane min be jaye digar
    void jaygozinMin(int row, int col, char board[Bishtarin][Bishtarin]) {
        for (int i = 0; i < Radif; i++) {
            for (int j = 0; j < Sotoon; j++) {

                if (board[i][j] != '*') {
                    board[i][j] = '*';
                    board[row][col] = '-';
                    return;
                }
            }
        }
    }
};


void chikarKonim() {
    cout << "what do you want to do?(enter the number)" << endl;
    cout
            << "0.print tutorial\n1.click on the house\n2.put flag(>) on the house\n3.put question(?) on the house\n"
               "4.print tedad bomb\n5.print remaining bombs\n6.print safhe"
            << endl;

}
// baraye bazi kardan
void playMinesweeper() {
    Bazi b1;
    Mine m1;
    Minesweeper ms1;
    bool Bakht = false;
    char realBoard[Bishtarin][Bishtarin], myBoard[Bishtarin][Bishtarin];

    int movesLeft = Radif * Sotoon - MINES, x, y, state;
    int mines[MAXMINES][2];
    b1.BoardSaz(realBoard, myBoard);
    m1.PlaceRandom(mines, realBoard);
    int currentMoveIndex = 0;
    auto start = chrono::steady_clock::now();
    while (!Bakht) {
        chikarKonim();
        while (true) {
            cin >> state;
            if (state != 0 && state != 1 && state != 2 && state != 3 && state != 4 && state != 5 && state != 6)
                cout << "wrong entry try again!";
            else {
                break;
            }
        }
        switch (state) {
            case 0:
                cout << "flag='>' question='?' flag+number='$'" << endl;
                break;
            case 1:
                cout << "Board is like This: \n";
                ms1.PrintSafhe(myBoard);
                ms1.makeMove(&x, &y);
                if (currentMoveIndex == 0) {
                    if (m1.MinHast(x, y, realBoard))
                        m1.jaygozinMin(x, y, realBoard);
                }

                currentMoveIndex++;

                Bakht = m1.playMinesweeperUtil(myBoard, realBoard, mines, x, y, &movesLeft);

                if (!Bakht && (movesLeft == 0)) {
                    cout << "\nYou won !\n";
                    Bakht = true;
                }
                break;
            case 2:
                ms1.makeMove(&x, &y);
                b1.flag_gozar(x, y, myBoard);
                cout << "Board is like This: \n";
                ms1.PrintSafhe(myBoard);
                break;
            case 3:
                ms1.makeMove(&x, &y);
                b1.soal_gozar(x, y, myBoard);
                cout << "Board is like This: \n";
                ms1.PrintSafhe(myBoard);
                break;
            case 4:
                cout << "tedad bombs are:" << MINES << endl;
                break;
            case 5:
                m1.bombshomar(myBoard, realBoard);
                break;
            case 6:
                cout << "Board is like This: \n";
                ms1.PrintSafhe(myBoard);
        }
        auto end = chrono::steady_clock::now();
        cout << "elapsed time is: " << chrono::duration_cast<chrono::seconds>(end - start).count() << " seconds!\n\n"
             << endl;

    }

}

int main() {
    Bazi b1;
    b1.BaziSaz();
    playMinesweeper();

    return 0;
}

