class Singleton {
    // in moteghayyer baraye in estefade mishavad ta refrence e kelase singleton ra negah darad
    private static Singleton obj = new Singleton();

    // private midahim chun nemikhahim constructor jaye digari estefade shavad va natanavim object in class ra mostaghim besazim
    private Singleton() {
    }
    // in method baraye bargardandane objecti hast ke dar bala sakhtim
    public static Singleton getInstance() {
        return obj;
    }
    // agar obj ba raveshe eagerly meghdar dehi shavad haman avval meghdar dade mishavad
    // amma agar lazy bashad avval null tarif mikonim va sepas meghdar dehi mikonim
}
