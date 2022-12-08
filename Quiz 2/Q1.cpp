#include <iostream>

class DAtAnumbers {
public:
    int *soorat;
    int *makhraj;
    char *alamat;
    int a=0;

    DAtAnumbers(int i, int j) {
        a++;
        *(soorat) = abs(i);
        *(makhraj) = abs(j);
        if (i * j < 0) {
            *alamat = '-';
        } else *alamat = '+';
    }

    DAtAnumbers(int i) {
        a++;
        *(soorat) = abs(i);
        *(makhraj)=1;
        if(i<0){
            *alamat = '-';
        } else *alamat = '+';
    }
    DAtAnumbers(){
        a++;
        *(soorat) = 0;
        *(makhraj)=1;
    }

    void inverse(){
        int temp;
        temp=*(soorat);
        soorat=makhraj;
        *(makhraj)=temp;
    }
    int count(){
        return a;

    }
};

int main() {

    return 0;
}
