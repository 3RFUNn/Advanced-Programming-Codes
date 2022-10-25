import java.time.LocalDate;
import java.util.*;

public class Tolikonande {
    double[] sood = new double[100];
    public static int tk = 0, saltolid;
    LocalDate date = LocalDate.now();
    LocalDate khorakidate = date.plusMonths(1);
    private static double[] pooltolidkonande = new double[100];
    private static double[][] pooljens = new double[100][1000];
    private static double[][] hajmjens=new double[100][1000];

    public static double getPooljens(int i,int j) {
        return pooljens[i][j];
    }

    public static double getPooltolidkonande(int i) {
        return pooltolidkonande[i];
    }

    public void sefrsaz() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                pooljens[i][j] = 0;
                hajmjens[i][j]=0;

            }
        }
    }


    public void pooltolidsaz() {
        for (int i = 0; i < 100; i++) {
            pooltolidkonande[i] = 0;
        }
    }

    int[] listcounter = new int[100];
    Scanner scn = new Scanner(System.in);
    private static String[] makerUser = new String[100];
    private static String[] makerPass = new String[100];

    public void countersaz() {
        for (int i = 0; i < 100; i++) {
            listcounter[i] = 0;
        }
    }

    public void saltolid() {
        System.out.println("what year is the product prooduced?");
        int sal = scn.nextInt();
        while (true) {
            if (sal >= 2000 && sal < 2020) {
                saltolid = 2020 - sal;
                break;
            } else System.out.println("give a number between 2000 and 2020 ! ");
        }
    }

    public void ramzgirtolidkonande(int i) {
        String pass;
        int m=0;
        System.out.println("Enter you password user " + makerUser[i] + ":");
        pass = scn.nextLine();
        if (!pass.equals(makerPass[i])) {
            while (true){
                if(m!=0) {
                    System.out.println("wrong entry try again!");
                }
                pass=scn.nextLine();
                if(pass.equals(makerPass[i])){
                    System.out.println("welcome \n");
                    break;
                }
                m++;
            }
        }

    }

    public void AddTolidkonande() {
        System.out.println("Set tolidkonande username:");
        makerUser[tk] = scn.nextLine();
        System.out.println("set tolidkonande password:");
        makerPass[tk] = scn.nextLine();
        tk++;
    }

    public static ArrayList<String>[][] kala = new ArrayList[100][1000];

    public void arraysaz() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                kala[i][j] = new ArrayList<String>();
            }
        }
    }

    public void addkardanekala() {
        System.out.println("which user are you?(enter number)");
        for (int i = 0; i < tk; i++) {
            System.out.println(i + "\t." + makerUser[i] + "\n");

        }
        int vorudi;
        while (true) {
            vorudi = scn.nextInt();
            if (vorudi >= 0 && vorudi < tk) {
                break;
            } else System.out.println("tolid konande not found try again!");
        }
        ramzgirtolidkonande(vorudi);
        System.out.println("which kind of product you wish to add?(enter number)");
        System.out.println("1.\tkhoraki\n2.\tpooshak\n3.\telectric\n");
        int adad;
        while (true) {
            adad = scn.nextInt();
            if (adad == 1 || adad == 2 || adad == 3) {
                break;
            } else System.out.println("wrong entry try again!");
        }
        switch (adad) {
            case 1:
                kala[vorudi][listcounter[vorudi]].add("User: " + makerUser[vorudi]);
                kala[vorudi][listcounter[vorudi]].add("Khoraki");
                System.out.println("what kind of khoraki u want?(enter number)");
                System.out.println("1.\tmive\n2.\tsabzijat\n3.\ttanagholat\n4.\tlabaniyat\n");
                int khoraki;
                while (true) {
                    khoraki = scn.nextInt();
                    if (khoraki == 1 || khoraki == 2 || khoraki == 3 || khoraki == 4) {
                        break;
                    } else System.out.println("wrong entry try again!");
                }
                switch (khoraki) {
                    case 1:
                        kala[vorudi][listcounter[vorudi]].add("mive");
                        break;
                    case 2:
                        kala[vorudi][listcounter[vorudi]].add("sabzijat");
                        break;
                    case 3:
                        kala[vorudi][listcounter[vorudi]].add("tanagholat");
                        break;
                    case 4:
                        kala[vorudi][listcounter[vorudi]].add("labaniyat");
                        break;
                }
                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.2 m^3");
                hajmjens[vorudi][listcounter[vorudi]]=0.2;
                kala[vorudi][listcounter[vorudi]].add("Exp.date = " + khorakidate);
                double price,takhfifiPrice;
                System.out.println("what price would you like to give your Khoraki?");
                price = scn.nextDouble();
                System.out.println("how much discount are going to give to this product?(enter a number between 0 to 99)");
                while (true){
                    takhfifiPrice=scn.nextDouble();
                    if(takhfifiPrice==0){
                        break;
                    }
                    else if (takhfifiPrice>0 && takhfifiPrice<=99){
                        price*=(1-takhfifiPrice/100);
                        break;
                    }
                    else System.out.println("wrong entry try again!");
                }
                kala[vorudi][listcounter[vorudi]].add("price:" + price);
                pooljens[vorudi][listcounter[vorudi]] += price;
                break;
            case 2:
                kala[vorudi][listcounter[vorudi]].add("User: " + makerUser[vorudi]);
                kala[vorudi][listcounter[vorudi]].add("pooshak");
                System.out.println("what kind of pooshak do you want?(enter number))");
                System.out.println("1.\tkafsh\n2.\tpirahan\n3.\tshalvar\n");
                int pooshak;
                while (true) {
                    pooshak = scn.nextInt();
                    if (pooshak == 1 || pooshak == 2 | pooshak == 3) {
                        break;
                    } else System.out.println("wrong entry try again!");
                }
                System.out.println("what is your sex?\n1.\tmale\n2.\tfemale\n(enter number)");
                int sex;
                while (true) {
                    sex = scn.nextInt();
                    if (sex == 1) {
                        kala[vorudi][listcounter[vorudi]].add("mardune");
                        break;
                    }
                    if (sex == 2) {
                        kala[vorudi][listcounter[vorudi]].add("zanune");
                        break;
                    } else System.out.println("wrong entry try again!");
                }
                switch (pooshak) {
                    case 1:
                        kala[vorudi][listcounter[vorudi]].add("kafsh");
                        System.out.println("what is your shoe size?(number)");
                        int size;
                        while (true) {
                            size = scn.nextInt();
                            if (size >= 0 && size <= 20) {
                                kala[vorudi][listcounter[vorudi]].add("size is " + size);
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.2");
                                hajmjens[vorudi][listcounter[vorudi]]=0.2;
                                break;
                            }
                            if (size > 20 && size <= 40) {
                                kala[vorudi][listcounter[vorudi]].add("size is " + size);
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.3");
                                hajmjens[vorudi][listcounter[vorudi]]=0.3;
                                break;
                            }
                            if (size > 40 && size <= 50) {
                                kala[vorudi][listcounter[vorudi]].add("size is " + size);
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.4");
                                hajmjens[vorudi][listcounter[vorudi]]=0.4;
                                break;
                            } else
                                System.out.println("wrong entry try again!");
                        }
                        break;
                    case 2:
                        int pirahan;
                        kala[vorudi][listcounter[vorudi]].add("pirhan");
                        System.out.println("what is your pirhan size?\n1.\tS\n2.\tM\n3.\tL\n(enter number)");
                        while (true) {
                            pirahan = scn.nextInt();
                            if (pirahan == 1) {
                                kala[vorudi][listcounter[vorudi]].add("size is S");
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.2");
                                hajmjens[vorudi][listcounter[vorudi]]=0.2;
                                break;
                            }
                            if (pirahan == 2) {
                                kala[vorudi][listcounter[vorudi]].add("size is M");
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.3");
                                hajmjens[vorudi][listcounter[vorudi]]=0.3;
                                break;
                            }
                            if (pirahan == 3) {
                                kala[vorudi][listcounter[vorudi]].add("size is L");
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.4");
                                hajmjens[vorudi][listcounter[vorudi]]=0.4;
                                break;
                            } else System.out.println("wrong entry try again!");
                        }
                        break;
                    case 3:
                        int shalavar;
                        kala[vorudi][listcounter[vorudi]].add("shalvar");
                        System.out.println("what is your shalvar size?\n1.\tS\n2.\tM\n3.\tL\n(enter number)");
                        while (true) {
                            pirahan = scn.nextInt();
                            if (pirahan == 1) {
                                kala[vorudi][listcounter[vorudi]].add("size is S");
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.2");
                                hajmjens[vorudi][listcounter[vorudi]]=0.2;
                                break;
                            }
                            if (pirahan == 2) {
                                kala[vorudi][listcounter[vorudi]].add("size is M");
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.3");
                                hajmjens[vorudi][listcounter[vorudi]]=0.3;
                                break;
                            }
                            if (pirahan == 3) {
                                kala[vorudi][listcounter[vorudi]].add("size is L");
                                kala[vorudi][listcounter[vorudi]].add("Hajm = 0.4");
                                hajmjens[vorudi][listcounter[vorudi]]=0.4;
                                break;
                            } else System.out.println("wrong entry try again!");
                        }
                        break;
                }
                System.out.println("what price would you like to give your Pooshak?");
                price = scn.nextDouble();
                System.out.println("how much discount are going to give to this product?(enter a number between 0 to 99)");
                while (true){
                    takhfifiPrice=scn.nextDouble();
                    if(takhfifiPrice==0){
                        break;
                    }
                    else if (takhfifiPrice>0 && takhfifiPrice<=99){
                        price*=(1-takhfifiPrice/100);
                        break;
                    }
                    else System.out.println("wrong entry try again!");
                }
                kala[vorudi][listcounter[vorudi]].add("price:" + price);
                pooljens[vorudi][listcounter[vorudi]] += price;
                break;
            case 3:
                kala[vorudi][listcounter[vorudi]].add(makerUser[vorudi]);
                kala[vorudi][listcounter[vorudi]].add("electric");
                System.out.println("what kind of electric device do you want?(enter nmuber)");
                System.out.println("1.\tcellphone\n2.\ttv\n3.\tgaming console\n");
                int electric;
                while (true) {
                    electric = scn.nextInt();
                    if (electric == 1 || electric == 2 || electric == 3) {
                        break;
                    } else
                        System.out.println("wrong entry try again!");

                }
                switch (electric) {
                    case 1:
                        kala[vorudi][listcounter[vorudi]].add("cellphone");
                        System.out.println("what is your cellphone size?(enter inch number)");
                        double sizephone;
                        while (true) {
                            sizephone = scn.nextDouble();
                            if (sizephone >= 3 && sizephone < 8) {
                                kala[vorudi][listcounter[vorudi]].add("size safhe: " + sizephone);
                                kala[vorudi][listcounter[vorudi]].add("Hajm=0.2");
                                hajmjens[vorudi][listcounter[vorudi]]=0.2;
                                break;
                            }
                            if (sizephone >= 8 && sizephone <= 12) {
                                kala[vorudi][listcounter[vorudi]].add("size safhe: " + sizephone);
                                kala[vorudi][listcounter[vorudi]].add("Hajm=0.3");
                                hajmjens[vorudi][listcounter[vorudi]]=0.3;
                                break;
                            } else System.out.println("wrong entry try again!");
                        }
                        saltolid();
                        kala[vorudi][listcounter[vorudi]].add(String.valueOf("production year: " + date.minusYears(saltolid)));
                        break;
                    case 2:
                        kala[vorudi][listcounter[vorudi]].add("tv");
                        System.out.println("what is your tv size?(enter inch number)");
                        double sizetv;
                        while (true) {
                            sizetv = scn.nextDouble();
                            if (sizetv >= 15 && sizetv < 25) {
                                kala[vorudi][listcounter[vorudi]].add("size safhe: " + sizetv);
                                kala[vorudi][listcounter[vorudi]].add("Hajm=1");
                                hajmjens[vorudi][listcounter[vorudi]]=1;
                                break;
                            }
                            if (sizetv >= 25 && sizetv < 50) {
                                kala[vorudi][listcounter[vorudi]].add("size safhe: " + sizetv);
                                kala[vorudi][listcounter[vorudi]].add("Hajm=1.5");
                                hajmjens[vorudi][listcounter[vorudi]]=1.5;
                                break;
                            }
                            if (sizetv >= 50 && sizetv < 80) {
                                kala[vorudi][listcounter[vorudi]].add("size safhe: " + sizetv);
                                kala[vorudi][listcounter[vorudi]].add("Hajm=2");
                                hajmjens[vorudi][listcounter[vorudi]]=2;
                                break;
                            } else System.out.println("wrong entry try again!");
                        }
                        saltolid();
                        kala[vorudi][listcounter[vorudi]].add(String.valueOf("production year: " + date.minusYears(saltolid)));
                        break;

                    case 3:
                        kala[vorudi][listcounter[vorudi]].add("gaming console");
                        System.out.println("does console have features?(enter number)\n1.\tyes\n2.\tno");
                        int feature;
                        String feat;
                        while (true) {
                            feature = scn.nextInt();
                            if (feature == 1) {
                                kala[vorudi][listcounter[vorudi]].add("features:special edition");
                                break;
                            }
                            if (feature == 2) {
                                break;
                            } else System.out.println("wrong entry try again!");
                        }
                        kala[vorudi][listcounter[vorudi]].add("Hajm=1");
                        hajmjens[vorudi][listcounter[vorudi]]=1;
                        saltolid();
                        kala[vorudi][listcounter[vorudi]].add(String.valueOf("production year: " + date.minusYears(saltolid)));
                        break;

                }
                System.out.println("what price would you like to give your electric device?");
                price = scn.nextDouble();
                System.out.println("how much discount are going to give to this product?(enter a number between 0 to 99)");
                while (true){
                    takhfifiPrice=scn.nextDouble();
                    if(takhfifiPrice==0){
                        break;
                    }
                    else if (takhfifiPrice>0 && takhfifiPrice<=99){
                        price*=(1-takhfifiPrice/100);
                        break;
                    }
                    else System.out.println("wrong entry try again!");
                }
                kala[vorudi][listcounter[vorudi]].add("price:" + price);
                pooljens[vorudi][listcounter[vorudi]] += price;


                break;

        }
        listcounter[vorudi]++;
    }

    public void hazfkala() {
        System.out.println("which user are you?(enter number)");
        for (int i = 0; i < tk; i++) {
            System.out.println(i + "\t." + makerUser[i] + "\n");

        }
        int vorudi;
        while (true) {
            vorudi = scn.nextInt();
            if (vorudi >= 0 && vorudi < tk) {
                break;
            } else System.out.println("tolid konande not found try again!");
        }
        ramzgirtolidkonande(vorudi);
        System.out.println("which kala would you like to delete?(enter number)");
        for (int i = 0; i < kala[vorudi].length; i++) {
            System.out.println(i + ".\t" + kala[vorudi][i] + "\n");
        }
        int delete;
        while (true) {
            delete = scn.nextInt();
            if (delete >= 0 && delete <= 1000) {
                break;
            } else System.out.println("entry not found try again!");
        }
        kala[vorudi][delete].clear();
        listcounter[vorudi]--;

    }

    public void printtolidkonande() {
        for (int i = 0; i < tk; i++) {
            System.out.println(i + "\t." + makerUser[i] + "\n");
        }
    }

    public void ajnas(int i) {
        for (int j = 0; j < kala[i].length; j++) {
            System.out.println(i + "\t." + kala[i][j]);
        }
    }

    public static double getHajmjens(int i,int j) {
        return hajmjens[i][j];
    }

    public static int getTk() {
        return tk;
    }
}
