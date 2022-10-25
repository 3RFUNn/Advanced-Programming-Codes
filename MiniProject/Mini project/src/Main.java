import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name,halat,mother;
        int admin,admincase;
        Scanner scn=new Scanner(System.in);
        Admin a1=new Admin();
        Tolikonande t1=new Tolikonande();
        Moshtari m1=new Moshtari();
        Barbar b1=new Barbar();
        b1.hajmsaz();
        b1.ersalsaz();
        b1.adadbarbar();
        m1.kharidesaz();
        m1.jensmoshtari();
        m1.poolmoshtari();
        t1.arraysaz();
        t1.sefrsaz();
        t1.pooltolidsaz();
        t1.countersaz();
        System.out.println("create your first tolidkonande :");
        t1.AddTolidkonande();
        System.out.println("create you first barbar:");
        b1.AddBarbar();
        System.out.println("create your first moshtari:");
        m1.moshtarisaz();
        while (true) {
            while (true){
                System.out.println("do you want to enter the application or exit?(print)\n1.enter\n2.exit");
                mother=scn.nextLine();
                if(mother.equals("enter")){
                    break;
                }
                if(mother.equals("exit")){
                    return;
                }
            }
                System.out.println("who are you?(print you name)\n1.admin\n2.barbar\n3.tolidkonanade\n4.moshtari");
                while (true) {
                    name = scn.nextLine();
                    if (name.equals("admin")) {
                        halat = "a";
                        break;
                    }  if (name.equals("barbar")) {
                        halat = "b";
                        break;
                    }  if (name.equals("tolidkonande")) {
                        halat = "t";
                        break;
                    }  if (name.equals("moshtari")) {
                        halat = "m";
                        break;
                    }
                }
                switch (halat) {
                    case "a":
                        System.out.println("what do you want to do?(enter number)\n1.add tolidkonande\n2.add barbar\n3.get information");
                        while (true) {
                            admin = scn.nextInt();
                            if (admin == 1) {
                                admincase = 1;
                                break;
                            }
                            if (admin == 2) {
                                admincase = 2;
                                break;
                            }
                            if (admin == 3) {
                                admincase = 3;
                                break;
                            } else System.out.println("wrong entry try again!");
                        }
                        switch (admincase) {
                            case 1:
                                t1.AddTolidkonande();
                                continue;
                            case 2:
                                b1.AddBarbar();
                                continue;
                            case 3:
                                int info,sood,mo,mopool;
                                System.out.println("what information do you need?(enter number)\n1.tolidkonnade sood\n2.moshtari kharj\n3.hajme jabeja shode\n4.kalaye kharide shode moshtari\n5.sefareshate jabeja shode\n6.kalahaye foorookhte shode\n");
                                info=scn.nextInt();
                                if(info==1){
                                    t1.printtolidkonande();
                                    System.out.println("which tolid konnade sood?");
                                    sood=scn.nextInt();
                                    System.out.println(Tolikonande.getPooltolidkonande(sood));
                                    continue;
                                }
                                if(info==2){
                                    System.out.println("which moshtari sood?");
                                    mo=scn.nextInt();
                                    System.out.println(Moshtari.getPoolmoshtari(mo));
                                    continue;
                                }
                                if (info==3){
                                    int hajm;
                                    System.out.println("which barbar?");
                                    hajm=scn.nextInt();
                                    System.out.println(Barbar.getHajmeersalshode(hajm));
                                    continue;
                                }
                                if(info==4){
                                    m1.didanelistkharid();
                                    continue;
                                }
                                if(info==5){
                                    System.out.println("which?");
                                    int i=scn.nextInt();
                                    int j=scn.nextInt();
                                    System.out.println(Barbar.getErsalshode(i,j));
                                    continue;
                                }
                                if(info==6){
                                    m1.listaddikharid();
                                    continue;
                                }

                        }
                        continue;

                    case "b":
                        int barbar,barbarcase;
                        System.out.println("which menu do you want to see?(enter number)");
                        System.out.println("1.sefareshat\n2.darhale ersal\n3.ersal shode\n4.teghyire vasile naghliye");
                        while (true){
                            barbar=scn.nextInt();
                            if(barbar==1){
                                barbarcase=1;
                                break;
                            }

                            if(barbar==2){
                                barbarcase=2;
                                break;
                            }

                            if(barbar==3){
                                barbarcase=3;
                                break;
                            }

                            if(barbar==4){
                                barbarcase=4;
                                break;
                            }
                        }
                        switch (barbarcase){
                            case 1:
                                m1.didanelistkharid2();
                                continue;
                            case 2:
                                b1.darhalersal();
                                continue;
                            case 3:
                                b1.ersalshode();
                                continue;
                            case 4:
                                b1.changecar();
                                continue;
                        }
                        continue;
                    case "t":
                        int tolid,tolidcase;
                        System.out.println("which menu do you want to see?(enter number)\n");
                        System.out.println("1.add kala\n2.hazf kala");
                        while (true){
                            tolid=scn.nextInt();
                            if(tolid==1){
                                tolidcase=1;
                                break;
                            }
                            if(tolid==2){
                                tolidcase=2;
                                break;
                            }
                        }
                        switch (tolidcase){
                            case 1:
                                t1.addkardanekala();
                                continue;
                            case 2:
                                t1.hazfkala();
                                continue;
                        }
                        continue;
                    case "m":
                        int moshtari,moshtaricase;
                        System.out.println("what do you want to do moshtari?(enter number)\n");
                        System.out.println("1.add moshtari\n2.edit moshtari\n");
                        while (true){
                            moshtari=scn.nextInt();
                            if(moshtari==1){
                                moshtaricase=1;
                                break;
                            }
                            if (moshtari==2){
                                moshtaricase=2;
                                break;
                            }
                        }
                        switch (moshtaricase){
                            case 1:
                                m1.moshtarisaz();
                                break;
                            case 2:
                                int casesaz;
                                System.out.println("1.see tolidkonande\n2.see dastebandi ajnas\n3.see ajnase kharide\n4.see dar hale ersal\n");
                                casesaz=scn.nextInt();
                                if(casesaz==1){
                                    m1.listaddikharid();
                                    continue;
                                }
                                if(casesaz==2){
                                    m1.Dastebandi();
                                    continue;
                                }
                                if(casesaz==3){
                                    m1.didanelistkharid();
                                    continue;
                                }
                                if(casesaz==4){
                                    b1.darhalersal();
                                    continue;
                                }
                        }

                }
            }





    }
}

