//FractionCalculator. Made by Dhiganth Rao for Module 2.
//V 1.0
import java.util.*;
import static java.lang.System.exit;

class FractionCalculator {

    private final static String choices ="+-/*=qQ";
    private final static String numbers = "1234567890";
    private static final Scanner scanner = new Scanner(System.in);
    private static int num = 0, den = 0, separator;
    private static String userOperation = "Start";
    private static boolean result;
    private static Fraction myfractionOne, myfractionTwo ;

    static String getOperation(Scanner input){

        String operation = input.next();
        if ( choices.indexOf(operation) != -1 ){
            return operation;
        } else {
            Console("Invalid input (+, -, /, *, = or Q to quit): ");
            return getOperation(input);
        }

    }

    static Fraction getFraction(Scanner input){
        String getFract = input.next();
        if (validFraction(getFract) ) {
            if (den == 0) {
                return new Fraction(num);
            } else {
                return new Fraction(num, den);
            }
        } else {
            Console("Invalid fraction. Please enter (a/b) or integer (a), where a and b are integers and b is not zero:");
            return getFraction(input);
        }
    }

    static boolean validFraction(String getFract){

        int a = 1; //true
        num = 0;
        den = 0;

        if ( getFract.indexOf( '-' , 1 ) == -1 || getFract.charAt(0) == -'/' ) {

            separator = getFract.indexOf( '/' );
            if ( getFract.indexOf( '/' ) != -1 ) {

                String numerator = getFract.substring( 0,separator );
                String denominator = getFract.substring( separator + 1 );
                String numTemp = ( getFract.charAt(0) == '-' ) ? numerator.substring( 1,separator ) : numerator.substring(0,separator);

                if ( isNumber(numTemp)  && ( isNumber(denominator) && Integer.parseInt(denominator) != 0 ) ) {
                    a = 1; // True
                    num = Integer.parseInt(numerator);
                    den = Integer.parseInt(denominator);
                } else {
                    a = 0; // False
                }

            } else {

                result = ( getFract.charAt(0) == '-' ) ? isNumber(getFract.substring(1)) : isNumber(getFract);
                if ( result ) {
                    num = Integer.parseInt(getFract);
                    den = 0;
                    a = 1; // True
                } else {
                    a = 0; //True
                }

            }

        } else {
            a = 0; // False
        }

        return a == 1;
    }

    static boolean isNumber(String num){
        int a = 1; //true
        for (int i = 0 ; i < num.length(); i ++){
            if ( numbers.indexOf(num.charAt(i)) == -1 ) {
                a = 0; //false;
            }
        }
        return a == 1;
    }

    static boolean quit(String input){
        return userOperation.toLowerCase().indexOf("q") == 0;
    }

    static void Console(String str){
        System.out.print(str);
    }

    static void Debug(String str){
        System.out.print(str);
    }

    static void lineCutter(char c, int n) {
        if (n == 0){
            Console("\n");
        }
        else {
            Console("" + c);
            lineCutter(c, n - 1);
        }
    }

    public static void main(String[] args){

        Console("\nThis program is a fraction calculator.\n");
        Console("It will add, subtract, multiply and divide integers / fractions until you type Q to quit.\n");
        Console("Please enter your fractions in the form a/b, where a and b are integers.\n");
        lineCutter('*',50);

        do {
            Console("Please enter an operation (+, -, /, *, = or Q to Quit): ");
            userOperation = getOperation(scanner);
            if (quit(userOperation)) {
                exit(0);
            }

            Console("Please enter a fractions (a/b) or integer (a):");
            myfractionOne = getFraction(scanner);

            Console("Please enter a fractions (a/b) or integer (a):");
            myfractionTwo = getFraction(scanner);

            Console(myfractionOne + " " + userOperation + " " + myfractionTwo + " = ");

            myfractionOne.toLowestTerm();
            myfractionTwo.toLowestTerm();

            switch (userOperation) {
                case "+":
                    Console("" + myfractionOne.add(myfractionTwo));
                    break;
                case "-":
                    Console("" + myfractionOne.subtract(myfractionTwo));
                    break;
                case "*":
                    Console("" + myfractionOne.multiply(myfractionTwo));
                    break;
                case "/":
                    Console("" + myfractionOne.divide(myfractionTwo));
                    break;
                case "=":
                    Console("" + myfractionOne.equals(myfractionTwo));
                    break;
                default:
            }

            Console("\n");
            lineCutter('*', 50);

        } while ( !quit(userOperation) );

    }

}