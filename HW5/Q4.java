
interface Jump {
    void Jumping();
}

class Kutah_Jump implements Jump {

    @Override
    public void Jumping() {
        System.out.println("Short Jumping");
    }
}

class Boland_Jump implements Jump {

    @Override
    public void Jumping() {
        System.out.println("Long Jumping");
    }
}


interface Kick {
    public void Kicking();
}

class Zaeef_Kick implements Kick {

    @Override
    public void Kicking() {
        System.out.println("Light Kicking");
    }
}

class Addi_Kick implements Kick {

    @Override
    public void Kicking() {
        System.out.println("Normal Kicking");
    }
}

class Ghavi_Kick implements Kick {

    @Override
    public void Kicking() {
        System.out.println("Heavy Kicking");
    }
}

interface Roll {
    void Rolling();
}

class CanRoll implements Roll {

    @Override
    public void Rolling() {
        System.out.println("Can Roll");
    }
}

class CantRoll implements Roll {

    @Override
    public void Rolling() {
        System.out.println("Can't Roll");
    }
}

public class Fighter {
    protected Kick k1;
    protected Roll r1;
    protected Jump j1;

    public void SetAction(Jump j1, Kick k1, Roll r1) {
        this.j1 = j1;
        this.k1 = k1;
        this.r1 = r1;
    }

    public void Actions() {
        k1.Kicking();
        j1.Jumping();
        r1.Rolling();
    }

    public void Punch() {
        System.out.println("Punch");
    }

    public void Display() {
        System.out.println("Display");
    }
}