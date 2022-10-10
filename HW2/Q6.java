import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Haghighi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Pattern regex = Pattern.compile("\\s*[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?\\s*");
        String vorudi = scn.nextLine();
        Matcher matcher = regex.matcher(vorudi);
        if (matcher.matches()) {
            System.out.println("LEGAL");
        } else System.out.println("ILLEGAL");
    }
}
