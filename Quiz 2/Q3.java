public class Human {
}

interface Java8Interface {
    boolean isInfected(Human human);

    default boolean isHealthy(Human human) {
        return !(this.isInfected(human));
    }
}


class Java8 implements Java8Interface {
    public boolean isInfected(Human human) {
        return this.isInfected(human);
    }
}

 class java8test {
    public static void main(String[] args) {
        Java8Interface j8=((Human human) -> true);
    }
}
