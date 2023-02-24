interface Publication {
    public void publish();
}

interface Book extends Publication {
    public void read();
}

abstract class Coursebook implements Book {

    @Override
    public void publish() {
        System.out.println("publishing coursebook");
    }
}

class Discretebook extends Coursebook {
    @Override
    public void publish() {
        System.out.println("publishing discrete book");
    }

    @Override
    public void read() {
        System.out.println("reading discrete book");
    }
}

class ProgrammingBook extends Coursebook {
    @Override
    public void publish() {
        System.out.println("publishing programming book");
    }

    @Override
    public void read() {
        System.out.println("reading programming book");
    }
}

class Test {
    public void DISPLAY(Publication p1) {
        if (p1 instanceof ProgrammingBook) {
            p1.publish();
            ((ProgrammingBook) p1).read();
        } else if (p1 instanceof Discretebook) {
            ((Discretebook) p1).read();
            p1.publish();
        }

    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Discretebook d1 = new Discretebook();
        ProgrammingBook p1 = new ProgrammingBook();
        t1.DISPLAY(p1);
        t1.DISPLAY(d1);
    }
}


