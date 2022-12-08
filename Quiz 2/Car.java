import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Car {
    Integer price;
    ArrayList<Car> mashin=new ArrayList<>();
    private boolean owned;
    Integer least_price=mashin.stream().filter(a-> a.owned).mapToInt(mashin->mashin.price).min().getAsInt();
    public Integer getLeast_price() {
        return least_price;
    }
    public static void main(String[] args) {
        Car c1=new Car();
        System.out.println(c1.getLeast_price());
    }


}

