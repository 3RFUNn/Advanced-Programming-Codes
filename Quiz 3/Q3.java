import java.util.Scanner;
import java.util.Random;
import java.lang.String;
class NumberOutOfRange extends Exception{
    public NumberOutOfRange(){
        super();
    }
    public void checkRange(int vorudi)throws NumberOutOfRange{
        if (vorudi < 0 || vorudi > 200){
            throw new NumberOutOfRange();
        }
    }
}
class InvalidInputException extends Exception{
    public InvalidInputException(){
        super();
    }
    public int checkInput(String s) throws InvalidInputException{
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9'){
            return Integer.parseInt(s);
        }else {
            throw new InvalidInputException();
        }
    }
}
public class Shansi {
    public static class Game {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int num1,num2;
            while (true) {
                num1 = 1 + (int) (200*Math.random());
                num2 = 1 + (int) (200*Math.random());
                if (Math.abs(num1 - num2) >= 10)
                    break;
            }
            System.out.println("first number: " + num1);
            System.out.println("second number: " + num2);
            for (int i = 0; i < 10; i++) {
                System.out.println("chance "+(i+1)+" Enter number");
                String str = input.next();
                NumberOutOfRange numberOutOfRange = new NumberOutOfRange();
                InvalidInputException invalidInputException = new InvalidInputException();
                try {
                    int entry = invalidInputException.checkInput(str);
                    numberOutOfRange.checkRange(entry);
                }catch (InvalidInputException ex1){
                    System.out.println("Invalid enter a number");
                    i--;
                }
                catch (NumberOutOfRange ex2){
                    System.out.println("out of range enter a number between "+num1+" and "+ num2);
                    i--;

                }

            }
        }
    }


}
