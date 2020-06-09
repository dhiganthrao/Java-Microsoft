//Fraction.java. Made to be used along with FracCalc.java.
//V 1.0

public class Fraction {
    private int num ;
    private int den ;

    public Fraction (){
        this (0, 1);
    }

    public Fraction (int n){
        this (n , 1);
    }

    public Fraction (int n, int d){
        if ( d == 0 ) {
            throw new IllegalArgumentException("Denominator is zero.");
        } else {
            this.num = n;
            this.den = d;

            if ( d < 0 ){
                this.den = Math.abs(d);
                this.num = ~(n);
            }
        }
    }

    public int getNumerator(){
        return this.num;
    }

    public int getDenominator(){
        return this.den;
    }

    public String toString(){

        if (getDenominator() == 1) {
            return getNumerator() + "";
        } else {
            return getNumerator() + "/" + getDenominator();
        }
    }

    public Double toDouble(){
        return (double) this.getNumerator() / this.getDenominator();
    }

    public Fraction add(Fraction other){

        Fraction sum;
        int numerator;
        int denominator;

        numerator = ( this.getNumerator() * other.getDenominator() ) + ( other.getNumerator() * this.getDenominator() );
        denominator = ( this.getDenominator() * other.getDenominator() );

        if (this.getDenominator() == other.getDenominator()) {
            numerator = ( this.getNumerator() + other.getNumerator());
            denominator = ( this.getDenominator() );
        }

        sum = new Fraction(numerator,denominator);
        sum.toLowestTerm();

        if (denominator == 1) {
            sum.toDouble();
        }

        return sum;
    }

    public Fraction subtract(Fraction other){

        Fraction difference;
        int lcm;
        int numerator;
        int denominator;

        if ( this.getDenominator() % other.getDenominator() == 0 ) {
            lcm = this.getDenominator() / other.getDenominator();
            denominator = this.getDenominator();
            numerator = ( this.getDenominator() - ( other.getNumerator() * lcm ) );

        } else if ( other.getDenominator() % this.getDenominator() == 0 ) {
            lcm = other.getDenominator() / this.getDenominator();
            denominator = other.getDenominator();
            numerator = ( ( this.getNumerator() * lcm )  - ( other.getNumerator() ) );

        } else {
            lcm = other.getDenominator() * this.getDenominator() ;
            lcm = ( ( lcm / 2 ) % 2 == 0 ) ? lcm / 2 : lcm;

            int thisLCD = lcm / this.getDenominator();
            int otherLCD = lcm / other.getDenominator();

            numerator = ( ( this.getNumerator() * thisLCD ) - ( other.getNumerator() * otherLCD ) );
            denominator = lcm;

        }

        if (this.getDenominator() == other.getDenominator()) {
            numerator = ( this.getNumerator() - other.getNumerator());
            denominator = ( this.getDenominator() );

        }

        difference = new Fraction(numerator,denominator);
        difference.toLowestTerm();

        if (denominator == 1)
        {
            difference.toDouble();
        }

        return difference;
    }

    public Fraction multiply(Fraction other){

        Fraction product;
        int numerator;
        int denominator;

        numerator = this.getNumerator() * other.getNumerator();
        denominator = this.getDenominator() * other.getDenominator();

        product = new Fraction(numerator,denominator);
        product.toLowestTerm();

        if (denominator == 1)
        {
            product.toDouble();
        }

        return product;
    }

    public Fraction divide(Fraction other){

        Fraction quotient;
        int numerator;
        int denominator;

        numerator = this.getNumerator() * other.getDenominator();
        denominator = this.getDenominator() * other.getNumerator();

        quotient = new Fraction(numerator,denominator);
        quotient.toLowestTerm();

        if (denominator == 1)
        {
            quotient.toDouble();
        }

        return quotient;
    }

    public boolean CheckEqual(Object otherFraction){

        return this.toString().equals(otherFraction.toString());
    }

    public void toLowestTerm(){

        int gcd = gcd (this.getNumerator(), this.getDenominator());
        this.num = this.getNumerator() / gcd;
        this.den = this.getDenominator() / gcd;
    }

    public static int gcd(int num , int den){
        while (num != 0 && den != 0) {
            int rem = num % den;
            num = den;
            den = rem;
        }
        return num;
    }
}